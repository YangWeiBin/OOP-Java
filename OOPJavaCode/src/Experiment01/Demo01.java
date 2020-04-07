package Experiment01;

import java.util.ArrayList;

public class Demo01 {
	
	public static void main(String[] args) {
    	ReadExcelForHSSF a = new ReadExcelForHSSF();
    	WriteExcelForHSSF b = new WriteExcelForHSSF();
    	ArrayList list = new ArrayList<>();
        a.read(list);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+"\t");
       }
       
       b.Excelwrite(list);
    }

}
