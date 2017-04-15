import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class SeleniumDemo {
    public static void main(String[] args) throws Exception {
        String property = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys("webinar.test@gmail.com");
        element = driver.findElement(By.name("passwd"));
        element.sendKeys("Xcg7299bnSmMuRLp9ITw");
        element.submit();
        sleep(1000);
        List<WebElement> elements = driver.findElements(By.className("maintab"));
        for (int i = 0; i < elements.size(); i++) {
            elements = driver.findElements(By.className("maintab"));
            if (elements.size() == 0) {
                elements = driver.findElements(By.className("link-levelone"));
            }
            elements.get(i).click();
            String before = driver.getTitle();
            System.out.println(before);
            sleep(1000);
            driver.navigate().refresh();
            String after = driver.getTitle();
            if (!after.equals(before)) {
                System.out.println("Другая страница");
            }
            sleep(1000);
        }
    }
}
