package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_CartScenario {
	WebDriver driver = null;
	@FindBy(xpath = "//div[@class='divbooklist']/div/a/img")
	WebElement link_firstbook;
	
	@FindBy(className = "addtocartbtn")
	WebElement Button_addtocarton;
	
	@FindBy(xpath=".//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/input")
	WebElement textbox_addtocarton;
	
	@FindBy(css = ".text_height > span:nth-child(2)")
	WebElement text_cart;
	
	@FindBy(linkText = "rediff.com")
	WebElement link_rediff;
	
	@FindBy(linkText = "Sign out")
	WebElement link_Signout;
	
	@FindBy(xpath=".//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[1]/div")
	WebElement icon_deletecart;
	
	@FindBy(xpath="//span[@id = 'currentcartdiv']/div[3]/form/div/span")
	WebElement text_deletecart;
	
	
	
	public POM_CartScenario(WebDriver driver)
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

	public String get_quatity_book()
	{
		return textbox_addtocarton.getAttribute("value");
	}
	
	public void Enter_quatity_book(String quantity)
	{
		textbox_addtocarton.clear();
		textbox_addtocarton.sendKeys(quantity);
	}
	
	public void click_delete_cart()
	{
		icon_deletecart.click();
	}
	
	public String get_deletecart_msg()
	{
		return text_deletecart.getText();
	}
	
	public String get_book_cart()
	{
		return text_cart.getText();
	}
	
	public void click_link_rediff()
	{
		link_rediff.click();
	}
	
	public void click_link_signout()
	{
		link_Signout.click();
	}
	
	public void excute_common_Cartmethods()
	{
		click_firstbook();
		click_buynowbutton();
	}

}
