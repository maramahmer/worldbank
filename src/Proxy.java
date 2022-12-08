/**
* Proxy class used to set the username and password for the login interface
* @author Group 1 CS2212
*/
public class Proxy{
	private String username, password;
    
    /**
    *@param usrname 
    *@param pssword
    *Consturctor used the set the username and password of the user
    */
	public Proxy(String usrname, String pssword){
		username = usrname;
		password = pssword;
	}
    
    /**
    *@return the username the user has chosen
    */
	public String getUsername(){
		return username;
	}
    
    /**
    *@return the password the user has chosen
    */
	public String getPassword(){
		return password;
	}
}
