package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Faculty() {
		this.courses = new ArrayList<>(); // Initialize the list in the constructor
	}

	public Course getMaxPracticalCourse() {
		Course maxPraticalCourse = courses.get(0);
		for (int i = 0; i < courses.size(); i++) {
			if (maxPraticalCourse.hasMoreStudentsThan(courses.get(i))) {
				maxPraticalCourse = courses.get(i);
			}
		}
		return maxPraticalCourse;

	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> yearMap = new HashMap<>();

		for (Course course : courses) {
			for (Student stud : course.getStudents()) {
				int year = stud.getYear();
				if (!yearMap.containsKey(year)) {
					yearMap.put(year, new ArrayList<>());
				}
				yearMap.get(year).add(stud);
			}
		}

		return yearMap;

	}

	public Set<Course> filterCourses(String type) {
		List<Course> courses = getAllCourse();
		Set<Course> subjectsDecrease = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.getStudents().size(), o1.getStudents().size());
			}

		});

		for (Course course : courses) {
			if (course.getType().equals(type)) {
				subjectsDecrease.add(course);
			}
		}

		return subjectsDecrease;

	}

	private List<Course> getAllCourse() {

		List<Course> newCoursess = new ArrayList<>();
		for (Course course : courses) {
			newCoursess.add(course);
		}
		return newCoursess;
	}

	public static void main(String[] args) {
		List<Student> st1 = Arrays.asList(new Student("1", "John", 3), new Student("2", "Alice", 2));
		List<Student> st2 = Arrays.asList(new Student("3", "Bob", 4), new Student("4", "Eve", 3),
				new Student("5", "Charlie", 2));
		List<Student> st3 = Arrays.asList(new Student("6", "Bobb", 4), new Student("7", "iva", 4),
				new Student("8", "tony", 4));

		Course co = new Course("1", "toan", "Lý Thuyết", st1, "Mr Black");
		Course co1 = new Course("2", "ly", "Thực Hành", st2, "Mr White");
		Course co2 = new Course("3", "hoa", "Lý Thuyết", st3, "Mr Black");

		List<Course> courses = Arrays.asList(co, co1, co2);

		Faculty f1 = new Faculty("fit", "nlu", courses);
		if (co.hasMoreStudentsThan(co1)) {
			System.out.println(co.getTitle() + " có nhiều sinh viên hơn " + co1.getTitle());
		} else {
			System.out.println(co1.getTitle() + " có nhiều sinh viên hơn " + co.getTitle());
		}

		Map<Integer, List<Student>> yearMap = f1.groupStudentsByYear();

		for (Map.Entry<Integer, List<Student>> entry : yearMap.entrySet()) {
			int year = entry.getKey();
			List<Student> students = entry.getValue();
			System.out.println("Year" + students);
		}
		Faculty yourClass = new Faculty();
		Set<Course> result = yourClass.filterCourses("Lý Thuyết");
		result.add(co1);
		result.add(co2);

		for (Course course : result) {
			System.out.println(course.getTitle() + " " + course.getStudents().size());
		}
	}
}