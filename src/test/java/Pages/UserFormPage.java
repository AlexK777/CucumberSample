package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserFormPage
{
    public UserFormPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "TitleId")
    public Select slctTitle;

    @FindBy(how = How.NAME, using = "Initial")
    public WebElement txtInitial;

    @FindBy(how = How.NAME, using = "FirstName")
    public WebElement txtFirstName;

    @FindBy(how = How.NAME, using = "MiddleName")
    public WebElement txtMiddleName;

    @FindBy(how = How.NAME, using = "Save")
    public WebElement btnSave;

    public void selectTitle(String title)
    {
        slctTitle.selectByVisibleText(title);
    }

    public void enterInitial(String initial)
    {
        txtInitial.sendKeys(initial);
    }

    public void enterFirstName(String firstName)
    {
        txtFirstName.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName)
    {
        txtMiddleName.sendKeys(middleName);
    }

    public void clickSave()
    {
        btnSave.click();
    }
}
