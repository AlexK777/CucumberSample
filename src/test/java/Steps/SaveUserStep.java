package Steps;

import Base.BaseUtil;
import Pages.UserFormPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaveUserStep extends BaseUtil
{

    private BaseUtil base;

    public SaveUserStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the User Form page$")
    public void navigateToUserFormPage()
    {
        base.driver.navigate().to("http://executeautomation.com/demosite/index.html");
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @And("^I enter data into the required fields$")
    public void iEnterDataIntoTheRequiredFields(DataTable table) throws Throwable
    {
        UserFormPage page = new UserFormPage(base.driver);
        List<newUser> newUser = new ArrayList<SaveUserStep.newUser>();
        newUser = table.asList(newUser.class);

        for (newUser user : newUser)
        {
          //  page.selectTitle(user.title);
            page.enterInitial(user.initial);
            page.enterFirstName(user.firstName);
            page.enterMiddleName(user.middleName);
        }

    }

    @And("^I click the Save button$")
    public void iClickTheSaveButton() throws Throwable
    {
        UserFormPage page = new UserFormPage(base.driver);
        page.clickSave();
    }

    @Then("^The user is saved$")
    public void theUserIsSaved() throws Throwable
    {
        System.out.println("User was saved");
    }


    public class newUser
    {
        public String title;
        public String initial;
        public String firstName;
        public String middleName;

        public newUser(String title, String initial, String firstName, String middleName)
        {
            this.title = title;
            this.initial = initial;
            this.firstName = firstName;
            this.middleName = middleName;
        }

    }
}
