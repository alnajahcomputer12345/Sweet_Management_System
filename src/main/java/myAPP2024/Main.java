package myAPP2024;
import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Main {
	

	public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        Map<String, Sales> s= new HashMap<String, Sales>();

		//System.out.println("Messeging");
		//System.out.println("Select one of the store owners:");
		myappsweet m=new myappsweet();
		for (Map.Entry<String, User> entry : m.getUsers().entrySet()) {
            String key = entry.getKey();
            User value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
		//m.viewAllRecipes();
		//m.getUsers();
		System.out.println(m.users);
		//m.viewlistofproducts();

		/*Product p=new Product("cake",5);
		System.out.println(p.checkifwehaveEnoughItems("cake", 5));
		//double c=p.getPrice();
	//	System.out.println(c);

		p.AddToChart(p);
		p.DecreaseTheNumberOfItems("cake", 5);
		m.viewlistofproducts();
		Product pp=new Product("tarte",10);
		System.out.println(pp.checkifwehaveEnoughItems("tarte", 10));
		//double c=p.getPrice();
	//	System.out.println(c);

		pp.AddToChart(pp);
		pp.DecreaseTheNumberOfItems("tarte", 10);
		m.viewlistofproducts();
		//s=Sales.getSales();
		for (Map.Entry<String, Product> entry : Product.itemsbuy.entrySet()) {
            String key = entry.getKey();
            Product value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
		if(p.checkiftheuserBuySth())
			p.HaveA10Discount();
		
		System.out.println(m.BestProduct());
		m.GenerateReport();

		/*for (Map.Entry<String, Sales> entry : Sales.getSales().entrySet()) {
            String key = entry.getKey();
            Sales value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
		m.GenerateReport();
		/*StoreOwnerOrRawSupplier mm=new StoreOwnerOrRawSupplier();
		mm.PrintStoreOwner();
		System.out.println("Enter your email:");
        String input1 = scanner.nextLine();

		System.out.println("Enter reciption email:");
        String input2 = scanner.nextLine();

		System.out.println("Messeging:");
        String input3 = scanner.nextLine();
        Message Ms=new Message(input1,input2,input3);
       if( Ms.ichooseacoorectOwner(input2) & Ms.checkifienteramessage(Ms) & Ms.checkifiselectareciption(Ms))
         Ms.SendMessage(Ms);
       else
    	   System.out.println("12345");*/
         //m.ViewMessageSetToMe(input1);*/

	}
		
		
		
    }
    	
