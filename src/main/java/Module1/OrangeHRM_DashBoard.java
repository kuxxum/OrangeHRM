package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_DashBoard {
	@FindBy(xpath="//p [text() = 'Java Automation']") private WebElement UserNameOfDashBoard;
	@FindBy(xpath="//a[text()='Logout']")private WebElement LogOutBtn;
	public OrangeHRM_DashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String gettextofUsername() {
		String actual = UserNameOfDashBoard.getText();
		return actual;
	}
	public void ClickUsername()
	{
		UserNameOfDashBoard.click();
	}
	public void ClickLogout()
	{
		LogOutBtn.click();
	}
	}
