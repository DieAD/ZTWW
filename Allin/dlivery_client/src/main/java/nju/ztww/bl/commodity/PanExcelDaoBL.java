package nju.ztww.bl.commodity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.List;  

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.service.CommodityListDataService;
 
public class PanExcelDaoBL  {
private static String IP = "127.0.0.1";
private RMIHelper rhelper = new RMIHelper(IP,"1010");
private CommodityListDataService commoditylistdata;
  public void dao(String idofcenter,String time){
	  System.out.println("检测到");
	ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
	storagelist=new GetStockListBL().getStock(idofcenter);
	String[]title={"快递编号","入库日期","目的地","区号","排号","架号","位号"};
    HSSFWorkbook workbook=new HSSFWorkbook();
    //创建Excel
    HSSFSheet sheet=workbook.createSheet();
    //创建第一行
    HSSFRow row=sheet.createRow(0);
    HSSFCell cell=null;
    for(int i=0;i<title.length;i++){
   	 cell=row.createCell(i);
   	 cell.setCellValue(title[i]);
    }
    for(int i=1;i<storagelist.size();i++){
    	HSSFRow nextrow=sheet.createRow(i);
    	HSSFCell cell2=nextrow.createCell(0);
    	cell2.setCellValue(storagelist.get(i).getId());
    	cell2=nextrow.createCell(1);
    	cell2.setCellValue(storagelist.get(i).getData());
    	cell2=nextrow.createCell(2);
    	cell2.setCellValue(storagelist.get(i).getDestination());
    	cell2=nextrow.createCell(3);
    	cell2.setCellValue(storagelist.get(i).getQu());
    	cell2=nextrow.createCell(4);
    	cell2.setCellValue(storagelist.get(i).getJia());
    	cell2=nextrow.createCell(5);
    	cell2.setCellValue(storagelist.get(i).getPai());
    	cell2=nextrow.createCell(6);
    	cell2.setCellValue(storagelist.get(i).getWei());
    	
    }
    File file=new File("e:/"+time+".xls");
    try{
   	 file.createNewFile();
   	 FileOutputStream stream= new FileOutputStream(file);
   	 workbook.write(stream);
   	 stream.close();
    }catch(Exception  e){
    	System.out.println("文件不存在！");
   	 e.printStackTrace();
    }
	
}
   
}