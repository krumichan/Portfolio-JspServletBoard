package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.TeacherDAO;
import exe.entity.TeacherEntity;

public class TeacherUpdateCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		TeacherEntity member = (TeacherEntity)session.getAttribute("member");
		
		if (member == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
			
		} else {
			request.setCharacterEncoding("UTF-8");
			
			TeacherEntity teacher = new TeacherEntity();
			teacher.setId(member.getId());
			teacher.setPw(request.getParameter("pw"));
			teacher.setName(request.getParameter("name"));
			teacher.setDeptCode(request.getParameter("deptCode"));
			teacher.setAddress(request.getParameter("address"));

			TeacherDAO dao = new TeacherDAO();
			boolean result = dao.updateTeacher(teacher);
			
			session.setAttribute("member", teacher);
			
			if(result) 	{ request.setAttribute("code", "21"); } 
			else 		{ request.setAttribute("code", "20"); }
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
			
		}
		
		return action;
	}

}
