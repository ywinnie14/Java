
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Menu
{

    public Menu()
    {

        System.out.print("\u000c");

        CustomerList cl = new CustomerList();
        Customer c;

        ServiceList sl=new ServiceList();
        Service s;

        String menuOpt="";
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.printf("\nSpaceZ Marketing Menu\n");
            System.out.printf("E - Exit\n");
            System.out.printf("A - Audit Report\n");
            System.out.printf("L - Launch Report\n");
            System.out.printf("C - Commission Report\n");
            System.out.printf("S - Launch Schedule\n");
            System.out.printf("Select Option:\n");
            menuOpt = in.nextLine();      
            System.out.println("You entered : " + menuOpt);
            String[] optionName = {"A","L","C","S","E"};
            boolean loopAgain = true;
            do
            {
                boolean isValidName = true;

                for (int i=0; i<5; i++)
                {
                    if(menuOpt.compareToIgnoreCase(optionName[i])==0)
                    {
                        isValidName = false;
                        loopAgain=false;
                        break;
                    }
                    
                }
                
                if  (isValidName== true)
                {
                    System.out.printf("\nInvalid input! Try again.\n");
                }
                
                if (loopAgain == false)
                {
                    break;
                }
                
            }while (loopAgain==false);


            if (menuOpt.compareToIgnoreCase("A") == 0) //{opta();}

                new AuditReport();

            if(menuOpt.compareToIgnoreCase("L") == 0) //{opta();}
                new LaunchReport();

            if (menuOpt.compareToIgnoreCase("C") == 0) //{opta();}
                new CommissionReport();

            if (menuOpt.compareToIgnoreCase("S") == 0) //{opta();}
                new LaunchSchedule();

        }
        while (menuOpt.compareToIgnoreCase("E")!=0); // Note the != this time 
        System.out.printf("\nEnding Now \n");
    }

    public static String sHorizontal(int iNum)
    {
        String output="";
        for (int i=0; i<iNum; i++)
        {
            output = output + "-";
        }
        return output;
    }

    public static String sSpace(int iNum)
    {
        String output="";
        for (int i=0; i<iNum; i++)
        {
            output = output + " ";
        }
        return output;
    }

//    public void opta()
//    {
//        System.out.printf("\nyou selected option A\n");
//
//    }
	public static void main(String[] args) {
		try {
			new Menu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
