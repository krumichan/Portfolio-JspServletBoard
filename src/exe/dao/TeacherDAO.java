package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exe.entity.TeacherEntity;

public class TeacherDAO extends CommonDAO {
	
	public TeacherEntity login(TeacherEntity teacher) {
		String sql =
			" SELECT	* "
			+ " FROM 	TBL_TEACHER "
			+ " WHERE	T_ID = ? "
			+ " AND		T_PASS = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, teacher.getId());
			stmt.setString(2, teacher.getPw());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				teacher.setName(rs.getString("T_NAME"));
				teacher.setDeptCode(rs.getString("DEPT_CODE"));
				teacher.setAddress(rs.getString("T_ADDR"));
			} else {
				teacher = null;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return teacher;
	}
	
	public boolean addTeacher(TeacherEntity teacher) {
		boolean result = false;

		String sql = 
			" INSERT INTO	TBL_TEACHER "
			+ " VALUES ( ?, ?, ?, ?, ? ) ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, teacher.getId());
			stmt.setString(2, teacher.getPw());
			stmt.setString(3, teacher.getName());
			stmt.setString(4, teacher.getDeptCode());
			stmt.setString(5, teacher.getAddress());
			
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

	public boolean updateTeacher(TeacherEntity teacher) {
		boolean result = false;
		
		String sql =
			" UPDATE	TBL_TEACHER "
			+ " SET		T_PASS = ? "
			+ "			,T_NAME = ? "
			+ "			,DEPT_CODE = ?"
			+ "			,T_ADDR = ? "
			+ " WHERE	T_ID = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, teacher.getPw());
			stmt.setString(2, teacher.getName());
			stmt.setString(3, teacher.getDeptCode());
			stmt.setString(4, teacher.getAddress());
			stmt.setString(5, teacher.getId());
			
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
