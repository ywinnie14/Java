
/**
 * Write a description of class CommissionReport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.text.*;
import java.util.Collections;
public class LaunchSchedule
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
    String LScheduleOpt="";
    String LScheduleYearOpt="";

    public LaunchSchedule()
    {
        System.out.printf("Enter File Name:\n");
        LScheduleOpt = in.nextLine();
        System.out.printf("reading ... " + LScheduleOpt+"\n");
        System.out.printf("Please input year (eg 2019): ");
        LScheduleYearOpt = in.nextLine();
        System.out.println(Menu.sHorizontal(70));
        String[] si;
        testFile = new ArrayList<LaunchReportList>();
        boolean loopAgain = true;

        do 
        {
            String[] testName = {"Test1.txt","Test2.txt","Test3.txt","Test4.txt","Mand1.txt","Mand2.txt","Mand3.txt"};
            if(LScheduleOpt.compareToIgnoreCase("B") == 0)
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
                    if(LScheduleOpt.compareToIgnoreCase(testName[i])==0)
                    {
                        isValidName = true;
                        System.out.printf("Launch Schedule for: " + LScheduleYearOpt + " File: " + LScheduleOpt +"\n");
                        System.out.println(Menu.sHorizontal(70));
                        break;
                    }
                    /*
                    else
                    {
                    System.out.println("Invalid input! Please Try Again.");
                    }*/
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
                if (LScheduleOpt.compareToIgnoreCase(testName[i]) == 0)
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

            loopAgain = false;

        }while (loopAgain);
    }

    public void infoMatch (ArrayList<LaunchReportList> testFile)
    {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date dd = new Date();
        boolean dateMatch =false;
        Service[] servArray = sl.servList;
        List<String> dList = new ArrayList<String>();
        List<Date> sortedList = new ArrayList<Date>();
        List<String> unsortedList = new ArrayList<String>();
        List<Date> dateList = new ArrayList<Date>();//*******

        String ddd = "";

        String sFees;
        for (int i=0; i<testFile.size(); i++)
        {
            try 
            {                
                dd=df.parse(testFile.get(i).sDate);
                dateMatch = true;
                ddd = testFile.get(i).sDate;
            }
            catch(ParseException e)
            {
                dateMatch =false;

            }
            String sSale = cl.findCustomer(testFile.get(i).sCustCode).salesPerson;
            if (cl.findCustomer(testFile.get(i).sCustCode)!=null)
            {
                if (sl.findService(testFile.get(i).sServCode)!=null)
                {
                    if (dateMatch == true)
                    {
                        if (dd!=null)
                        {
                            if (LScheduleYearOpt.compareTo(ddd.substring(ddd.length()-4)) == 0)
                            {
                                Collections.sort(dateList);
                                
                                dList.add(String.format("%-13s %-6s %-7s %-10s\n",testFile.get(i).sDate, testFile.get(i).sCustCode, testFile.get(i).sServCode, sSale));
                                sortedList.add(dd);

                            }

                        }
                        Collections.sort(sortedList);
                        //System.out.println(sortedList);

                        /*
                        for (int x=0; x<sortedList.size(); x++)
                        {
                        sortedList.get(x) = df.format(sortedList.get(x));
                        }
                         */
                        for (String d : dList)
                        {
                            // d= df.format(dList);
                        }
                        /*
                        for (int y=0; y<sortedList.size(); y++)
                        {
                        sortedList(y).compareTo(dList(y)==0);
                        }
                        System.out.printf("%-13s %-6s %-7s %-10s\n",unsortedList.get(i), testFile.get(i).sCustCode, testFile.get(i).sServCode, sSale);
                         */
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
        for (String d : dList)
        {
            System.out.printf(d);
        }

        System.out.println(Menu.sHorizontal(70));

    }

}
