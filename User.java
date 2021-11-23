
package assignment1;
import java.util.ArrayList;
public class User {
    Info userInfo;
    String sourceArea;
    String destinationArea;
    static ArrayList<Info> userList;
    public void register(String name,int phone,String email,String pass)
    {
        userList = new ArrayList<Info>();
        userInfo.setUserName(name);
        userInfo.setEmail(email);
        userInfo.setMobileNumber(phone);
        userInfo.setPassword(pass);
        userList.add(userInfo);
    }
    public void requistTrip(String source,String destination)
    {
       sourceArea = source;
       destinationArea=destination;
    }
    public String getSourceArea()
    {
        return sourceArea;
    }
    public String getDestinationArea()
    {
        return destinationArea;
    }
    
}
