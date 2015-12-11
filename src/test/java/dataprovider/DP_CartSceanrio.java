package dataprovider;

import generic_component.Base_Class;
import generic_component.ExcelReadWrite;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DP_CartSceanrio {
	@DataProvider (name = "DP_addcart")
	public static Iterator<String[]> AddCart_DP() throws Exception
	{
		DP_CartSceanrio add = new DP_CartSceanrio();
		List<String[]> ls = add.excelhandler("AddCart");		
		return ls.iterator();
	}
	
	@DataProvider (name = "DP_updatecart")
	public static Iterator<String[]> updateCart_DP() throws Exception
	{
		DP_CartSceanrio update = new DP_CartSceanrio();
		List<String[]> ls = update.excelhandler("UpdateCart");		
		return ls.iterator();
	}
	
	@DataProvider (name = "DP_deletecart")
	public static Iterator<String[]> deleteCart_DP() throws Exception
	{
		DP_CartSceanrio delete = new DP_CartSceanrio();
		List<String[]> ls = delete.excelhandler("DeleteCart");		
		return ls.iterator();
	}
	
	public  List<String[]> excelhandler(String scriptname) throws Exception
	{
		Base_Class base = new Base_Class();
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+base.get_properties_file("Tese_script"));
		XSSFSheet sheet = xl.Setsheet("Scenario_Cart");
		List<String[]> ls = new ArrayList<String[]>();
		int rowCount = xl.getrowcount(sheet);
		for(int i =1;i<=rowCount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{				
			
				if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{
					String[] arr = new String[7];
					arr[0] = xl.Readvalue(sheet, i, "TC_ID");
					arr[1] = xl.Readvalue(sheet, i, "Order");
					arr[2] = xl.Readvalue(sheet, i, "Uname");
					arr[3] = xl.Readvalue(sheet, i, "Pwd");
					arr[4] = xl.Readvalue(sheet, i, "Search_Item");
					arr[5] = xl.Readvalue(sheet, i, "Quantity");
					arr[6] = xl.Readvalue(sheet, i, "Exp_Res");
					ls.add(arr);
				}
			}
			
		}		
		return ls;
	}

}
