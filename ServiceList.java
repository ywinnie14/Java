
// listen to the lecture in week 10 for details
public class ServiceList
{
    // array of services 
    public Service[] servList;
    
    public ServiceList()
    {
     servList = new Service[6];
     servList[0]=new Service("ORB1","Satelite: LEO",65000000,0.1,Service.recLand);
     // System.out.println(servList[0].code); // debug
     servList[1]=new Service("ORB2","Satelite: GSO",67000000,0.12,Service.recLand);
     servList[2]=new Service("ORB3","Satelite: SSO",72650000,0.12,Service.recSea);
     servList[3]=new Service("ISS5","SS Cargo: 5T",76137129,0.09,Service.recSea);
     servList[4]=new Service("MOON2","Tourist: Moon",98000000,0.13,Service.recLand);
     servList[5]=new Service("DUNA","Science: Mars",198000000,0.08,Service.recNone);
    }

    // this method returns a specific service or a null
    // simple array search
    public Service findService(String code)
    {
        for (int i=0; i<6; i++)
        {
            if (code.trim().compareToIgnoreCase(servList[i].code)==0) return servList[i];
        }
        //System.out.println("fail mmmmm "); // debug
        return null;
    }
    
    

}
