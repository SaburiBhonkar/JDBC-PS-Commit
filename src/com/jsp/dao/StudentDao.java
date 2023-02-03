package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {
	HelperClass hc = new HelperClass();
	Connection connection = null;

	public Student insertStudent(Student s) throws SQLException {

		connection = hc.getConnection();
		String sql = "Insert into student  values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, s.getId());
			preparedStatement.setString(2, s.getName());
			preparedStatement.setString(3, s.getEmail());

			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return s;
	}

	public Student deleteStudent(Student s) throws SQLException {
		connection = hc.getConnection();
		String sql = "delete from student where id =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, s.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return s;
	}

	public Student updateStudent(Student s) throws SQLException {
		connection = hc.getConnection();
		String sql = "update student set name=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s.getName());
			preparedStatement.setInt(2, s.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return s;
	}

	public List<Student> addMulStudents(List<Student> s) throws SQLException {
		connection = hc.getConnection();
		String sql = "Insert into student values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for (Student s1 : s) {
				preparedStatement.setInt(1, s1.getId());
				preparedStatement.setString(2, s1.getName());
				preparedStatement.setString(3, s1.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return s;
	}

}
