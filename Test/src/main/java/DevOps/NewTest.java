package DevOps;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	public WebDriver d;
  @Test
  public void mainTest() {
	  d.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	  WebElement wb1 = d.findElement(By.xpath("//*[@id=\"email\"]"));
	  WebElement wb2 = d.findElement(By.xpath("//*[@id=\"passwd\"]"));
	  WebElement btn = d.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));	
	  String email = "krs@gmail.com";
	  String pwd = "12345";
	  wb1.sendKeys(email);
	  wb2.sendKeys(pwd);
	  btn.click();
	  System.out.println("Page title : "+d.getTitle());
	  
	  
  }
  @BeforeTest
  public void beforeTest() {	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krati\\Documents\\SeleniumServer\\chromedriver.exe");	
	  d = new ChromeDriver();
	  d.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  WebElement signout = d.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
	  signout.click();
	  d.close();
	  
  }

}
