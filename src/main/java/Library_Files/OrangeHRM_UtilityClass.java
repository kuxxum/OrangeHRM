package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class OrangeHRM_UtilityClass {
	//Automation by : Ankit
	//Date: 17-5-24
	//Day: Friday
	@Test
	public static String getdatafromExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException{
		FileInputStream file = new FileInputStream("C:\\Users\\ANKIT\\Desktop\\revision.xlsx");
		String Value1 = WorkbookFactory.create(file).getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return Value1;
	}
    @Test
    public static void CaptureScreenshot(WebDriver driver, String TestCaseID) throws IOException {
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File dest = new File ("D:\\"+TestCaseID+".jpg");
    	FileHandler.copy(src, dest);
    }
}
