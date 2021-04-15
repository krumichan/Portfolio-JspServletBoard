package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.TeacherDAO;
import exe.entity.TeacherEntity;

public class LoginCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		TeacherEntity teacher = new TeacherEntity();
		teacher.setId(request.getParameter("id"));
		teacher.setPw(request.getParameter("pw"));
		
		TeacherDAO dao = new TeacherDAO();
		teacher = dao.login(teacher);
		
		if (teacher == null) {
			request.setAttribute("code", "00");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member", teacher);
			
			action.setPath("main.do");
			action.setSend(true);
			
		}
		
		return action;
	}

}
