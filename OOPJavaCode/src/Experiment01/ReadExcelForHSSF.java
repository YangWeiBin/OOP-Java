package Experiment01;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;




public class ReadExcelForHSSF {
	public void read(ArrayList list) {
        File file = new File("./成绩单.xls"); 
        if (!file.exists())
            System.out.println("文件不存在");
        try {
            //1.读取Excel的对象
            //POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
            FileInputStream  poifsFileSystem = new FileInputStream("./成绩单.xls");
            //2.Excel工作薄对象
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            //3.Excel工作表对象
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            //总行数
            int rowLength = hssfSheet.getLastRowNum();
            //4.得到Excel工作表的行
            HSSFRow hssfRow = hssfSheet.getRow(0);
            //总列数
            int colLength = hssfRow.getLastCellNum();
            //得到Excel指定单元格中的内容
            HSSFCell hssfCell = hssfRow.getCell(0);
            //得到单元格样式
            CellStyle cellStyle = hssfCell.getCellStyle();
            
            
            // ArrayList list = new ArrayList<>();
            double max = -1, min = 101, average = 0;
            double gradeA = 0, gradeB = 0,gradeC = 0, gradeD = 0, gradeE = 0;
            for (int i = 0; i <= rowLength; i++) { 
                //获取Excel工作表的行
                HSSFRow hssfRow1 = hssfSheet.getRow(i);
                for (int j = 0; j < colLength; j++) {
                    //获取指定单元格
                    HSSFCell hssfCell1 = hssfRow1.getCell(j);
 
                    //Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
                    //Cannot get a STRING value from a NUMERIC cell
                    //将所有的需要读的Cell表格设置为String格式
                    if (hssfCell1 != null) {
                        hssfCell1.setCellType(CellType.STRING);
                    }
 
                    //获取每一列中的值
                 
                    if(i != 0 && j == 6 && !hssfCell1.getStringCellValue().equals(""))
                    {
                   	    int a = Integer.parseInt(hssfCell1.getStringCellValue());
                   	    
                   	    average += a * 1.0 / rowLength;
                   	    if(a > max)  //max 
                   	    	max = a;
                   	    if(a < min)  //min 
                   	    	min = a;
                   	    if(a >= 90)
                   	    	gradeA++;
                   	    else if(a >= 80)
                   	    	gradeB++;
                   	    else if(a >= 70)
                   	    	gradeC++;
                   	    else if(a >= 60)
                   	    	gradeD++;
                   	    else
                   	    	gradeE++;
                    }
                 
                    System.out.print(hssfCell1.getStringCellValue() + "\t");
                }
                System.out.println();
            }
            list.add(max);	list.add(min);	list.add(average);
            list.add(gradeA);	list.add(gradeB);	list.add(gradeC);
            list.add(gradeD);	list.add(gradeE);
            list.add(gradeA / rowLength * 100);	list.add(gradeB / rowLength * 100);	list.add(gradeC / rowLength * 100);
            list.add(gradeD / rowLength * 100);	list.add(gradeE / rowLength * 100);
            
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
    	ReadExcelForHSSF a = new ReadExcelForHSSF();
    	ArrayList list = new ArrayList<>();
        a.read(list);
        
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+"\t");
       }

        
    }

}
