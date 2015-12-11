package sceanrios_TCs;

import generic_component.Base_Class;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import pageObjectModel.POM_LoginScenario;

public class Login_Scenario extends Base_Class {
	
	static Logger log = Logger.getLogger(Login_Scenario.class);
	
	@Test(dataProvider = "DP_Invalid_scenario",dataProviderClass = dataprovider.DP_LoginScenario.class)
	public void invalid_login(String TC_ID,String Order,String Uname,String Pwd,String expected) throws Exception
	{
		log.info("The invalid login scenario has started" + TC_ID+" and "+ Order);
		
		Intialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_login_common_comp(Uname, Pwd);
		String actual = pom_login.Invalid_login_msg();
		//assert1.assertEquals(actual, expected);
		if(actual.equals(expected))
		{
			log.info("The invalid login scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The invalid login scenario validation has Failed "  + TC_ID+" and "+ Order);
			assert1.assertFalse(true);
		}
		tear_down();
		assert1.assertAll();
		log.info("The invalid login scenario  has completed "  + TC_ID+" and "+ Order);
	}

	
	@Test (dataProvider = "DP_valid_scenario",dataProviderClass = dataprovider.DP_LoginScenario.class)
	public void valid_login(String TC_ID,String Order,String Uname,String Pwd,String expected)throws Exception
	{
		log.info("The valid login scenario  has Started "  + TC_ID+" and "+ Order);
		
		Intialize_browser();
		POM_LoginScenario pom_login = new POM_LoginScenario(driver);
		pom_login.execute_login_common_comp(Uname, Pwd);
		String actual = pom_login.valid_login_msg();
		//assert1.assertEquals(actual, expected);
		if(actual.equals(expected))
		{
			log.info("The valid login scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The valid login scenario validation has Failed "  + TC_ID+" and "+ Order);
		}
		pom_login.Click_SignOut();
		tear_down();
		//assert1.assertAll();
		log.info("The valid login scenario  has completed "  + TC_ID+" and "+ Order);
	}

}
