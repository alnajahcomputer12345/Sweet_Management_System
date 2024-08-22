package myAPP2024;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class StoreOwnerOrRawSupplier {
public String username;
public	String password;
public static String email;
 public static ArrayList<StoreOwnerOrRawSupplier> list = new ArrayList<StoreOwnerOrRawSupplier>();
	public static boolean logedIn(StoreOwnerOrRawSupplier so) {
		for(int i=0 ; i<list.size();i++)
		{
			if(list.get(i).getUsername().equals(so.getUsername()))
				return true;
					
		}
		return false;
	}
	public StoreOwnerOrRawSupplier() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

	
	
	
	
	
	
}
