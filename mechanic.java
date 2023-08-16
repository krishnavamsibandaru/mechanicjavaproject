package groupproject;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class mechanic {
	Scanner sc = new Scanner(System.in);
    
    public void viewSingleRecord() {
    	
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con4=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/mechanic_db", "root","Vamsi@1804");
		Statement st4=con4.createStatement();
        
		System.out.println("Enter mechanic id to print values:-");
		int a4=sc.nextInt();
		
		String selectQuery="select * from mechanic where mech_id= ?";
		PreparedStatement preparedStatement=con4.prepareStatement(selectQuery);
		preparedStatement.setInt(1, a4);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
            int mechId = resultSet.getInt("mech_id");
            String mechName = resultSet.getString("mech_name");
            String mechMobile=resultSet.getString("mech_mob");
            String mechEmail= resultSet.getString("mech_email");
            String mechTime=resultSet.getString("mech_time");
            String mechArea=resultSet.getString("mech_exp");

            System.out.println("Mechanic ID: " + mechId);
            System.out.println("Mechanic Name: " + mechName);
            System.out.println("Mechanic Mobile Number: " + mechMobile);
            System.out.println("Mechanic email: "+mechEmail);
            System.out.println("Time availability: " + mechTime);
            System.out.println("Area of expertise: " + mechArea);
            
            
                               }
		st4.close();
		con4.close();

        resultSet.close();
        preparedStatement.close();
    	} catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void viewAllRecords() {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mechanic_db", "root", "Vamsi@1804");

        String selectQuery1 = "SELECT * FROM mechanic";
        PreparedStatement preparedStatement1 = con5.prepareStatement(selectQuery1);

        ResultSet resultSet1 = preparedStatement1.executeQuery();

        while (resultSet1.next()) {
        	int mechId = resultSet1.getInt("mech_id");
            String mechName = resultSet1.getString("mech_name");
            String mechMobile=resultSet1.getString("mech_mob");
            String mechEmail= resultSet1.getString("mech_email");
            String mechTime=resultSet1.getString("mech_time");
            String mechArea=resultSet1.getString("mech_exp");

            System.out.println("Mechanic ID           : " + mechId);
            System.out.println("Mechanic Name         : " + mechName);
            System.out.println("Mechanic Mobile Number: " + mechMobile);
            System.out.println("Mechanic email        : " + mechEmail);
            System.out.println("Time availability     : " + mechTime);
            System.out.println("Area of expertise     : " + mechArea);
            System.out.println();
        }

        resultSet1.close();
        preparedStatement1.close();
        con5.close();
    	} catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}