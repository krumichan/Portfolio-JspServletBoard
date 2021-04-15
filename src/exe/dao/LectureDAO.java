package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exe.entity.LectureEntity;

public class LectureDAO extends CommonDAO {

	public ArrayList<LectureEntity> searchLecture(String teacherId) {
		ArrayList<LectureEntity> lectureList = new ArrayList<LectureEntity>();
		
		String sql =
			" SELECT	* "
			+ " FROM	TBL_LECTURE "
			+ "	WHERE	T_ID = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, teacherId);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				LectureEntity lecture = new LectureEntity();
				lecture.setLecNum(rs.getInt("LEC_NUM"));
				lecture.settId(rs.getString("T_ID"));
				lecture.setSubId(rs.getString("SUB_ID"));
				lectureList.add(lecture);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return lectureList;
	}

	public boolean addLecture(String subjectId, String teacherId) {
		boolean result = false;
		
		String sql = 
			" INSERT INTO	TBL_LECTURE "
			+ " VALUES ( SEQ_LECTURE.NEXTVAL, ?, ? ) ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, teacherId);
			stmt.setString(2, subjectId);
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				result = true;
				conn.commit();
				
			} else {
				conn.rollback();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		
		return result;
	}

	public boolean isDuplication(String subjectId, String teacherId) {
		boolean isDups = false;
		
		String sql =
			" SELECT	COUNT(*) "
			+ " FROM	TBL_LECTURE "
			+ " WHERE	SUB_ID = ? "
			+ " AND		T_ID = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, subjectId);
			stmt.setString(2, teacherId);
			
			rs = stmt.executeQuery();
			
			rs.next();
			isDups = rs.getInt(1) == 1 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return isDups;
	}

	public boolean cancelLecture(String lecNum) {
		boolean result = false;
		
		String sql =
			" DELETE FROM	TBL_LECTURE "
			+ " WHERE 		LEC_NUM = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(lecNum));
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				result = true;
				conn.commit();
				
			} else {
				conn.rollback();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return result;		
	}

}
