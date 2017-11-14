package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import Transformation.EmailTransform;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate to Login Page");
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the login information$")
    public void iEnterTheLoginInformation(DataTable table) throws Throwable {
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        LoginPage page = new LoginPage(base.driver);

        for (User user : users)
        {
            page.Login(user.username, user.password);
        }
    }

    @And("^I click the login button$")
    public void iClickTheLoginButton() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.ClickLogin();
    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() throws Throwable {
        Assert.assertEquals(base.driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @Then("^I should still see the login page$")
    public void iShouldStillSeeTheLoginPage() throws Throwable {
        Assert.assertEquals(base.driver.findElement(By.id("Initial")).isDisplayed(), false);
    }


    public class User
    {
        public String username;
        public String password;

        public User(String username, String password)
        {
            this.username = username;
            this.password = password;
        }

    }
}
