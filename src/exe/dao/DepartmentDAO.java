package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exe.entity.DepartmentEntity;

public class DepartmentDAO extends CommonDAO {
	
	public ArrayList<DepartmentEntity> getDepartmentList() {
		ArrayList<DepartmentEntity> departmentList = new ArrayList<DepartmentEntity>();
		
		String sql = 
			" SELECT	* "
			+ " FROM	TBL_DEPARTMENT ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				DepartmentEntity department = new DepartmentEntity();
				department.setDeptCode(rs.getString("DEPT_CODE"));
				department.setDeptName(rs.getString("DEPT_NAME"));
				departmentList.add(department);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
			
		}
		
		return departmentList;
	}
}
