package Experiment01;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelForXSSF { 
		public void read() {
	        File file = new File("./成绩单.xlsx");
	        if (!file.exists())
	            System.out.println("文件不存在");
	        try {
	            //1.读取Excel的对象
	            //POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file)); // (不支持)
	            FileInputStream  poifsFileSystem = new FileInputStream("./成绩单.xlsx");
	            //2.Excel工作薄对象
	            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(poifsFileSystem);
	            //3.Excel工作表对象
	            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
	            //总行数
	            int rowLength = xssfSheet.getLastRowNum()+1;
	            //4.得到Excel工作表的行
	            XSSFRow xssfRow = xssfSheet.getRow(0);
	            //总列数
	            int colLength = xssfRow.getLastCellNum();
	            //得到Excel指定单元格中的内容
	            XSSFCell xssfCell = xssfRow.getCell(0);
	            //得到单元格样式
	            CellStyle cellStyle = xssfCell.getCellStyle();
	 
	            for (int i = 0; i < rowLength; i++) {
	                //获取Excel工作表的行
	                XSSFRow xssfRow1 = xssfSheet.getRow(i);
	                for (int j = 0; j < colLength; j++) {
	                    //获取指定单元格
	                    XSSFCell xssfCell1 = xssfRow1.getCell(j);
	 
	                    //Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
	                    //Cannot get a STRING value from a NUMERIC cell
	                    //将所有的需要读的Cell表格设置为String格式
	                    if (xssfCell1 != null) {
	                        xssfCell1.setCellType(CellType.STRING);
	                    }
	 
	                    //获取每一列中的值
	                    System.out.print(xssfCell1.getStringCellValue() + "\t");
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static void main(String[] args) {
	    	ReadExcelForXSSF a = new ReadExcelForXSSF();
	        a.read();
	    }

}
