package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.TeacherDAO;
import exe.entity.TeacherEntity;

public class TeacherInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		
		TeacherEntity teacher = new TeacherEntity();
		teacher.setId(request.getParameter("id"));
		teacher.setPw(request.getParameter("pw"));
		teacher.setName(request.getParameter("name"));
		teacher.setDeptCode(request.getParameter("deptCode"));
		teacher.setAddress(request.getParameter("address"));
		
		TeacherDAO dao = new TeacherDAO();
		boolean result = dao.addTeacher(teacher);
		
		if (result) { request.setAttribute("code", "10"); }
		else		{ request.setAttribute("code", "11"); }
		
		action.setPath("WEB-INF/result.jsp");
		action.setSend(false);
		
		return action;
	}

}
