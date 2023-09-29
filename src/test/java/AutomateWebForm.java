import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutomateWebForm{
    WebDriver driver;
    @BeforeAll
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Thread.sleep(5000);
    }

    @Test
    public void tc001() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"onetrust-button-group\"]/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("edit-name")).sendKeys("Demo Test");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-number")).sendKeys("+8801755555555");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"edit-agnew\"]/label[1]")).click();
        Thread.sleep(1000);
        String currentDate = java.time.LocalDate.now().toString();
        System.out.println(currentDate);
        String s[];
        s = currentDate.split("-");
        System.out.println("Year in S[0]: "+s[0]);
        System.out.println("Month in S[1]: "+s[1]);
        System.out.println("Date in S[2]: "+s[2]);
        driver.findElement(By.xpath("//input[@id='edit-date']")).sendKeys(s[2]);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='edit-date']")).sendKeys(s[1]);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='edit-date']")).sendKeys(Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='edit-date']")).sendKeys(s[0]);
        Thread.sleep(1000);
        driver.findElement(By.id("edit-email")).sendKeys("demo@test.com");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("There is nothing to say about me");
        Thread.sleep(1000);
        scroll();
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/images.jpg");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='edit-age']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("edit-submit")).click();
        Thread.sleep(1000);
        String expected = "Thank you for your submission!";
        String actual = driver.findElement(By.xpath("//*[@id=\"block-pagetitle-2\"]/h1")).getText();
        Assertions.assertEquals(expected, actual);
    }
    public void scroll()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,1000)");
    }
    @AfterAll
    public void tearDown()
    {
        driver.close();
    }
}