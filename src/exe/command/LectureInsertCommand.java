package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;
import exe.entity.TeacherEntity;

public class LectureInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		TeacherEntity teacher = (TeacherEntity)session.getAttribute("member");
		
		if (teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
			
		} else {
			String subId = request.getParameter("subId");
			
			LectureDAO dao = new LectureDAO();
			boolean duplication = dao.isDuplication(subId, teacher.getId());
			
			if (duplication) { request.setAttribute("code", "32"); }
			else {
				boolean result = dao.addLecture(subId, teacher.getId());
				
				if (result) { request.setAttribute("code", "30"); }
				else		{ request.setAttribute("code", "31"); }
			}
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
