package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class P2 {
	public static void main(String args[]) {
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/PROJECT";
		String user = "root";
		String pwd = "";

		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully connected to database");
		Scanner input = new Scanner(System.in);
		System.out.println("welcome to our programm");
		System.out.println("choose an option");
		System.out.println("1-insert new product");
		System.out.println("2-display all the products");
		System.out.println("change price ");
		System.out.print("your choice :");
		int choice;
		try {
			choice = input.nextInt();
		} catch (Exception e) {
			choice = 5;
		}
		switch (choice) {
		case 1:

			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;
		}

	}
}
