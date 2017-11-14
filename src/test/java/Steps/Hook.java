package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil
{
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest()
    {
        System.out.println("Opening the ChromeDriver");

        //Pass WebDriver instance
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Jar Files\\chromedriver.exe");
        base.driver = new ChromeDriver();
    }

    @After
    public void tearDownTest()
    {
        System.out.println("Closing the browser");
        base.driver.close();
    }
}
