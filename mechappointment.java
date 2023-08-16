package groupproject;


import java.util.Scanner;

public class mechappointment{
	
	private static Scanner sc;

	public static void main(String[] args)throws Exception{
		sc = new Scanner(System.in);
		int ch;
		do {
		
			System.out.println("**********  WELCOME TO THE MAIN MENU  *************");
			System.out.println(" _______ PLEASE SELECT ANY ONE OF THE FOLLOWING________");
			System.out.println("                     1.CUSTOMER                        ");
			System.out.println("                     2.MECHANIC                        ");
			System.out.println("                     3.APPOINTMENT                     ");
			System.out.println("                     0.EXIT                            ");
		
			customer cust = new customer();
	    ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			int ch1;
			System.out.println("************____WELCOME TO CUSTOMER MENU____**********");
			do {
			System.out.println("_____PLEASE SELECT ANY ONE FROM THE FOLLOWING_____");
			System.out.println("                  1.WOULD YOU LIKE TO REGISTER CUSTOMER       ");
			System.out.println("                  2.WOULD YOU LIKE TO MODIFY CUSTOMER DETAILS       ");
			System.out.println("                  3.WOULD YOU LIKE TO DELETE CUSTOMER RECORD        ");
			System.out.println("                  4.DISPLAY SINGLE RECORD            ");
			System.out.println("                  5.DISPLAY ALL RECORDS              ");
			System.out.println("                  0.EXIT FROM CUSTOMER MENU       ");
			
			
			ch1=sc.nextInt();
			
			switch(ch1)
			      {
			case 1:
				cust.registerCustomer();
				
				break;
			
				
			case 2:
				cust.modifyCustomerDetails();
				
				break;
				
				
			case 3:
				cust.deleteCustomerRecord();					
				
				break;
				
				
			case 4:
				
				cust.viewSingleRecord();
				
	            break;
	            
			case 5:
				cust.viewAllRecords();
				break;
		        
			case 0:
				
				break;
				
			default :
				
				System.out.println("Enter the valid key");
				
				break;
				
			      }
			
			}while(ch1 !=0);
			
			break;
			
			
		case 2:
			int I2;
			do {
			System.out.println("**********YOU ARE NOW IN MECHANIC MENU**********");
			System.out.println("____PLEASE SELECT ANY ONE FROM THE FOLLOWING____");
			System.out.println("                  1.VIEW SINGLE RECORD          ");
			System.out.println("                  2.VIEW ALL RECORDS            ");
			System.out.println("                  0.EXIT FROM MECHANIC MENU     ");
			
			mechanic mech = new mechanic();
			I2=sc.nextInt();
			switch(I2)
			{
			case 1:
				mech.viewSingleRecord();
				
	            break;
	            
			case 2:
				 mech.viewAllRecords();
			}
			
			}while(I2 != 0);
			break;
			
		case 3:
			int I3;
			do {
			
			System.out.println("**********YOU ARE NOW IN APPOINTMENT MENU*********");
			System.out.println("_____PLEASE SELECT ANY ONE FROM THE FOLLOWING_____");
			System.out.println("                1.BOOK AN APPOINTMENT             ");
			System.out.println("                2.MODIFY APPOINTMENT DETAILS      ");
			System.out.println("                3.DELETE AN APPOINTMENT           ");
			System.out.println("                4.VIEW SINGLE RECORD              ");
			System.out.println("                5.VIEW ALL RECORDS              ");
			System.out.println("                0.EXIT FROM APPOINTMENT MENU      ");	
			appointment app = new appointment();
			I3=sc.nextInt();
			switch(I3)
			{
			case 1:
				app.bookAppointment();
			    break;
			case 2:
				app.modifyAppointmentDetails();
							
				break;
			
			case 3:
				
				app.deleteAppointment();
				 break;
				
		    case 4:
		    	app.viewSingleRecord();
			    break;
		    case 5:
		    	app.viewAllRecords();
		    	break;
			case 0:
				System.out.println("exiting from appintment menu");
				break;
			default:
			    System.out.println("enter valid input");
			    break;
			
			}
			}while(I3!=0);
			break;
			
			
		
		case 0:
			System.out.println("Thank You for choosing us.");
			break;
		
		}
		
}while(ch != 0);
 }

}

