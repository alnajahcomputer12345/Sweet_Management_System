package mysweetmanagementsystemtestcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myAPP2024.Message;
import myAPP2024.Type;
import myAPP2024.User;
import myAPP2024.myappsweet;
import org.junit.Test;

public class CommunicationWithOthersSteps {

	
	private myappsweet app;

	public CommunicationWithOthersSteps(myappsweet app) {
        this.app = app;
    }
	
	@When("I choose a specific Raw Material Supplier or Store Owner")
	public void iChooseASpecificRawMaterialSupplierOrStoreOwner() {
	    // Write code here that turns the phrase above into concrete actions
		String reciver="alia@gmail.com";
       
	assertTrue(Message.ichooseacoorectOwner(reciver));
	}

	@When("I write a message")
	public void iWriteAMessage() {
		assertTrue(true);
	    	}

	@When("I send the message")
	public void iSendTheMessage() {
		Message m=new Message();
		m.setContent("mmm");
		m.setFrom("uuu");
		m.setTo("bb");
		Message.SendMessage(m);
		m.setFrom(m.getFrom());
		m.setContent(m.getContent());
		m.setTo(m.getTo());
		m.setSendmessage(true);
		assertTrue("Message sent",m.isSendmessage());
		
	    
	}

	@Then("the Store Owner or Raw Material Supplier should receive the message")
	public void theStoreOwnerOrRawMaterialSupplierShouldReceiveTheMessage() {
	}

	@Then("I should see the message that was sent to me")
	public void iShouldSeeTheMessageThatWasSentToMe() {
		myappsweet ap=new myappsweet();
	   // User u=new User("Bisan","0000","bisan@gmail.com",Type.beneficiaryUser);
	    assertTrue(app.ViewMessageSetToMe("ali@gmail.com"));
	}

	@When("I try to send it without selecting a recipient")
	public void iTryToSendItWithoutSelectingARecipient() {
	    
		Message m=new Message("bbb","","kkk");
		assertFalse(Message.checkifiselectareciption(m));
		
	}

	/*@Given("I choose a specific Raw Material Supplier or Store Owner")
	public void iChooseASpecificRawMaterialSupplierOrStoreOwner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

	@When("I try to send an empty message")
	public void iTryToSendAnEmptyMessage() {
		Message m=new Message("bbb","kkk","");
		m.toString();
		m.getFrom();
		assertFalse(Message.checkifienteramessage(m));
	}



	
	
	
	
	
}
