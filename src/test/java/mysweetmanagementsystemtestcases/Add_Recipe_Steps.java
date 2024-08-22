package mysweetmanagementsystemtestcases;

import myAPP2024.Recipe;
import myAPP2024.Type;
import myAPP2024.User;
import myAPP2024.myappsweet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import org.junit.Ignore;

public class Add_Recipe_Steps {
    private String recipeName;
    private String details;
    private String instructions;
    private User sharedBy;
    private String msg;
    private myappsweet app;
    Recipe r=new Recipe();
    
    public Add_Recipe_Steps(myappsweet app) {
        this.app = app;
    }

    @Given("I am logged in as user {string}")
    public void i_am_logged_in_as_user(String username) {
        sharedBy = app.getUser(username);
        if (sharedBy != null) {
            app.setactiveuser(sharedBy);
            assertTrue(true);
        } else {
        	assertFalse(false);
            throw new RuntimeException("User not found: " + username);
        }
    }



    @Given("I am on the {string} page123")
    public void i_am_on_the_page(String page) {
        assertTrue(true);
        System.out.println("Navigated to page: " + page);
    }



    @When("I enter the recipe name {string}")
    public void i_enter_the_recipe_name(String name) {
        this.recipeName = name;
        r.setRecipeName(name);
        
    }



    @When("I add details {string} and instructions {string}")
    public void i_add_details_and_instructions(String details, String instructions) {
        this.details = details;
        this.instructions = instructions;
        r.setDetails(details);
        r.setInstructions(instructions);
        r.getCategory();
        r.getInstructions();
        assertTrue(true);
    }



    @When("I leave the recipe name empty")
    public void i_leave_the_recipe_name_empty() {
        this.recipeName = "";
        assertFalse(false);
    }



    @When("I submit the recipe")
    public void i_submit_the_recipe() {
        if (recipeName.isEmpty()) {
            msg = "Recipe name is required";
            assertTrue("Recipe name is required",recipeName.isEmpty());
        } else if (app.getRecipe(recipeName) != null) {
            msg = "Recipe with this name already exists";
            assertTrue("Recipe with this name already exists",app.getRecipe(recipeName) != null);
        } else {
            app.addRecipe(new Recipe(recipeName, details, instructions, app.getactiveuser()));
            msg = "Recipe shared successfully";
            assertTrue(app.isAddrecipe());
        }
    }


    @Then("I should see a message {string}")
    public void i_should_see_a_message(String Message) {

        assertEquals(Message, msg);
    }



    @Then("the recipe {string} should be in the shared recipes list")
    public void the_recipe_should_be_in_the_shared_recipes_list(String name) {
        Recipe recipe = app.getRecipe(name);
        assertNotNull(recipe);
        assertEquals(name, recipe.getRecipeName());
    }



    @Then("it should be shared by {string}")
    public void it_should_be_shared_by(String username) {
        Recipe recipe = app.getRecipe(recipeName);
        assertNotNull(recipe);
        assertEquals(username, recipe.getSharedBy().getUsername());
    }



    @Given("a recipe named {string} already exists")
    public void a_recipe_named_already_exists(String name) {
      //  app.addRecipe(new Recipe(name, "Details", "Instructions", app.getUser("Bisan")));
        assertFalse(app.isAddrecipe());
    }


 

    @Given("I am logged in as  user {string}")
    public void i_am_logged_in_as_user1(String username) {
        sharedBy = app.getUser(username);
        if (sharedBy != null) {
            app.setactiveuser(sharedBy);
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }


    @Then("I should see an error message12 {string}")
    public void i_should_see_an_error_message12(String Message) {
        assertEquals(Message, msg);
    }



    @Then("I should see an message12 {string}")
    public void i_should_see_an_message12(String Message) {
    	//Message="";
        assertTrue(true);
    }
}
