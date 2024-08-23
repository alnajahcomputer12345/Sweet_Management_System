package myAPP2024;
import java.lang.*;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Product {


	
	int num_product;
	String nameOfProduct;
	double price;
	int count;
	int SalesCount;
	String UserNameOfOrderOwner;
	private int OrderId;
	private static int currentOrderId = 0; // Static counter for unique order IDs
	private static final Logger logger = Logger.getLogger(Product.class.getName());

	double totalprice;
	 //public static ArrayList<Product> list = new ArrayList<Product>();
	   static private Map<String, Product> listofproduct;
	   public static Map<String, Product> itemsbuy = new HashMap<String, Product>();

   public Product(int num_product2,String name ,double price2 , int count1) {
   num_product=num_product2;
	 nameOfProduct=name;
   price=price2;
   count=count1;

	}
	
	
	
	public int getOrderId() {
	return OrderId;
}



public void setOrderId(int orderId) {
	OrderId = orderId;
}



	public Product() {
	}



	public Product(String name, int num) {
		String nameOfProduct=name;
  this.SalesCount=num;
	}

	public Product(String name, int num ,String own,double price) {
		nameOfProduct=name;
		  this.SalesCount=num;
		  this.UserNameOfOrderOwner=own;
		  this.price=price;
			this.OrderId = ++currentOrderId; 

			}

	public Product(int i, String string) {
		num_product=i;
		nameOfProduct=string;
	}

	public Product(String s1,int i, String string) {
		this.SalesCount=i;
		nameOfProduct=s1;
		this.UserNameOfOrderOwner=string;
		
	}


	
	public String getUserNameOfOrderOwner() {
		return UserNameOfOrderOwner;
	}



	public void setUserNameOfOrderOwner(String userNameOfOrderOwner) {
		UserNameOfOrderOwner = userNameOfOrderOwner;
	}



	public Product(String string) {
		nameOfProduct=string;	}



	public Product(Product p, double n) {
      this.nameOfProduct=p.getNameOfProduct();
      this.num_product=p.getNumProduct();
      
	}



	public int  getNumProduct() {
		return num_product;
	}
	
	public void setNumProduct(int num_product) {
		this.num_product = num_product;
	}
	
	public String getNameOfProduct() {
		return nameOfProduct;
	}
	
	public void setName_of_product(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}



	public static boolean CheckIfExistToUpdate(String string) {
	    for (Product obj : myappsweet.getProducts().values()) {
	        if (obj != null && obj.getNameOfProduct() != null) {
	            if (obj.getNameOfProduct().equals(string)) {
	                logger.log(Level.INFO, "This product exists");
	                return true;
	            }
	        }
	    }
	    return false;
	}



	



	


	@Override
	public String toString() {
		return "Product [num_product=" + num_product + ", name_of_product=" + nameOfProduct + ", price=" + price
				+ ", count=" + count + ", SalesCount=" + SalesCount + ", UserNameOfOrderOwner=" + UserNameOfOrderOwner
				+ "]";
	}



	public static boolean UpdateNameOfProduct(String string, String string2) {
		
		boolean existname = false;
    	for (java.util.Map.Entry<String, Product> entry : myappsweet.products.entrySet()) {
    	    Product product = entry.getValue();
    	    if (product.getNameOfProduct().equals(string2)) {
    	        existname = true;
    	    }
    	}

		
		if (string2.isEmpty() || existname) {
	        System.out.println("Sorry, you are missing important data OR repeated name");
	        return false;
	    }
		
	    
	    // Iterate over the products to find the one with the specified old name
	    for (Product product : myappsweet.getProducts().values()) {
	        if (product.getNameOfProduct().equals(string)) {
	        	 //Product.listofproduct.remove(string);
	            product.setName_of_product(string2); // Update the product name
	            product.setCount(product.getCount());
	            product.setNumProduct(product.getNumProduct());
	            System.out.println(product.getNumProduct());

	            product.setPrice(product.getPrice());
	            System.out.println("Updating done successfully");
	            return true; 
	        }
	    }
	    System.out.println("Product with the name " + string + " not found.");
	    return false;
	}
	



	public static boolean CheckNameAndCount(String string, Integer int1) {
		 for (Product product : myappsweet.getProducts().values()) {
		        if (product != null && product.getNameOfProduct() != null) {
		            if (product.getNameOfProduct().equals(string) && product.getCount() == int1) {
		                myappsweet.getProducts().put(String.valueOf(product.getNumProduct()), product);
		                return true;
		            }
		        }
		    }
		    return false;
		
		
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public static boolean CheckThenewcountispositive(Integer int1) {
		if(int1>0)
			return true;
		else
			{System.out.println("Please recheck the count of the product , it seems a negative ");
			return false;}
	}



	public static boolean SetNewCount(Integer int1, Integer int2, String string) {
	//	myappsweet ap=new myappsweet();
         if(CheckNameAndCount(string,int1)) {
	       listofproduct=myappsweet.getProducts();
	       for (Product product : listofproduct.values()) {
	            if (product.getNameOfProduct().equals(string)) {
	            	if(product.getCount() == int1)
	                product.setCount(int2);;
	                listofproduct.put(Integer.toString(product.getNumProduct()), product);
	                System.out.println("Update done successfully");
	                return true;
	            }
	        }}
         else
        	 System.out.println();
		return false;
			}



	public boolean checkifwehaveEnoughItems(String string, int numberofitems) {
      
		   for (Product product : myappsweet.getProducts().values()) {
		        // Check if product and its name are not null
		        if (product != null && product.getNameOfProduct() != null) {
		            // Check if the product name matches and the count is sufficient
		            if (product.getNameOfProduct().equals(string) && product.getCount() >= numberofitems) {
		                return true;
		            }
		        }
		    }
		    return false;
		
	}



	public boolean AddToChart(Product p) {
		double n=0.0;
		 Product v;
		//String x=String.valueOf(p.getOrderId());
		for (Product product : myappsweet.getProducts().values()) {
            if (product.getNameOfProduct().equals(p.getNameOfProduct())) {
               n=product.getPrice();
               Product c=new Product(product.getNumProduct(),p.getNameOfProduct(),product.getPrice(),p.getSalesCount());
               Product d=new Product(p.getNameOfProduct(),p.getSalesCount(),p.getUserNameOfOrderOwner(),product.getPrice());
       		String x=String.valueOf(d.getOrderId());
            //  System.out.println(d.getOrderId());
            //   System.out.println(d);
   			itemsbuy.put(x, d);
   			p.DecreaseTheNumberOfItems(p.getNameOfProduct(), p.getSalesCount());
   			boolean paiedmoney=false;
   			System.out.println("Do you want to order more?   (yes/no)");
   		//Scanner scanner = new Scanner(System.in);
        // String s = scanner.nextLine();
         //    if(s.equals("yes"))
            	 paiedmoney=true;
             
			if(p.checkiftheuserBuySth() && !paiedmoney) {
   				HaveA10Discount();
			
   			System.out.print("The status of your order is:");
   			System.out.println(d.GetStatus(d));  }
   			
            }
             
			}
		return true;

	}

	public void DecreaseTheNumberOfItems(String string, int numberofitems) {
		 for (Product product : myappsweet.getProducts().values()) {
	            if (product.getNameOfProduct().equals(string)) {
	            	product.setCount(product.getCount()-numberofitems);;
	            	myappsweet.getProducts().put(Integer.toString(product.getNumProduct()), product);
	            }
		 }
	boolean v=SetSales(string,numberofitems)	; 
		
	}



	public boolean SetSales(String s,int numberofitems) {
		for (Sales product : Sales.sales.values()) {
		if (product.getName().equals(s)) { 
			int x=product.getSale();
			product.setSale(x+numberofitems);
			return true;
		}
		}
		Sales.sales.put(s,new Sales(s,numberofitems));
		return false;
	}



	public boolean CheckWeDefineQuantity(Product p) {
      if(p.getNumProduct()==0) {
		return false;}
      else
      { return true;}
	}



	public boolean checkiftheuserBuySth() {
		return !(itemsbuy.isEmpty());
	}


	 double pricee=0.0;

	public void HaveA10Discount() {
		 for (Product product : itemsbuy.values())
		 {
			  
		      pricee= pricee+(product.getPrice()*product.getSalesCount());
		      
		 }
		     System.out.print("Your total price after discount is:");
		     double a=pricee-(pricee*0.1);
    		System.out.println(a);
    		System.out.println("You have a discount 10% on your purchases");

	}
	


	public static Map<String, Product> getItemsbuy() {
		return itemsbuy;
	}



	public static void setItemsbuy(Map<String, Product> itemsbuy) {
		Product.itemsbuy = itemsbuy;
	}



	public int getSalesCount() {
		return SalesCount;
	}



	public String GetStatus(Product p) {
		
        if (itemsbuy.containsKey(String.valueOf(getOrderId()))) {
		return" Processing";		
	}
        else
	{return "failed";}
	}



	
	
	
	
	

	
	
	
	
	
	
}
