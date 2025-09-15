package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeDao {

	public void insertData() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/advjava";
		String user = "root";
		String pswd = "12345";

		Connection cn = DriverManager.getConnection(url, user, pswd);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id: ");
		int eid = Integer.parseInt(sc.nextLine());

		System.out.print("Enter Employee name: ");
		String ename = sc.nextLine();

		System.out.print("Enter Department: ");
		String dept = sc.nextLine();

		System.out.print("Enter Employee Salary: ");
		float sal = Float.parseFloat(sc.nextLine());

		String query = "INSERT INTO employee(eid, ename, dept, salary) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = cn.prepareStatement(query);

		ps.setInt(1, eid);
		ps.setString(2, ename);
		ps.setString(3, dept);
		ps.setFloat(4, sal);

		int rows = ps.executeUpdate();
		System.out.println(rows + " row(s) inserted successfully.");

		ps.close();
		cn.close();
		sc.close();
	}

	public void getSingleData() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/advjava";
		String user = "root";
		String pswd = "12345";

		Connection cn = DriverManager.getConnection(url, user, pswd);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id to search: ");

		int eid = sc.nextInt();

		String query = "SELECT * FROM employee WHERE eid = ?";
		PreparedStatement ps = cn.prepareStatement(query);

		ps.setInt(1, eid);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("Employee ID: " + rs.getInt("eid"));
			System.out.println("Employee Name:" + rs.getString("ename"));
			System.out.println("Employee Department:" + rs.getString(3));
			System.out.println("Employee Salary:" + rs.getFloat(4));
		}

		else
			System.out.println("Record not found");
		ps.close();
		cn.close();
		sc.close();
	}

	public void getAllData() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/advjava";
		String user = "root";
		String pswd = "12345";

		Connection cn = DriverManager.getConnection(url, user, pswd);

		String query = "SELECT * FROM employee";
		PreparedStatement ps = cn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Employee ID: " + rs.getInt("eid"));
			System.out.println("Employee Name:" + rs.getString("ename"));
			System.out.println("Employee Department:" + rs.getString(3));
			System.out.println("Employee Salary:" + rs.getFloat(4));
			System.out.println();
		}
	}

	public void updateData() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/advjava";
		String user = "root";
		String pswd = "12345";

		Connection cn = DriverManager.getConnection(url, user, pswd);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id to Update: ");
		int eid = Integer.parseInt(sc.nextLine());

		System.out.print("Enter Salary to Update: ");
		float sal = sc.nextFloat();

		String query = "UPDATE employee SET salary = salary + ? WHERE eid = ?";
		PreparedStatement ps = cn.prepareStatement(query);

		ps.setFloat(1, sal);
		ps.setInt(2, eid);

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("Record updated successfully!");
		} else {
			System.out.println("No record found with that ID!");
		}
		ps.close();
		cn.close();
		sc.close();
	}
	
	public void deleteSingleData() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/advjava";
		String user = "root";
		String pswd = "12345";

		Connection cn = DriverManager.getConnection(url, user, pswd);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id to Delete: ");

		int eid = sc.nextInt();

		String query = "DELETE FROM employee WHERE eid = ?";
		PreparedStatement ps = cn.prepareStatement(query);

		ps.setInt(1, eid);

		int rows = ps.executeUpdate();
		if (rows > 0) 
		{
			System.out.println("Record Deleted successfully!");
		} else {
			System.out.println("No record found with that ID!");
		}
		ps.close();
		cn.close();
		sc.close();
	}


}
