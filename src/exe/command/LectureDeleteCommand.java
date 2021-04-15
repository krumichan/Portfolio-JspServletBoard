package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;

public class LectureDeleteCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		Object teacher = session.getAttribute("member");
		
		if (teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(false);
			
		} else {
			String lecNum = request.getParameter("lecNum");
			
			LectureDAO dao = new LectureDAO();
			boolean result = dao.cancelLecture(lecNum);
			
			if (result) { request.setAttribute("code", "40"); }
			else		{ request.setAttribute("code", "41"); }
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
			
		}
		
		return action;
	}

}
