package groupproject;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class customer {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mechanic_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Vamsi@1804";
    Scanner sc = new Scanner(System.in);
    
    public void registerCustomer() {
    	System.out.println("YOU ARE NOW REGISTERING ");
    	System.out.println("Enter user id:-");
		int customer_id=sc.nextInt();
		System.out.println("Enter user name");
		String customer_name =sc.next();
		System.out.println("Enter your mobile number");
		String cust_mobile_no=sc.next();
		System.out.println("Enter your vehicle no");
		String vehicle_no= sc.next();
		System.out.println("Enter your address");
		String customer_address= sc.next();
		
		
		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = con.createStatement();

            String insertQuery="insert into customer values('"+customer_id+"','"+customer_name+"','"+vehicle_no+"','"+cust_mobile_no+"','"+customer_address+"')";
			
            int res = st.executeUpdate(insertQuery);
            if (res == 0) {
                System.out.println("Record not inserted");
            } else {
                System.out.println("Record inserted");
            }

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public void modifyCustomerDetails() {
    	System.out.println("YOU ARE NOW MODIFYING CUSTOMER DETAILS ");
    	try {
    		
    	Class.forName("com.mysql.cj.jdbc.Driver");
        
		System.out.println("Enter customer id to update:-");
		int a2=sc.nextInt();
		
		int I11;
		do {
	    System.out.println("What do you want to modify?");
		System.out.println("      1.Name               ");
		System.out.println("      2.Mobile number      ");
		System.out.println("      3.Vehicle number     ");
		System.out.println("      4.Address            ");
		System.out.println("      0.exit               ");
		
		I11=sc.nextInt();
		String updateQuery = "";
	    switch(I11) {
	   
	    case 1:
	    	Connection con6 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st6=con6.createStatement();
	    	System.out.println("Enter the name :-");
			String a21=sc.next();
			
			updateQuery="update customer set customer_name= '"+a21+"' where customer_id= '"+a2+"'";
			
			int res6=st6.executeUpdate(updateQuery);
			
			if(res6==0)
			{
				System.out.println("Record not updated");
			}
			else
			{ 
				System.out.println("Record  updated");
			}	
				
			
			
			st6.close();
			con6.close();
			break;
			
		case 2:
			Connection con7 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st7=con7.createStatement();
	    	System.out.println("Enter the mobile number :-");
			String a22=sc.next();
			
			updateQuery="update customer set cust_mobile_no= '"+a22+"' where customer_id= '"+a2+"'";
			int res7=st7.executeUpdate(updateQuery);
			
			if(res7==0)
			{
				System.out.println("Record not updated");
			}
			else
			{ 
				System.out.println("Record  updated");
			}	
				
			
			
			st7.close();
			con7.close();
			break;
			
	    case 3:
	    	Connection con11 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st11=con11.createStatement();
	    	System.out.println("Enter the vehicle number :-");
			String a26=sc.next();
			
			updateQuery="update customer set vehicle_no= '"+a26+"' where customer_id= '"+a2+"'";
			int res11=st11.executeUpdate(updateQuery);
			
			if(res11==0)
			{
				System.out.println("Record not updated");
			}
			else
			{ 
				System.out.println("Record  updated");
			}	
				
			
			
			st11.close();
			con11.close();
			break;
	    case 4:
	    	Connection con12 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st12=con12.createStatement();
	    	System.out.println("Enter the address :-");
			String a27=sc.next();
			
			updateQuery="update customer set customer_address= '"+a27+"' where customer_id= '"+a2+"'";
			int res12=st12.executeUpdate(updateQuery);
			
			if(res12==0)
			{
				System.out.println("Record not updated");
			}
			else
			{ 
				System.out.println("Record  updated");
			}	
				
			
			
			st12.close();
			con12.close();
			break;
	    case 0:
			break;
			
		default :
			System.out.println("Enter valid input");
	    }
			
		
		}while(I11 != 0);
	
		}catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
    }
    public void deleteCustomerRecord() {
    	System.out.println("YOU ARE NOW DELETING A RECORD");
		System.out.println("  DO YOU  REALLY WANT TO DELETE ?");
		System.out.println(" PRESS 1 TO DELETE ");
		System.out.println("PRESS ANY OTHER KEY TO CANCEL");
		int S= sc.nextInt();
		if(S == 1) {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con2 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement st2=con2.createStatement();
        
		System.out.println("Enter customer id to delete:-");
		int a=sc.nextInt();
		
		String deleteQuery="delete from customer where customer_id= '"+a+"'";
		
		int res2=st2.executeUpdate(deleteQuery);
		//System.out.println("hello world")
		if(res2==0)
		{
			System.out.println("Record not deleted");
		}
		else
		{ 
			System.out.println("Record  deleted");
		}	
			
		
		
		st2.close();
		con2.close();
    	}catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
		}
		else {
			
		}
		
    }
    public void viewSingleRecord() {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con4 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement st4=con4.createStatement();
        
		System.out.println("Enter customer id to print values:-");
		int a4=sc.nextInt();
		
		String selectQuery="select * from customer where customer_id= ?";
		PreparedStatement preparedStatement=con4.prepareStatement(selectQuery);
		preparedStatement.setInt(1, a4);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
            int custId = resultSet.getInt("customer_id");
            String custName = resultSet.getString("customer_name");
            String custmobno= resultSet.getString("cust_mobile_no");
            String vehicleNo=resultSet.getString("vehicle_no");
            String addr=resultSet.getString("customer_address");

            System.out.println("Customer ID: " + custId);
            System.out.println("Customer Name: " + custName);
            System.out.println("customer mobile number"+custmobno);
            System.out.println("vehicle Number: " + vehicleNo);
            System.out.println("Customer address: " + addr);
            System.out.println();
            
                               }
		st4.close();
		con4.close();

        resultSet.close();
        preparedStatement.close();
    	}catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
    }
    
    public void viewAllRecords() {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con5 = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String selectQuery1 = "SELECT * FROM customer";
        PreparedStatement preparedStatement1 = con5.prepareStatement(selectQuery1);

        ResultSet resultSet1 = preparedStatement1.executeQuery();

        while (resultSet1.next()) {
        	int custId = resultSet1.getInt("customer_id");
            String custName = resultSet1.getString("customer_name");
            String custmobno= resultSet1.getString("cust_mobile_no");
            String vehicleNo=resultSet1.getString("vehicle_no");
            String addr=resultSet1.getString("customer_address");

            System.out.println("Customer ID: " + custId);
            System.out.println("Customer Name: " + custName);
            System.out.println("customer mobile number: "+custmobno);
            
            System.out.println("vehicle Number: " + vehicleNo);
            System.out.println("Customer address: " + addr);
            System.out.println();
        }

        resultSet1.close();
        preparedStatement1.close();
        con5.close();
    	}catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
    }
}