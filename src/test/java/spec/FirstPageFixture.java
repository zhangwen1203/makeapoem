package spec;
/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/17/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webDriver.EndToEndPagesIT;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(ConcordionRunner.class)
public class FirstPageFixture {
    public String getGreeting() {
        return "Hello World!";
    }


    private WebDriver driver;
    private EndToEndPagesIT endToEndPagesIT;


    public void setUp() {
        // Create a new instance of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver");
        driver = new ChromeDriver();
        endToEndPagesIT = new EndToEndPagesIT();
        //Navigate to desired web page
        driver.get("http://localhost:8080/");

    }


    public String shouldBeAbleToTheNextPage(String pageName) {

        setUp();
        String nextSentenceName = "";
        String[] sentences = {"First", "Second", "Third", "Fourth"};
        ArrayList<String> sentenceNames = new ArrayList<String>();
        sentenceNames.addAll(Arrays.asList("First Line :", "Second Line :", "Third Line :", "Fourth Line :", ""));
        int pageIndex = sentenceNames.indexOf(pageName);

        for (int i = 0; i <= pageIndex; i++) {
            nextSentenceName = verifyGetNextPage(sentenceNames.get(i), sentences[i]);
        }

        closeDriver();
        return nextSentenceName;
    }
    public String shouldBeAbleToGetTheHeader() {
        setUp();
        WebElement element = driver.findElement(By.tagName("h1"));

        String actualHeaderMessage = element.getText();
        closeDriver();
        return actualHeaderMessage;
    }
    public String[] shouldBeAbleToGetFinalPage(String firstSentence,String secondSentence,String thirdSentence,String fourthSentence) {
        setUp();
        String nextSentenceName = "";
        String[] sentences = {firstSentence, secondSentence, thirdSentence, fourthSentence};
        ArrayList<String> sentenceNames = new ArrayList<String>();
        sentenceNames.addAll(Arrays.asList("First Line :", "Second Line :", "Third Line :", "Fourth Line :", ""));

        for (int i = 0; i < sentences.length; i++) {
            nextSentenceName = verifyGetNextPage(sentenceNames.get(i), sentences[i]);
        }
        System.out.println(nextSentenceName);

        WebElement element = driver.findElement(By.name("sentences"));

        String actualSentences = (element.getText()).replaceAll("\\n", "");
        String[] sentenceString = (element.getText()).split("\\n");

        for (int j = 0;j<sentenceString.length;j++){
             System.out.println(sentenceString[j]);
        }

        closeDriver();
        return sentenceString;
    }
    public String verifyGetNextPage(String sentenceName, String sentence) {

        WebElement element = driver.findElement(By.name("newSentence"));

        // set the sentence in input text box
        element.sendKeys(sentence);
        element.submit();

        WebElement element1 = driver.findElement(By.name("sentence"));

        return element1.getText();

    }
    public void closeDriver() {

        driver.close();

    }
}
