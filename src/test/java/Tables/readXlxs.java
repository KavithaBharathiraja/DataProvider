package Tables;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readXlxs {

	static WebDriver driver;
	
	public  String[][] getdata() throws Exception{
		
		
		WebDriverManager .chromedriver ().setup();
		driver=new ChromeDriver ();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
      File filePath = new File("/Users/kavithabharathiraja/eclipse-workspace-new/DataProvider/src/test/resources/read_Xlxs.numbers");
		
		System.out.println(filePath.exists ());
		
		FileInputStream excelfile = new FileInputStream(filePath);
		
		XSSFWorkbook excelworkbook = new XSSFWorkbook(excelfile);
		
		XSSFSheet excelWorkSheet = excelworkbook.getSheet ("Sheet 1");
		
		int totalRows = excelWorkSheet.getPhysicalNumberOfRows();
		System.out.println(totalRows);
		int totalCols = excelWorkSheet.getRow(0).getLastCellNum();
		System.out.println(totalCols);
		
		String[][] data=new String[totalRows-1][totalCols];
		
		for (int i=0; i<totalRows-1;i++) {
		for (int j=0; j<totalCols;j++) {
		
		DataFormatter df =new DataFormatter ();
		
		data[i][j]= df.formatCellValue(excelWorkSheet.getRow(i+1).getCell(j));// string convertor
		
		System.out.print("\t");
		
		}
		
		System.out.println("");
		
		}
		
		excelworkbook.close();
		
		excelfile.close () ;
		
		return data;
	}
		
		
		
	}


