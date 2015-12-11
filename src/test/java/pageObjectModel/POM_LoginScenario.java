package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_LoginScenario {
	
	WebDriver driver = null;
	
	@FindBy (linkText ="Sign In")
	WebElement Link_SignIn;
	
	@FindBy (linkText ="Sign Out")
	WebElement Link_SignOut;
	
	@FindBy(name = "logid")
	WebElement TextBox_Uname;
	
	@FindBy(name = "pswd")
	WebElement TextBox_Pwd;
	
	@FindBy (css = "td[class = 'sb1'] input")
	WebElement Button_login;
	
	@FindBy (css = "body > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > font:nth-child(1) > b:nth-child(1)")
	WebElement Text_loginErrorMsg;
	
	@FindBy(css= "span[id = 'username'] a" )
	WebElement Text_valid_login_msg;
	
	public POM_LoginScenario (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_SignIn()
	{
		Link_SignIn.click();
	}
	
	public void Click_SignOut()
	{
		Link_SignOut.click();
	}
	public void Enter_UserName(String Uname)
	{
		TextBox_Uname.sendKeys(Uname);
	}
	
	public void Enter_Pwd(String Pwd)
	{
		TextBox_Pwd.sendKeys(Pwd);
	}
	
	public void click_login_button()
	{
		Button_login.click();
	}
	
	public String Invalid_login_msg()
	{
		return Text_loginErrorMsg.getText();
	}
	
	public String valid_login_msg()
	{
		return Text_valid_login_msg.getText();
	}
	
	public void execute_login_common_comp(String Uname , String Pwd)
	{
		Click_SignIn();
		Enter_UserName(Uname);
		Enter_Pwd(Pwd);
		click_login_button();
		
	}
	

}
