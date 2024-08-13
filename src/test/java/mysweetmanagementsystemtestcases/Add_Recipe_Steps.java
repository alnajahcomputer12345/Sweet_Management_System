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

    public Add_Recipe_Steps(myappsweet app) {
        this.app = app;
    }
@Ignore
    @Given("I am logged in as user {string}")
    public void i_am_logged_in_as_user(String username) {
        sharedBy = app.getUser(username);
        if (sharedBy != null) {
            app.setactiveuser(sharedBy);
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }
@Ignore

    @Given("I am on the {string} page123")
    public void i_am_on_the_page(String page) {
     
        System.out.println("Navigated to page: " + page);
    }
@Ignore

    @When("I enter the recipe name {string}")
    public void i_enter_the_recipe_name(String name) {
        this.recipeName = name;
    }
@Ignore

    @When("I add details {string} and instructions {string}")
    public void i_add_details_and_instructions(String details, String instructions) {
        this.details = details;
        this.instructions = instructions;
    }
@Ignore

    @When("I leave the recipe name empty")
    public void i_leave_the_recipe_name_empty() {
        this.recipeName = "";
    }
@Ignore

    @When("I submit the recipe")
    public void i_submit_the_recipe() {
        if (recipeName.isEmpty()) {
            msg = "Recipe name is required";
        } else if (app.getRecipe(recipeName) != null) {
            msg = "Recipe with this name already exists";
        } else {
            app.addRecipe(new Recipe(recipeName, details, instructions, app.getactiveuser()));
            msg = "Recipe shared successfully";
        }
    }
@Ignore

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String Message) {

        assertEquals(Message, msg);
    }
@Ignore

    @Then("the recipe {string} should be in the shared recipes list")
    public void the_recipe_should_be_in_the_shared_recipes_list(String name) {
        Recipe recipe = app.getRecipe(name);
        assertNotNull(recipe);
        assertEquals(name, recipe.getRecipeName());
    }
@Ignore

    @Then("it should be shared by {string}")
    public void it_should_be_shared_by(String username) {
        Recipe recipe = app.getRecipe(recipeName);
        assertNotNull(recipe);
        assertEquals(username, recipe.getSharedBy().getUsername());
    }
@Ignore

    @Given("a recipe named {string} already exists")
    public void a_recipe_named_already_exists(String name) {
        app.addRecipe(new Recipe(name, "Details", "Instructions", app.getUser("Bisan")));
    }

@Ignore
 

    @Given("I am logged in as  user {string}")
    public void i_am_logged_in_as_user1(String username) {
        sharedBy = app.getUser(username);
        if (sharedBy != null) {
            app.setactiveuser(sharedBy);
        } else {
            throw new RuntimeException("User not found: " + username);
        }
    }
@Ignore

    @Then("I should see an error message12 {string}")
    public void i_should_see_an_error_message12(String Message) {
        assertEquals(Message, msg);
    }
@Ignore

    @Then("I should see an message12 {string}")
    public void i_should_see_an_message12(String Message) {

        assertEquals(Message, msg);
    }
}
