
/**
 * Write a description of class LaunchReport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.text.*;
public class LaunchReport
{
    Scanner in = new Scanner(System.in);
    CustomerList cl = new CustomerList();
    ServiceList sl = new ServiceList();
    public String sCustCode;
    public String sServCode;
    public String sDate;
    public String line;
    public boolean testMatch = true;

    ArrayList<LaunchReportList> testFile;
    String LReportOpt="";

    public LaunchReport()
    {
        System.out.printf("Enter File Name:\n");
        LReportOpt = in.nextLine();
        System.out.printf("reading ... " + LReportOpt+"\n");
        System.out.println(Menu.sHorizontal(30));
        String[] si;
        testFile = new ArrayList<LaunchReportList>();
        boolean loopAgain = true;

        do 
        {
            String[] testName = {"Test1.txt","Test2.txt","Test3.txt","Test4.txt","Mand1.txt","Mand2.txt","Mand3.txt"};
            if(LReportOpt.compareToIgnoreCase("B") == 0)
            {
                loopAgain = false;
            }
            if(loopAgain == false) {
                System.out.printf("\nGoing back to the Menu.\n");
                break;
            }

            do
            {
                boolean isValidName = false;

                for (int i=0; i<testName.length; i++)
                {
                    if(LReportOpt.compareToIgnoreCase(testName[i])==0)
                    {
                        isValidName = true;
                        System.out.println("Launch Report for:" +LReportOpt);
                        System.out.println(Menu.sHorizontal(30));
                        break;
                    }
                }
                if  (isValidName== true)
                {
                    break;
                }
                if  (isValidName== false)
                {
                    System.out.printf("\nInvalid input! Try again.\n");
                    loopAgain=false;
                    break;
                }

            }while (loopAgain==true);

            for (int i=0; i<testName.length; i++)
            {
                if (LReportOpt.compareToIgnoreCase(testName[i]) == 0)
                {
                    try
                    {
                        BufferedReader br = new BufferedReader(new FileReader(testName[i]));

                        while((line = br.readLine()) != null)
                        {
                            si = line.split(",");
                            LaunchReportList launchReport = new LaunchReportList(si[0], si[1], si[2]);
                            testFile.add(launchReport);
                        }
                        infoMatch(testFile);
                        testMatch = true;
                    }
                    catch (Exception e)
                    {
                         System.out.printf("Try again.\n");
                    }
                    
                }
            }
 
            if (testMatch == true)
            {
                System.out.println(Menu.sHorizontal(30));
            }
            loopAgain = false;

        }while (loopAgain);
    }

    public void infoMatch (ArrayList<LaunchReportList> testFile)
    {
        String[] dateLine;

        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date dd = new Date();
        boolean dateMatch =false;

        for (int i=0; i<testFile.size(); i++)
        {
            try 
            {                
                dd=df.parse(testFile.get(i).sDate);
                dateMatch = true;
            }
            catch(ParseException e)
            {
                dateMatch =false;

            }

            if (cl.findCustomer(testFile.get(i).sCustCode)!=null)
            {
                if (sl.findService(testFile.get(i).sServCode)!=null)
                {
                    if (dateMatch == true)
                    {
                        System.out.printf("%-8s %-8s %-15s%n",testFile.get(i).sCustCode, testFile.get(i).sServCode, testFile.get(i).sDate);
                    }
                    else
                    {
                        System.out.println("Error>>invalid line syntax (Date)");
                    }
                }
                else
                {   
                    //System.out.printf("%-8s %-8s %-15s%n",testFile.get(i).sCustCode, testFile.get(i).sServCode, testFile.get(i).sDate);
                    System.out.println("Error>>invalid line syntax (Service)");
                }
            }
            else
            {
                System.out.println("Error>>invalid line syntax (Customer)");
            }

        }

    }  

}
