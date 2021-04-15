package exe.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommonDAO {
	DataSource ds;
	
	public CommonDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/oracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
			
		}

	}
}
