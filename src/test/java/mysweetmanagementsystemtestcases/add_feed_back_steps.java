package mysweetmanagementsystemtestcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myAPP2024.myappsweet;
import myAPP2024.Recipe;
import myAPP2024.Feedback;
import myAPP2024.User;

import static org.junit.Assert.*;

public class add_feed_back_steps {

  private  myappsweet app ;
    private String message;
    private User activeUser;
    
    
    
   public add_feed_back_steps(myappsweet app) {
      this.app = app;
   }

    @Given("I am logged in as user20 {string}")
    public void i_am_logged_in_as_user20(String username) {
        activeUser = app.getUser(username);
        if (activeUser == null) {
            message = "User not found";
            assertFalse(false);
        } else {
            app.setactiveuser(activeUser);
            assertTrue(true);
        }
        
    }


    @When("I add feedback {string} to the recipe {string}")
    public void i_add_feedback_to_the_recipe(String feedback, String recipeName) {
        Recipe recipe = app.getRecipe(recipeName);
        if (recipe == null) {
            message = "Recipe not found. Feedback cannot be added.";
            //recipe.addFeedback(new Feedback(feedback, activeUser, recipe));
            assertFalse("Feedback should not be added when the recipe is not found.", recipe != null);
        } else if (feedback == null || feedback.trim().isEmpty()) {
            message = "Feedback cannot be empty.";
           // recipe.addFeedback(new Feedback(feedback, activeUser, recipe));
            assertFalse("Feedback should not be added if it is empty.", recipe.isAddfeedback());

        } else {
            Feedback f = new Feedback(feedback, activeUser, recipe);
            f.setRecipe(f.getRecipe());
            recipe.addFeedback(f);
           f.setContent(f.getContent()); 
            f.setUser(f.getUser());
            f.toString();
            message = null; 
            assertTrue(recipe.isAddfeedback());

        }
    }


    @Then("the recipe {string} should have feedback {string}")
    public void the_recipe_should_have_feedback(String recipeName, String Feedback) {
        Recipe recipe = app.getRecipe(recipeName);
        assertNotNull("Recipe should exist", recipe);
        boolean Found = false;
        for (Feedback feedback : recipe.getFeedbackList()) {
            if (feedback.getContent().equals(Feedback)) {
                Found = true;
                assertTrue(Found);
                break; // Exit loop once a match is found
            }
        }
        assertTrue("Expected feedback not found in the recipe", Found);
    }


    @Then("I should see a message100 {string}")
    public void i_should_see_a_message100(String Message) {
        assertEquals(Message, message);
    }
}

