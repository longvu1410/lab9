package Task1;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}

	public boolean hasMoreStudentsThan(Course otherCourse) {
		if (this.getType().equalsIgnoreCase("Thực Hành") && otherCourse.getType().equalsIgnoreCase("Lý Thuyết")) {
			return this.getStudents().size() > otherCourse.getStudents().size();
		} else if (this.getType().equalsIgnoreCase("Lý Thuyết")
				&& otherCourse.getType().equalsIgnoreCase("Thực Hành")) {
			return false;
		} else {
			return this.getStudents().size() > otherCourse.getStudents().size();
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public void add(Student st) {
		students.add(st);
	}

	public List<Student> getStudents() {
		return students;
	}
}