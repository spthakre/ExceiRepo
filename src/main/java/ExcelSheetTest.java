import java.io.File;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.common.collect.Table.Cell;

import jxl.read.biff.BiffException;

public class ExcelSheetTest {

	 
		public static void main(String[] args) throws BiffException, IOException {

			File file = new File("Excelsheet.xls");
					
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int col=((Object) sheet).getColumns();
			int rw=sheet.getRows();
			System.out.println("column count: " +col);
			System.out.println("row count: " +rw);

	/*		Cell cell11 = sheet.getCell(100, 1000);
			System.out.println(cell11.getContents());
	*/		
			for(int i=0;i<rw;i++) {
				for(int j=0; j<col; j++) {
					Cell cell = sheet.getCell( j,i);
			
					System.out.print(cell.getContents());
					System.out.print(" "+" ");
				}
				System.out.println(" ");
			}
			
			System.out.println(" ");
		}
	}
	
	
	
	
	
	
	
	

