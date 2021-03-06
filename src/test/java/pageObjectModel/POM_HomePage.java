package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_HomePage {
	WebDriver driver = null;
	@FindBy (id ="srchword")
	WebElement TextBox_Search;
	
	@FindBy (css = "input[class = newsrchbtn]")
	WebElement Button_Search;
	
	@FindBy(xpath = "//div[@class='divbooklist']/div/a/img")
	WebElement link_firstbook;
	
	@FindBy(className = "addtocartbtn")
	WebElement Button_addtocarton;
	
	@FindBy(id="find")
	WebElement valid_search_mesg;
	
	@FindBy(css = "p[class='sorrymsg']")
	WebElement Invalid_search_msg;
	
	public POM_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_firstbook()
	{
		link_firstbook.click();
	}
	
	public void click_buynowbutton()
	{
		
		Button_addtocarton.click();
	}
	
	public void Enter_searchword(String Search_Item)
	{
		TextBox_Search.sendKeys(Search_Item);
	}
	public void click_searchword()
	{
		Button_Search.click();
	}
	public String get_valid_message()
	{
		return valid_search_mesg.getText();
	}
	
	public String get_invalid_message()
	{
		return Invalid_search_msg.getText();
	}
	
	public void execute_search_functionality(String Search_Item)
	{
		Enter_searchword(Search_Item);
		click_searchword();
	}

}
