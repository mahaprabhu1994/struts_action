package com.action.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	
	public int save(int id, String name, String email, float  salary, long phone) throws Exception{
		
		 String  dburl = "jdbc:mysql://localhost:3306/employee";
		 String dbuname = "root";
		 String dbpassword = "maniharish";
		 String dbdriver = "com.mysql.jdbc.Driver";

		 		Class.forName(dbdriver);
				Connection con = DriverManager.getConnection(dburl,dbuname,dbpassword);
				PreparedStatement ps = con.prepareStatement("insert into employee_reg values(?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setFloat(4,salary);
				ps.setLong(5, phone);
				
				int i=ps.executeUpdate();
				con.close();
				return i;		
	}
}
