
/**
 * Write a description of class AuditReport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AuditReport
{
    CustomerList cl = new CustomerList();
    Customer c;

    ServiceList sl=new ServiceList();
    Service s;
    public AuditReport()
    {
        drawCLines();
        c=cl.findCustomer("ESAA"); System.out.println(c.toString());
        c=cl.findCustomer("NASHA"); System.out.println(c.toString());
        c=cl.findCustomer("ASA"); System.out.println(c.toString());
        c=cl.findCustomer("TICK"); System.out.println(c.toString());
        c=cl.findCustomer("BINC"); System.out.println(c.toString());
        c=cl.findCustomer("CODC"); System.out.println(c.toString());
        c=cl.findCustomer("MARZ"); System.out.println(c.toString());
        drawCLines();

        drawSLines();
        s=sl.findService("ORB1"); System.out.println(s.toString());
        s=sl.findService("ORB2"); System.out.println(s.toString());
        s=sl.findService("ORB3"); System.out.println(s.toString());
        s=sl.findService("ISS5"); System.out.println(s.toString());
        s=sl.findService("MOON2"); System.out.println(s.toString());
        s=sl.findService("DUNA"); System.out.println(s.toString());
        drawSLines();
    }

    public void drawCLines ()
    {
        System.out.println(
            "+" + Menu.sHorizontal(6) +
            "+" + Menu.sHorizontal(35) + 
            "+" + Menu.sHorizontal(20) +
            "+" + Menu.sHorizontal(24) + 
            "+" + Menu.sHorizontal(7) +
            "+" + Menu.sHorizontal(8) + "+");
    }

    public void drawSLines ()
    {
        System.out.println(
            "+" + Menu.sHorizontal(6) +
            "+" + Menu.sHorizontal(24) + 
            "+" + Menu.sHorizontal(13) +
            "+" + Menu.sHorizontal(5) +
            "+" + Menu.sHorizontal(6) + "+");
    }
}
