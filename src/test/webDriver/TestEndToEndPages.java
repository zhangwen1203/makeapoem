import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEndToEndPages {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Create a new instance of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver");
        driver = new ChromeDriver();

        //Navigate to desired web page
        driver.get("http://localhost:8080/");

    }

    @Test
    public void shouldBeAbleEnterFirstSentenceAndClickNextToVerifySecondPage()
    {
        String headerMessage = "Make A Poem";
        String title = "Make A Poem";

        String firstSentence = "First";
        String firstSentenceName = "First Line :";

        String secondSentenceName = "Second Line :";

        verifyAddSentencePage(firstSentence, title, headerMessage, firstSentenceName, secondSentenceName);

    }

    public void verifyAddSentencePage(String addSentence, String title, String headerMessage, String sentenceName, String nextSentenceName) {

        // verify title of index page
        verifyTitle(title);

        //verify header of index page
        verifyHeaderMessage(headerMessage);

        verifySentenceName(sentenceName);

        //enter user name as Allen
        enterSentence(addSentence);

        //verify title of welcome page

        verifySentenceName(nextSentenceName);
    }

    private void verifyTitle(String expectedTitle) {
        //get the title of the page
        String actualTitle = driver.getTitle();

        // verify title
        assertThat(actualTitle, equalTo(expectedTitle));
    }

    private void verifyHeaderMessage(String expectedHeaderMessage) {
        // find header element
        WebElement element = driver.findElement(By.tagName("h2"));

        String actualHeaderMessage = element.getText();

        // verify header text
        assertThat(actualHeaderMessage, equalTo(expectedHeaderMessage));
    }
    private void verifySentenceName(String SentenceName) {
        // find header element
        WebElement element = driver.findElement(By.name("sentence"));

        String actualSentenceName = element.getText();

        // verify header text
        assertThat(actualSentenceName, equalTo(SentenceName));
    }
    private void enterSentence(String sentence) {
        // find the input text box
        WebElement element = driver.findElement(By.name("newSentence"));

        // set the sentence in input text box
        element.sendKeys(sentence);

        // submit form
        element.submit();
    }

}