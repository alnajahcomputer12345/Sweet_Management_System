package mysweetmanagementsystemtestcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myAPP2024.myappsweet;

public class Log_out_Steps {

 private myappsweet app;
    private String msg;

    public Log_out_Steps(myappsweet app) {
        this.app = app;
    }

    @Given("the user {string} is not logged into the system")
    public void the_user_is_not_logged_into_the_system(String username) {
        app.islogged = false;
    }

    @When("the user requests to log out")
    public void the_user_requests_to_log_out() {
        if (!app.islogged) {
            msg = "Logout failed. You are not logged in";
            assertTrue(msg,!app.islogged);
        } else {
            app.islogged = false;
            msg = "You have successfully logged out of the system";
            Scanner c=new Scanner("c");
           app.logout(c);
            assertFalse(msg,app.islogged);
        }
    }

    @Then("the system should prevent the logout attempt")
    public void the_system_should_prevent_the_logout_attempt() {
        assertEquals("Logout failed. You are not logged in", msg);
    }

    @Then("a message {string} should appear")
    public void a_message_should_appear(String Message) {
        assertEquals(Message, msg);
    }
}

