package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;
import exe.dao.SubjectDAO;
import exe.entity.LectureEntity;
import exe.entity.SubjectEntity;
import exe.entity.TeacherEntity;

public class LectureListCommand implements Command {

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
			LectureDAO lDao = new LectureDAO();
			ArrayList<LectureEntity> lectures = lDao.searchLecture(teacher.getId());
			
			SubjectDAO sDao = new SubjectDAO();
			ArrayList<SubjectEntity> subjects = new ArrayList<SubjectEntity>(); 

			for(LectureEntity lecture : lectures) {
				subjects.add(sDao.searchSubjectById(lecture.getSubId()));
			}
			
			request.setAttribute("lectureList", lectures);
			request.setAttribute("subjectList", subjects);
			
			action.setPath("WEB-INF/lectureList.jsp");
			action.setSend(false);
		}
		return action;
	}

}
