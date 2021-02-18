package Other;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RMcreator {
    private static WebDriver wd;

    public static void main(String[] args) {
        String old_url = "http://redmine.mango.local/issues/235177";
        String new_url = "http://redmine.mango.local/issues/239671";
        init(old_url, new_url);
        stop();
    }

    private static void stop() {
        try {
            waiter(100);
            wd.findElement(By.cssSelector("a.logout")).click();
            wd.quit();
        } catch (Exception e) {
            e.printStackTrace();
            wd.quit();
        }
    }

    public static void init(String old_url, String new_url) {
        // System.setProperty("webdriver.chrome.driver", "../RMapp/src/main/resources/chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(old_url);

        wd.findElement(By.name("username")).sendKeys("yakorotyshov");
        wd.findElement(By.name("password")).sendKeys("VubxexJdTQ");
        wd.findElement(By.name("login")).click();


        List<WebElement> list_ticket_element = wd.findElements(By.xpath("//*[@class='status']/.."));
        System.out.println("All tikets in issue:");
        list_ticket_element
                .forEach(e ->
                        System.out.println(
                                e.findElement(By.cssSelector("td.subject"))
                                        .findElement(By.tagName("a"))
                                        .getText()
                                        .split("#")[1]
                        )
                );

        List<String> list_ticket = new ArrayList<>();



        for (WebElement e : list_ticket_element) {
            String number_ticket = e.findElement(By.cssSelector("td.subject")).findElement(By.tagName("a")).getText().split("#")[1];
            String status = e.findElement(By.cssSelector("td.status")).getText();
            if (!status.equals("Закрыт") && !status.equals("Отклонен")){
                System.out.println(number_ticket);
                list_ticket.add(number_ticket);
                e.findElement(By.cssSelector("td.buttons")).findElement(By.tagName("a")).click();
                try {
                    wd.switchTo().alert().accept();
                } catch (NoAlertPresentException e1){
                    System.out.println("WARN - no such alert");
                    e1.printStackTrace();
                }
            }
        }


        wd.get(new_url);
        wd.findElement(By.xpath("//*[@id='relations']/div/a")).click();
        for (String s : list_ticket) {
            waitForElementPresent(By.id("relation_issue_to_id")).sendKeys(s);
            wd.findElement(By.name("commit")).click();
            waiter(2000);
        }
    }

    public static void waiter(int millis){
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
            wd.quit();
        }
    }

    protected static WebElement waitForElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, 1);
        wait.withMessage("Element not present" + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
