package com.jsp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestDriver {

	public static void main(String[] args) throws SQLException {
		StudentDao sd = new StudentDao();
		ArrayList<Student> al = new ArrayList<>();
		Student s1 = new Student();
		s1.setId(4);
		s1.setName("a");
		s1.setEmail("a@gmail.com");

		Student s2 = new Student();
		s2.setId(5);
		s2.setName("b");
		s2.setEmail("b@gmail.com");

		Student s3 = new Student();
		s3.setId(6);
		s3.setName("c");
		s3.setEmail("c@gmail.com");

		Student s4 = new Student();
		s4.setId(7);
		s4.setName("d");
		s4.setEmail("d@gmail.com");

		Student s5 = new Student();
		s5.setId(8);
		s5.setName("e");
		s5.setEmail("e@gmail.com");

		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);

		sd.addMulStudents(al);

	}
}
