package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getLoginData() throws IOException{
		String path="./testData/opencart_loginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrow=xlutil.getRowCount("Sheet1");
		int totalcell=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrow][totalcell];
		
		for(int r=1;r<=totalrow;r++) {
			for(int c=0;c<totalcell;c++) {
				logindata[r-1][c]=xlutil.getCellData("Sheet1", r, c);
			}
		}
		return logindata;
		
	}

}
