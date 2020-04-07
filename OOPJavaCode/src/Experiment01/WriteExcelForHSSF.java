package Experiment01;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class WriteExcelForHSSF {

	public void Excelwrite(ArrayList list) {

		// 创建excel工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建表单Sheet对象
		HSSFSheet sheet = wb.createSheet();

		// 创建Row对象
		HSSFRow row1 = sheet.createRow(0);
		HSSFRow row2 = sheet.createRow(1);
		HSSFRow row3 = sheet.createRow(2);
		HSSFRow row4 = sheet.createRow(3);
		HSSFRow row5 = sheet.createRow(4);

		// 创建Cell对象，并进行写操作

		// 第一行
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue("最高分");
		HSSFCell cell2 = row1.createCell(1);
		cell2.setCellValue("     ");
		HSSFCell cell3 = row1.createCell(2);
		cell3.setCellValue("最低分");
		HSSFCell cell4 = row1.createCell(3);
		cell4.setCellValue("     ");
		HSSFCell cell5 = row1.createCell(4);
		cell5.setCellValue("平均分");

		// 第二行
		cell1 = row2.createCell(0);
		cell1.setCellValue(String.format("%.0f",list.get(0)));
		cell2 = row2.createCell(1);
		cell2.setCellValue("     ");
		cell3 = row2.createCell(2);
		cell3.setCellValue(String.format("%.0f",list.get(1)));
		cell4 = row2.createCell(3);
		cell4.setCellValue("     ");
		cell5 = row2.createCell(4);
		cell5.setCellValue(String.format("%.0f",list.get(2)));

		// 第三行
		cell1 = row3.createCell(0);
		cell1.setCellValue("90分-100分");
		cell2 = row3.createCell(1);
		cell2.setCellValue("80分-89分");
		cell3 = row3.createCell(2);
		cell3.setCellValue("70分-79分");
		cell4 = row3.createCell(3);
		cell4.setCellValue("60分-69分");
		cell5 = row3.createCell(4);
		cell5.setCellValue("小于60");

		// 第四行
		cell1 = row4.createCell(0);
		cell1.setCellValue(String.format("%.0f", list.get(3)));
		cell2 = row4.createCell(1);
		cell2.setCellValue(String.format("%.0f",list.get(4)));
		cell3 = row4.createCell(2);
		cell3.setCellValue(String.format("%.0f",list.get(5)));
		cell4 = row4.createCell(3);
		cell4.setCellValue(String.format("%.0f",list.get(6)));
		cell5 = row4.createCell(4);
		cell5.setCellValue(String.format("%.0f",list.get(7)));

		// 第四行
		cell1 = row5.createCell(0);
		cell1.setCellValue(String.format("%.2f",list.get(8)));
		cell2 = row5.createCell(1);
		cell2.setCellValue(String.format("%.2f",list.get(9)));
		cell3 = row5.createCell(2);
		cell3.setCellValue(String.format("%.2f",list.get(10)));
		cell4 = row5.createCell(3);
		cell4.setCellValue(String.format("%.2f",list.get(11)));
		cell5 = row5.createCell(4);
		cell5.setCellValue(String.format("%.2f",list.get(12)));

		// 第三行
		// cell1 = row3.createCell(0);
		// cell1.setCellValue("李四");
		// cell2 = row3.createCell(1);
		// cell2.setCellValue("18");
		try {
			// 输出文件
			FileOutputStream output = new FileOutputStream("./分析报告.xls");
			wb.write(output);
			output.flush();
		} catch (Exception e) {
			// 上面程序正确时，不会执行此处代码
			System.out.println("出错了！");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		WriteExcelForHSSF a = new WriteExcelForHSSF();
		ArrayList list = new ArrayList<>();
					
		list.add(99.0);
		list.add(13.0);
		list.add(30.0);
		list.add(8.0);
		list.add(3.0);
		list.add(5.0);
		list.add(9.0);
		list.add(28.0);
		list.add(15.09433962264151);
		list.add(5.660377358490566);
		list.add(9.433962264150944);
		list.add(16.981132075471697);
		list.add(52.83018867924528);
		a.Excelwrite(list);
	}

}
