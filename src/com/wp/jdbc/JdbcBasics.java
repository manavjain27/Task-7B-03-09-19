package com.wp.jdbc;
import java.sql.*;
import java.util.*;
public class JdbcBasics {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String server="jdbc:mysql://localhost:3306/abc";
			String user="root";
			String password="root";
			
			con=DriverManager.getConnection(server,user,password);
			Statement st=con.createStatement();
			
			
				System.out.println("1.Insertion ");
				System.out.println("2.Updation ");
				System.out.println("3.Deletion ");
				System.out.println("4.Create Table ");
				System.out.println("5.Alter Table ");
				System.out.println("6.Exit ");
				
				while(true)
				{
				System.out.println("\nEnter Choice");
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:																//Insertion
					
					int eno=1;
					String ename="Manav";
					int esal=5000;
					
					
					String sql="insert into emp values('"+eno+"','"+ename+"','"+esal+"');";
					if(st.executeUpdate(sql)>0)
					{
						System.out.println("\nRecord Saved");
					}
					
					else
						System.out.println("\nCannot Insert");
					break;
					
				case 2:																		//Updation
					
					eno=1;
					ename="Shivam";
					esal=7000;
					
					sql="update emp set empno='"+eno+"',ename='"+ename+"',esal='"+esal+"';";
					
					if(st.executeUpdate(sql)>0)
						System.out.println("\nRecord Updated");
					else
						System.out.println("\nCannot Update");

					break;
				
				case 3:																	//Deletion
					
					eno=1;
					sql="delete from emp where empno='"+eno+"';";
					if(st.executeUpdate(sql)>0)
						System.out.println("\nRecord Deleted");
					else
						System.out.println("\nCannot Delete");
					break;
					
				case 4:																	//Create Table
					
					sql="create table tmp(id int primary key,name varchar(20))";
					if(st.executeUpdate(sql)>=0)
						System.out.println("\nTable Created");
					else
						System.out.println("\nCannot Create Table");
					
					break;
					
				case 5:																	//Alter Table
					
					sql="alter table emp add designation varchar(20)";
					
					if(st.executeUpdate(sql)>0)
						System.out.println("\nTable Altered");
					else
						System.out.println("\nCannot Alter Table");
					break;
					
				case 6:
					System.exit(0);
					
				default:
					System.out.println("Wrong choice");
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sc.close();
	}

}
