package lab2;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.*;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLoginUrl {
	
	public static void main(String args[]) {
		
		String driverPath=System.getProperty("user.dir")+"/src/firefoxdriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",driverPath);
		
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://103.120.226.190/selenium-demo/git-repo";
		String excel=System.getProperty("user.dir")+"/src/files/Selenium+Lab2020.xlsx";
		
		driver.get(baseUrl);

		System.out.println(driverPath);
		System.out.println(excel);
		
		Map<String, String> testMap=new TreeMap<String, String>();
		try {
			testMap = readExcelTuple(excel);
			
		Iterator<String> it=testMap.keySet().iterator();
		while(it.hasNext()) {
			String account=it.next();
			String passwd=testMap.get(account);
			
			driver.findElement(By.name("user_number")).sendKeys(account);
			driver.findElement(By.name("password")).sendKeys(passwd);
			driver.findElement(By.xpath("//input[@class='btn btn-primary btn-user btn-block']")).click();
			
			WebElement code=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
			String actual=code.getText();
			
			System.out.println();
			System.out.println("expected: "+passwd);
			System.out.println("actual: "+ actual);
			System.out.println("isEqual: "+(passwd.equals(actual)));
			System.out.println("--------------------------------------");
			
					
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			driver.quit();
		}
		
		
		
	}
	
	private static Map<String,String> readExcelTuple(String path) throws Exception{
		Map<String, String> result = new TreeMap<String,String>();
		
		File ex=new File(path);
		FileInputStream exStream=new FileInputStream(ex);
		
		//获取整个excel
		XSSFWorkbook hb=new XSSFWorkbook(exStream);
		
		Sheet sheet=hb.getSheetAt(0);
		//获取起始行和终止行
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("total rows: "+rows+"\n");
		
		for(int i=0;i<rows;i++) {
			Row row=sheet.getRow(i);
			if(row!=null) {
				String account=row.getCell(1).toString();
				String passwd=row.getCell(2).toString();
				if(account!="" && passwd!="") {
					System.out.println(account+"  "+passwd);
					result.put(account, passwd);	
				}
				}
			}
		exStream.close();
		hb.close();
		
		return result;
		}

	
	}
	

