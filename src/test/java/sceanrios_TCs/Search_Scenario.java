package sceanrios_TCs;

import generic_component.Base_Class;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;


import pageObjectModel.POM_HomePage;

public class Search_Scenario extends Base_Class{
	
	static Logger log = Logger.getLogger(Search_Scenario.class);
	//SoftAssert assert1 = new SoftAssert();
	@Test(dataProvider = "DP_valid_Search",dataProviderClass = dataprovider.DP_SearchScenario.class)
	public void ValidSearch(String TC_ID, String Order,String Search_Item, String expected) throws Exception
	{
		log.info("The Valid Search  scenario has started" + TC_ID+" and "+ Order);
		Intialize_browser();
		POM_HomePage pom_search = new POM_HomePage(driver);
		pom_search.execute_search_functionality(Search_Item);
		String actual = pom_search.get_valid_message();
		if(actual.equals(expected))
		{
			log.info("The Valid Search  scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The Valid Search  scenario validation has Failed "  + TC_ID+" and "+ Order);
			tear_down();
			Assert.fail();
						
		}
		//assert1.assertEquals(actual, expected);
		tear_down();
		assert1.assertAll();
		log.info("The Valid Search  scenario has completed" + TC_ID+" and "+ Order);
	}
	
	//@Test (dataProvider = "DP_invalid_Search",dataProviderClass = dataprovider.DP_SearchScenario.class)
	public void InvalidSearch(String TC_ID, String Order,String Search_Item, String expected) throws Exception
	{
		log.info("The Invalid Search  scenario has started" + TC_ID+" and "+ Order);
		Intialize_browser();
		POM_HomePage pom_search = new POM_HomePage(driver);
		pom_search.execute_search_functionality(Search_Item);
		String actual = pom_search.get_invalid_message();
		if(actual.equals(expected))
		{
			log.info("The Invalid Search  scenario validation has passed " + TC_ID+" and "+ Order);
		}
		else
		{
			log.error("The Invalid Search  scenario validation has Failed "  + TC_ID+" and "+ Order);
			assert1.assertTrue(false);
		}
		//assert1.assertEquals(actual, expected);
		tear_down();
		assert1.assertAll();
		log.info("The Invalid Search  scenario has completed" + TC_ID+" and "+ Order);
	}

}
