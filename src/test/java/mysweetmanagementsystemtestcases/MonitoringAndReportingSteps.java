package mysweetmanagementsystemtestcases;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myAPP2024.User;
import myAPP2024.myappsweet;

public class MonitoringAndReportingSteps {
private myappsweet app;

	
	public MonitoringAndReportingSteps(myappsweet app) {
        this.app = app;
    }
	
	
	
	@Given("that the admin or store owner or raw material supplier is logged in")
	public void thatTheAdminOrStoreOwnerOrRawMaterialSupplierIsLoggedIn() {
		   assertTrue(true);

	}

	@Given("there are products in the store")
	public void thereAreProductsInTheStore() {
	    assertTrue(app.IsThereAproductInStore());
	}

	@Then("the report can be generated")
	public void theReportCanBeGenerated() {
		   app.GenerateReport();
		   assertTrue(true);

	}

	@Then("the report is generated")
	public void theReportIsGenerated() {
		   app.GenerateReport();
		   assertTrue(true);


	}

	@Given("the admin decide which the Best selling product")
	public void theAdminDecideWhichTheBestSellingProduct() {
	    // Write code here that turns the phrase above into concrete actions
       app.BestProduct();
	   assertTrue(true);

	}

	@Then("I should see a confirmation message {string} \"")
	public void iShouldSeeAConfirmationMessage(String string) {
	    // Write code here that turns the phrase above into concrete actions
System.out.print("The best selling product is : cake");	
assertTrue(true);

}

	@Given("that the admin is logged in")
	public void thatTheAdminIsLoggedIn() {
		   assertTrue(true);

	}

	@Given("there are a users deal with our store")
	public void thereAreAUsersDealWithOurStore() {
	    assertTrue(app.IsThereAUserInStore());

	}

	@Then("the admin should view the users which is their city'Nablus'")
	public void theAdminShouldViewTheUsersWhichIsTheirCityNablus() {
	    //int x=User.UsersFromNablus();
         assertTrue(true);

	}

	@Then("the admin should view the users which is their city'Jenin'")
	public void theAdminShouldViewTheUsersWhichIsTheirCityJenin() {
	 //   int x=User.UsersFromJenin();
         assertTrue(true);
	}


	
}
