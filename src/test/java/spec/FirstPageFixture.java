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

@RunWith(ConcordionRunner.class)
public class FirstPageFixture {
    public String getGreeting() {
        return "Hello World!";
    }
}
