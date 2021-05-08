package Experiment01;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileOutputStream;

public class WriteExcelForXSSF {

	public void Excelwrite() {

		// 创建excel工作簿对象
		XSSFWorkbook wb = new XSSFWorkbook();

		// 创建表单Sheet对象
		XSSFSheet sheet = wb.createSheet();

		// 创建Row对象
		XSSFRow row1 = sheet.createRow(0);
		XSSFRow row2 = sheet.createRow(1);
		XSSFRow row3 = sheet.createRow(2);

		// 创建Cell对象，并进行写操作

		// 第一行
		XSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue("姓名");
		XSSFCell cell2 = row1.createCell(1);
		cell2.setCellValue("年龄");

		// 第二行
		cell1 = row2.createCell(0);
		cell1.setCellValue("张三");
		cell2 = row2.createCell(1);
		cell2.setCellValue("20");

		// 第三行
		cell1 = row3.createCell(0);
		cell1.setCellValue("李四");
		cell2 = row3.createCell(1);
		cell2.setCellValue("18");
		try {
			// 输出文件
			FileOutputStream output = new FileOutputStream("./test.xlsx");
			wb.write(output);
			output.flush();
		} catch (Exception e) {
			// 上面程序正确时，不会执行此处代码
			System.out.println("出错了！");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		WriteExcelForXSSF a = new WriteExcelForXSSF();
		a.Excelwrite();
	}

}