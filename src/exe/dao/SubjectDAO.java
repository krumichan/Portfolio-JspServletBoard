package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exe.entity.SubjectEntity;

public class SubjectDAO extends CommonDAO {

	public ArrayList<SubjectEntity> searchSubjectByDepartment(String department) {
		ArrayList<SubjectEntity> subjectList = new ArrayList<SubjectEntity>();
		
		String sql = 
			" SELECT	* "
			+ " FROM	TBL_SUBJECT "
			+ " WHERE	DEPT_CODE = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, department);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				SubjectEntity subject = new SubjectEntity();
				subject.setSubId(rs.getString("SUB_ID"));
				subject.setSubName(rs.getString("SUB_NAME"));
				subject.setSubInfo(rs.getString("SUB_INFO"));
				subject.setDeptCode(rs.getString("DEPT_CODE"));
				subjectList.add(subject);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return subjectList;
	}

	public SubjectEntity searchSubjectById(String subjectId) {
		SubjectEntity subject = null;
		
		String sql =
			" SELECT	* "
			+ " FROM 	TBL_SUBJECT "
			+ " WHERE	SUB_ID = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, subjectId);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				subject = new SubjectEntity();
				subject.setSubId(rs.getString("SUB_ID"));
				subject.setSubName(rs.getString("SUB_NAME"));
				subject.setSubInfo(rs.getString("SUB_INFO"));
				subject.setDeptCode(rs.getString("DEPT_CODE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return subject;
	}

}
