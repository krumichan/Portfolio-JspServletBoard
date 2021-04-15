package exe.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.DepartmentDAO;
import exe.dao.SubjectDAO;
import exe.entity.DepartmentEntity;
import exe.entity.SubjectEntity;
import exe.entity.TeacherEntity;

public class SubjectListCommand implements Command {

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
			SubjectDAO sDao = new SubjectDAO();
			ArrayList<SubjectEntity> subjects = sDao.searchSubjectByDepartment(teacher.getDeptCode());
			
			DepartmentDAO dDao = new DepartmentDAO();
			List<DepartmentEntity> departments = (List<DepartmentEntity>)dDao.getDepartmentList();
			
			List<DepartmentEntity> result = 
					departments.stream()
					.filter(dept -> teacher.getDeptCode().equals(dept.getDeptCode()))
					.collect(Collectors.toList());
			
			String deptName = null;
			if (result.size() > 0) {
				deptName = result.get(0).getDeptName();
			}
			
			request.setAttribute("subjectList", subjects);
			request.setAttribute("deptName", deptName);
			
			action.setPath("WEB-INF/subjectList.jsp");
			action.setSend(false);;
			
		}
		
		return action;
	}

}
