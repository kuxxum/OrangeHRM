package Library_Files;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_BaseClass {
		public WebDriver driver;
			
			public void Initilize_Browser() throws InterruptedException
			
			{
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}

		}



