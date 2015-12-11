package dataprovider;

import generic_component.Base_Class;
import generic_component.ExcelReadWrite;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DP_LoginScenario {
	
	@DataProvider (name = "DP_Invalid_scenario")
	public static Iterator<String[]> Invalid_Login_DP() throws Exception
	{
		DP_LoginScenario invalid = new DP_LoginScenario();
		List<String[]> ls = invalid.excelhandler("Invalid_Login_test");		
		return ls.iterator();
	}
	
	@DataProvider (name = "DP_valid_scenario")
	public static Iterator<String[]> valid_Login_DP() throws Exception
	{
		DP_LoginScenario valid = new DP_LoginScenario();
		List<String[]> ls = valid.excelhandler("Valid_Login_test");		
		return ls.iterator();
	}
	
	public List<String[]> excelhandler(String scriptname) throws Exception
	{
		Base_Class base = new Base_Class();
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+base.get_properties_file("Tese_script"));
		XSSFSheet sheet = xl.Setsheet("Scenario_Login");
		List<String[]> ls = new ArrayList<String[]>();
		int rowCount = xl.getrowcount(sheet);
		for(int i =1;i<=rowCount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{				
			
				if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{
					String[] arr = new String[5];
					arr[0] = xl.Readvalue(sheet, i, "TC_ID");
					arr[1] = xl.Readvalue(sheet, i, "Order");
					arr[2] = xl.Readvalue(sheet, i, "Uname");
					arr[3] = xl.Readvalue(sheet, i, "Pwd");
					arr[4] = xl.Readvalue(sheet, i, "Exp_Res");
					ls.add(arr);
				}
			}
			
		}	
		System.out.println();
		return ls;
	}

}
