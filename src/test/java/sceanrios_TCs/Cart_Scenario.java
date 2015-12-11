package sceanrios_TCs;

import generic_component.Base_Class;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjectModel.POM_CartScenario;
import pageObjectModel.POM_LoginScenario;
import pageObjectModel.POM_HomePage;

public class Cart_Scenario extends Base_Class {
	//SoftAssert assert1 = new SoftAssert();
	static Logger log = Logger.getLogger(Cart_Scenario.class);
	@Test(dataProvider = "DP_addcart",dataProviderClass=dataprovider.DP_CartSceanrio.class)
	public void add_cart(String TC_ID,String Order,String Uname,String Pwd,String Search_Item, String Quantity, String Exp_Res) throws Exception
	{
		log.info("The add_cart  scenario has started" + TC_ID+" and "+ Order);
		Intialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_login_common_comp(Uname, Pwd);
		
		POM_HomePage pom_search = new POM_HomePage(driver);
		pom_search.execute_search_functionality(Search_Item);
		pom_search.click_firstbook();
		pom_search.click_buynowbutton();
		
		POM_CartScenario pom_cart = new POM_CartScenario(driver);
		pom_cart.Enter_quatity_book(Quantity);
			
		String actual_text = pom_cart.get_book_cart();
		//assert1.assertEquals(actual_text, Exp_Res);
		if(actual_text.equals(Exp_Res))
		{
			log.info("The add_cart scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The add_cart scenario validation has Failed "  + TC_ID+" and "+ Order);
			Assert.fail();
		}
		pom_cart.click_link_rediff();
		pom_cart.click_link_signout();
		tear_down();
		//assert1.assertAll();
		log.info("The add_cart  scenario has Completed" + TC_ID+" and "+ Order);
	}
	
	@Test(dataProvider = "DP_updatecart",dataProviderClass=dataprovider.DP_CartSceanrio.class)
	public void update_cart(String TC_ID,String Order,String Uname,String Pwd,String Search_Item, String Quantity, String Exp_Res)throws Exception
	{
		log.info("The update_cart  scenario has Completed" + TC_ID+" and "+ Order);
		Intialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_login_common_comp(Uname, Pwd);
		
		POM_HomePage pom_search = new POM_HomePage(driver);
		pom_search.execute_search_functionality(Search_Item);
		pom_search.click_firstbook();
		pom_search.click_buynowbutton();
		
		POM_CartScenario pom_cart = new POM_CartScenario(driver);
		pom_cart.Enter_quatity_book(Quantity);
		String actual_quantity = pom_cart.get_quatity_book();
		if(actual_quantity.equals(Exp_Res))
		{
			log.info("The update_cart scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The update_cart scenario validation has Failed "  + TC_ID+" and "+ Order);
			Assert.fail();
		}
		//assert1.assertEquals(actual_quantity, Exp_Res);		
		pom_cart.click_link_rediff();
		pom_cart.click_link_signout();
		tear_down();
		//assert1.assertAll();
		log.info("The update_cart  scenario has Completed" + TC_ID+" and "+ Order);
	}
	
	@Test(dataProvider = "DP_deletecart",dataProviderClass=dataprovider.DP_CartSceanrio.class)
	public void delete_cart(String TC_ID,String Order,String Uname,String Pwd,String Search_Item, String Quantity, String Exp_Res)throws Exception
	{
		log.info("The delete_cart  scenario has Completed" + TC_ID+" and "+ Order);
		Intialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_login_common_comp(Uname, Pwd);
		
		POM_HomePage pom_search = new POM_HomePage(driver);
		pom_search.execute_search_functionality(Search_Item);
		pom_search.click_firstbook();
		pom_search.click_buynowbutton();
		
		POM_CartScenario pom_cart = new POM_CartScenario(driver);
		pom_cart.Enter_quatity_book(Quantity);
		pom_cart.click_delete_cart();	
		String actual = pom_cart.get_deletecart_msg();
		if(actual.equals(Exp_Res))
		{
			log.info("The delete_cart scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The delete_cart scenario validation has Failed "  + TC_ID+" and "+ Order);
			Assert.fail();
		}
		//assert1.assertEquals(actual, Exp_Res);
		pom_cart.click_link_rediff();
		pom_cart.click_link_signout();
		tear_down();
		//assert1.assertAll();
		log.info("The delete_cart  scenario has Completed" + TC_ID+" and "+ Order);
	}

}
