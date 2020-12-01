package ProjectDriver;

import java.util.List;


import configuration.Server;


public class ProjectDriver {

	public static void main(String[] args) {
		
		new Server();
		
		
		/*to run save student
		studentHib studenthib = new studentHib();
		System.out.println("Creating Student");
		Student student = new Student(1, "John", "McGuin", "johnmcguin101@gmail.com", 11118);
		//studenthib.saveStudent(new Student(1, "John", "McGuin", "johnmcguin101@gmail.com", 11118));
		System.out.println("Saving Student");
		studenthib.saveStudent(student);
		System.out.println("Done");
		//to run save student
		
		
		QueryHib.saveQuery(new Query(1, "25-11-2020", "6:27", "Financial", "Money Test", 3))
		/*To updateStudent
		student.setFirstName("Lone");
		studenthib.updateStudent(student);
		
		//To run getStudentById
		Student student2 = studenthib.getStudentById(student.getStuId());
		
		//To run getAllStudents
		List<Student> students = studenthib.getAllStudents();
		students.forEach(student1 -> System.out.println(student.getStuId()));
		
		//To deleteStudents
		studenthib.deleteStudent(student.getStuId());*/
	}

}
