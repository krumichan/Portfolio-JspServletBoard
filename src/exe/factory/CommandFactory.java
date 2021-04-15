package exe.factory;

import java.util.HashMap;

import exe.command.*;
import exe.common.Command;

public class CommandFactory {
	private HashMap<String, Command> map = new HashMap<String, Command>();
	private static CommandFactory factory = new CommandFactory();
	
	private CommandFactory () {
		map.put("/exercise/lectureDelete.do", new LectureDeleteCommand());
		map.put("/exercise/lectureInsert.do", new LectureInsertCommand());
		map.put("/exercise/lectureList.do", new LectureListCommand());
		map.put("/exercise/login.do", new LoginCommand());
		map.put("/exercise/loginForm.do", new LoginFormCommand());
		map.put("/exercise/logout.do", new LogoutCommand());
		map.put("/exercise/main.do", new MainCommand());
		map.put("/exercise/subjectDetail.do", new SubjectDetailCommand());
		map.put("/exercise/subjectList.do", new SubjectListCommand());
		map.put("/exercise/teacherInsert.do", new TeacherInsertCommand());
		map.put("/exercise/teacherInsertForm.do", new TeacherInsertFormCommand());
		map.put("/exercise/teacherUpdate.do", new TeacherUpdateCommand());
		map.put("/exercise/teacherUpdateForm.do", new TeacherUpdateFormCommand());
	}
	
	public static CommandFactory getInstance() {
		return factory;
	}
	
	public Command getCommand(String url) {
		return map.get(url);
	}
}
