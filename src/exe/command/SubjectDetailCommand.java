package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.SubjectDAO;
import exe.entity.SubjectEntity;

public class SubjectDetailCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		Object teacher = session.getAttribute("member");
		
		if (teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(true);;
			
		} else {
			request.setCharacterEncoding("UTF-8");
			
			String subId = request.getParameter("subId");
			String deptName = request.getParameter("deptName");
			
			SubjectDAO dao = new SubjectDAO();
			SubjectEntity subject = dao.searchSubjectById(subId);

			request.setAttribute("subject", subject);
			request.setAttribute("deptName", deptName);
			
			action.setPath("WEB-INF/subjectDetail.jsp");
			action.setSend(false);
			
		}
		
		return action;
	}

}
