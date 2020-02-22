import java.util.*;

// listen to the lecture in week 10 for details
public class CustomerList
{
    //Customer c;

    //ServiceList sl=new ServiceList();
    //Service s;

    //Menu m2 = new Menu();

    Customer[] custList;

    //ArrayList al=new ArrayList();
    public CustomerList()
    {

        custList = new Customer[7];
        // this is how it should be done
        custList[0] = new Customer("ESAA","Europe Systems Alternative Agency","Jean-Claude Junxer","23 Razor Road",
            "Belconnen ACT","2617","Azumi");

        custList[1] = new Customer("NASHA","National Air Space Hash Agency","Jimmy Briden","2 Mashup Drive",
            "Bruce ACT","2617","Chung");

        custList[2] = new Customer("ASA","Aussie Space Agency","JMegan Clock","Flat 31/a, Bax Units",
            "Stix St Marble Bar","6760","Azumi");

        custList[3] = new Customer("TICK","Tick Incorporated","Mark Watson","87 Race drive",
            "Bathurst","2795","James");      

        custList[4] = new Customer("BINC","Byer private space Incorporated","Marillyn Hewson","212 webly drive",
            "Canowindra NSW","2804","James");

        custList[5] = new Customer("CODC","Corporate space Trust","Zhang Chen","212 Scorch drive",
            "Beltana SA","5730","Azumi");

        custList[6] = new Customer("MARZ","The Mars Gen Inc","Cool Dude","26 O’Conner’s Road",
            "Werribee South VIC","3030","James");

            //auditReport();
    }

    public void auditReport ()
    {
        System.out.println("---Audit Report---");
        //m.drawLines();
        for (int i=0; i<7; i++)
        {
            System.out.println(custList[i]);
            //System.out.printf("%-5s",custCodeList[i]);
            //System.out.printf("%n| %-5s|%-34s |%-20s|%-20s|%-6s|%-13s|",custCodeList[i], custNameList[i],custContactList[i], custAddress1List[i], custAddress2List[i], custPcodeList[i], salesPersonList[i]);
        }
    }

    public Customer findCustomer(String custCode)
    {
        //simple array search

        for (int i=0; i< 7; i++)
        {
            if (custList[i].custCode.compareToIgnoreCase(custCode.trim())==0) return custList[i];
        }
        return null;
    }

    //doesnt work
    public Customer printCustomer(String custCode)
    {
        //simple array search

        for (int i=0; i< 7; i++)
        {
            System.out.printf("%n| %-5s|%-34s |%-20s|%-20s|%-6s|%-13s|", custList[i]);  
        }
        return null;
    }

}
