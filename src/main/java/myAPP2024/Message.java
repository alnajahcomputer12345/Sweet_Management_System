package myAPP2024;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Message {
    String from;
    String to;
    String Content;
    private static final Logger logger = Logger.getLogger(Message.class.getName());

	public Message(String string, String string2, String string3) {
     from=string;
     to=string2;
     Content=string3;
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public static boolean ichooseacoorectOwner(String r) {
         
		//System.out.println("Select an owner:");
		//String reciever=StoreOwnerOrRawSupplier.getEmail();
		 for (User obj : myappsweet.getOwners().values()) 
	    	   if (obj.getEmail().equals(r)) {
	                logger.log(Level.INFO, "You choose a correct owner email");
	               return true;
	           }
		 
		 for(User obj : myappsweet.users.values())
			 if (obj.getEmail().equals(r)) {
	                logger.log(Level.INFO, "You choose a correct user email");
	               return true;
	           }
		 
		 for(User obj : myappsweet.rawSuppliers.values())
			 if (obj.getEmail().equals(r)) {
	                logger.log(Level.INFO, "You choose a correct supplier email");
	               return true;
	           }
		
	        logger.log(Level.WARNING, "Choose another email to send");
			return false;
	}

    private static int currentKey = 0;
     public static boolean sendmessage=false;
     
	public boolean isSendmessage() {
		return sendmessage;
	}

	public void setSendmessage(boolean sendmessage) {
		this.sendmessage = sendmessage;
	}

	public static void SendMessage(Message m) {
		
		if(checkifiselectareciption(m) && checkifienteramessage(m)) {
			myappsweet.messages.put(String.valueOf(currentKey), m);	
			currentKey++; 
			sendmessage=true;
            logger.log(Level.INFO, "Your message was sent");
		}
		else
            logger.log(Level.WARNING, "Sorry, check the details of the message");
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public static boolean checkifiselectareciption(Message m) {
		// TODO Auto-generated method stub
		if (m.getTo().equals("") || m.getTo()==null) {
            logger.log(Level.WARNING, "Please select a recipient");
			return false;}
		else {
		return true;}
	}

	public static boolean checkifienteramessage(Message m) {
		// TODO Auto-generated method stub
		 if (m.getContent().equals("")) {
	            logger.log(Level.WARNING, "Please enter your message");
	            return false;
	        } else {
	            return true;
	        }

	}

	@Override
	public String toString() {
		return "Message [from=" + from + ", to=" + to + ", Content=" + Content + "]";
	}
	
	
	

}
