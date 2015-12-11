package dataprovider;

import generic_component.Base_Class;
import generic_component.ExcelReadWrite;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DP_SearchScenario {
	
	@DataProvider(name = "DP_invalid_Search")
	public static Iterator<String[]> invalidsearch_DP() throws Exception
	{
		DP_SearchScenario invalid = new DP_SearchScenario();
		List<String[]> ls = invalid.excelhandler("Invalid_Search");
		return ls.iterator();
	}
	
	@DataProvider(name = "DP_valid_Search")
	public static Iterator<String[]> validsearch_DP() throws Exception
	{
		DP_SearchScenario valid = new DP_SearchScenario();
		List<String[]> ls = valid.excelhandler("valid_Search");
		return ls.iterator();
	}
	
	public  List<String[]> excelhandler(String scriptname) throws Exception
	{
		Base_Class base = new Base_Class();
		ExcelReadWrite xl = new ExcelReadWrite(System.getProperty("user.dir")+base.get_properties_file("Tese_script"));
		XSSFSheet sheet = xl.Setsheet("Scenario_Search");
		List<String[]> ls = new ArrayList<String[]>();
		int rowCount = xl.getrowcount(sheet);
		for(int i=1;i<=rowCount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{
				if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"));
				{
					String[] arr = new String[4];
					arr[0] = xl.Readvalue(sheet, i, "TC_ID");
					arr[1] = xl.Readvalue(sheet, i, "Order");
					arr[2] = xl.Readvalue(sheet, i, "Search_Item");
					arr[3] = xl.Readvalue(sheet, i, "Exp_Res");
					ls.add(arr);
				}
			}
		}return ls;
	}

}
