package DevOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	public WebDriver d;
	  @Test (priority=0)
	  public void mainTest() {
		  d.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		  d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
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
	  
	  @Test (priority=1)
	  public void search() {
		  WebElement search= d.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		  search.sendKeys("Dresses");
		  WebElement searchbtn= d.findElement(By.name("submit_search"));
		  searchbtn.click();
		  d.navigate().back();
	  }
	  
	  @Test(priority=2)
	  public void womenDress() {
	  Actions action= new Actions(d);
	  WebElement women= d.findElement(By.xpath("//a[text()='Women']"));
	  action.moveToElement(women).perform();
	  d.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
	  String expected="T-shirts1 - My Store";
	  Assert.assertEquals(expected, d.getTitle());
	  }

	  @Test(dependsOnMethods={"womenDress"})
	  public void dresses() {
	  Actions action= new Actions(d);
	  d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	  WebElement dresses= d.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
	  action.moveToElement(dresses).perform();
	  // driver.findElement(By.xpath("//li[@class='sfHover']//a[contains(text(),'Casual Dresses')]")).click();
	  }
	  @Test (dependsOnMethods={"womenDress"})
	  public void home() {
		  d.get("http://automationpractice.com/index.php");
	  }
	  @Test (priority=3)
	  public void redirect() {
		  d.get("http://automationpractice.com/index.php?fc=module&amp;module=blockwishlist&amp;controller=mywishlist");
	  }
	  @Test (priority=4)
	  public void home1() {
		  d.get("http://automationpractice.com/index.php");
	  }
	  
	  @Test(priority=5)
	  public void women() {
	  Actions action= new Actions(d);
	  WebElement women= d.findElement(By.xpath("//a[text()='Women']"));
	  d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	  action.moveToElement(women).perform();
	  d.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
	  String expected="T-shirts - My Store";
	  Assert.assertEquals(expected, d.getTitle());
	  d.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
	  }
	  
	  @Test(dependsOnMethods={"women"})
	  public void dresses1() {
	  d.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
	  Actions action= new Actions(d);
	  d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	  WebElement dresses= d.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
	  action.moveToElement(dresses).perform();
	  d.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")).click();
	  String expected="Casual Dresses - My Store";
	  Assert.assertEquals(expected, d.getTitle());
	  d.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
	  } 
	  
	  @Test (priority=6)
	  public void home2() {
		  d.get("http://automationpractice.com/index.php");
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


