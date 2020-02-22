
// listen to the lecture in week 10 for details
public class Service
{
    public String code; // the service code
    public String shortDescription; // short description
    public double fee; //in dollars
    public double commission; // comission rate as percentage 0.1 = 0.1%
    public int firstRecovery; // 0 = land 1 = sea  2=none

    // constants for firstRecovery (if you know about enumerated types feel free to change it to enum type)
    public static final int recLand =0;
    public static final int recSea = 1;
    public static final int recNone =2;
    
   
    
    public Service(String code, String shortDescription, double fee, double commission, int firstRecovery)
    {
        this.code=code.trim(); // the service code
        this.shortDescription=shortDescription; // short description
        this.fee=fee; //in dollars
        this.commission=commission; // comission rate as percentage 0.1 = 0.1%
        this.firstRecovery=firstRecovery; 
    }
    
    
    public static String recoveryAsString(int firstRecovery)
    {
        if (firstRecovery==recLand) return "Land"; 
        if (firstRecovery==recSea ) return "Sea ";
        if (firstRecovery==recNone) return "None";   
        return "Error> Invalid firstRecovery";
    }
    
    public String toString() 
    {
        String recoveryLocation = recoveryAsString(firstRecovery);
        String retv = code;
        
        retv=String.format("| %-5s|%-24s|$%-,12.0f|%-4.2f%%|%-6s|", code, shortDescription, fee, commission, recoveryLocation);
        return retv;
    }

}
