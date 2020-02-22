
/**
 * Write a description of class CommissionReport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.text.*;
public class CommissionReport
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
    String CommOpt="";


    public CommissionReport()
    {
        System.out.printf("Enter File Name:\n");
        CommOpt = in.nextLine();
        System.out.printf("reading ... " + CommOpt+"\n");
        System.out.println(Menu.sHorizontal(70));
        String[] si;
        testFile = new ArrayList<LaunchReportList>();
        boolean loopAgain = true;

        do 
        {
            String[] testName = {"Test1.txt","Test2.txt","Test3.txt","Test4.txt","Mand1.txt","Mand2.txt","Mand3.txt"};
            if(CommOpt.compareToIgnoreCase("B") == 0)
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
                    if(CommOpt.compareToIgnoreCase(testName[i])==0)
                    {
                        isValidName = true;
                        System.out.println("Launch Report for:" +CommOpt);
                        System.out.println(Menu.sHorizontal(70));
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
                if (CommOpt.compareToIgnoreCase(testName[i]) == 0)
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
        String sFees;

        double totalAzu = 0.0;
        double totalChu = 0.0;
        double totalJam = 0.0;

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
                        double dFee = sl.findService(testFile.get(i).sServCode).fee;
                        double dComPercentage = sl.findService(testFile.get(i).sServCode).commission;
                        String sSale = cl.findCustomer(testFile.get(i).sCustCode).salesPerson;
                        double dCom=0.0;
                        
                        int iFRec = sl.findService(testFile.get(i).sServCode).firstRecovery;

                        if ((testFile.get(i).sCustCode).compareTo("CODC")==0)
                        {
                            double dComm;
                            dComm=0;
                            System.out.printf("%-13s %-6s %-7s $%-,11.0f  $%-,7.0f  %-10s\n",testFile.get(i).sDate, testFile.get(i).sCustCode, testFile.get(i).sServCode, dFee, dComm, sSale);
                            
                        }
                        else
                        {
                            if (iFRec == Service.recSea)
                            {
                                dCom = ((dFee - 265000) * dComPercentage)/100;
                            }
                            if (iFRec == Service.recNone)
                            {
                                dCom = ((dFee - 2900000) * dComPercentage)/100;
                            }
                            if (iFRec == Service.recLand)
                            {
                                dCom = (dFee * dComPercentage)/100;
                            }
                            System.out.printf("%-13s %-6s %-7s $%-,11.0f  $%-,7.0f  %-10s\n",testFile.get(i).sDate, testFile.get(i).sCustCode, testFile.get(i).sServCode, dFee, dCom, sSale);

                            if (sSale == "Azumi") totalAzu += dCom;

                            else if (sSale == "Chung") totalChu += dCom;

                            else if (sSale == "James") totalJam += dCom;

                        }
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
        System.out.println(Menu.sHorizontal(70));
        System.out.printf("Commission for Azumi:  $%,8.0f\n", totalAzu);
        System.out.printf("Commission for Chung:  $%,8.0f\n", totalChu);
        System.out.printf("Commission for James:  $%,8.0f\n", totalJam);
        System.out.println(Menu.sHorizontal(70));
        double totalCom = totalAzu + totalChu + totalJam;
        System.out.printf("Total Commission  $%,8.0f\n", totalCom);
        System.out.println(Menu.sHorizontal(70));
    }

}
