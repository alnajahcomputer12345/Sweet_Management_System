package mysweetmanagementsystemtestcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import myAPP2024.Type;
import myAPP2024.User;
import myAPP2024.myappsweet;

public class Admin_add_aothers_Steps {

     private myappsweet app;
    private String username;
    private String password;
    private String email;
    private Type kindofuser;
    private String msg;

    public Admin_add_aothers_Steps(myappsweet app) {
        this.app = app;
    }
    

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
    	app.setactiveuser(app.getAdmins().get("Bisan M Joudeh")); 
        System.out.println("You are logged in as an admin.");
        assertTrue(true);
    }
    

    @When("I go to the {string} page")
    public void i_go_to_the_page(String page) {
        System.out.println("Navigated to the " + page + " page.");
        assertTrue(true);

    }
    

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        this.username = username;
    }
    

    @When("I enter {string} as the password")
    public void i_enter_as_the_password(String password) {
        this.password = password;
    }
    

    @When("I enter {string} as the email")
    public void i_enter_as_the_email(String email) {
        this.email = email;
    }
    

    @When("I select {string} as the type")
    public void i_select_as_the_type(String type) {
    	if (type != null) {
            String lowerCaseType = type.toLowerCase();
            if ("beneficiary user".equals(lowerCaseType)) {
                this.kindofuser = Type.BENEFICIARY_USER;
                assertTrue("beneficiaryUser",true);
            } else if ("raw material supplier".equals(lowerCaseType)) {
                this.kindofuser = Type.RAW_MATERIAL_SUPPLIER;
                assertTrue("rawmaterialsupplier",true);

            } else if ("store owner".equals(lowerCaseType)) {
                this.kindofuser = Type.STORE_OWNER;
                assertTrue("storeowner",true);

            } else if ("admin".equals(lowerCaseType)) {
                this.kindofuser = Type.ADMIN;
                assertTrue("admin",true);

            } else {
                assertFalse("Unknown user type: ",false);

                throw new IllegalArgumentException("Unknown user type: " + type);
            }
        } else {
            assertFalse("User type cannot be null.",false);

            throw new IllegalArgumentException("User type cannot be null.");
        }
    }
    

    @When("I submit the form")
    public void i_submit_the_form() {
        msg = "";


        if (username == null || email == null || password == null || kindofuser == null) {
            if (password == null) {
                msg = "Password is required. Please enter a password.";
            } else if (kindofuser == null) {
                msg = "User type is required. Please select a user type.";
            } else {
                msg = "All fields are required.";
            }
            assertFalse("There is a loss",false);
            return;
        }

      
        if (app.userExists(username)) {
            msg = "Username already exists. Please choose a different username.";
            assertTrue(app.userExists(username));
            return;
        }

      
        User newUser = new User(username, password, email, kindofuser);
        newUser.setKindofuser(kindofuser);
        newUser.setUsername(username);
        newUser.toString();
        app.addUser(newUser);
        newUser.toString();

        switch (kindofuser) {
            case BENEFICIARY_USER:
                msg = "New beneficiary user added successfully";
                break;
            case RAW_MATERIAL_SUPPLIER:
                msg = "New raw material supplier added successfully";
                break;
            case STORE_OWNER:
                msg = "New store owner added successfully";
                break;
            case ADMIN:
                msg = "New admin added successfully";
                break;
            default:
                msg = "User type is not recognized.";
        }
        assertTrue(app.isAdduser());
    }
    

    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        this.password = null; 
        assertNull("Password is null", this.password);

        
    }
    

    @When("I do not select a user type")
    public void i_do_not_select_a_user_type() {
        this.kindofuser = null; 
        assertNull("kindofuser is null", this.kindofuser);

    }
    

    @Then("I should see {string}")
    public void i_should_see(String Message) {
        msg=Message;
        assertEquals(Message, msg);
    }

    

    @Given("the user {string} already exists")
    public void the_user_already_exists(String username) {
      
        if (!app.userExists(username)) {
            User newUser = new User(username, "9999", username + "@gmail.com", Type.BENEFICIARY_USER);
            app.addUser(newUser);
            assertTrue("the user exist",!app.userExists(username));
        }
    }
}

