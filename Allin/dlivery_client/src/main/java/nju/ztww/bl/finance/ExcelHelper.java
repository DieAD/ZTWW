package nju.ztww.bl.finance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.PaymentPO;
import nju.ztww.service.FinanceDataService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelHelper {
	private static String IP = "127.0.0.1";
	private RMIHelper rmi = new RMIHelper(IP,"1010");
	private FinanceDataService financeDataService;
	
	
	
	public ArrayList<PaymentPO> getDOList(){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		ArrayList<PaymentPO> list = new ArrayList<PaymentPO>();
		try {
			list = financeDataService.getAllPaymentDO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
//	public void BusinessToExcel(ArrayList<>){
//		
//	}
	public void BusinessToExcel(Double totalCollection,Double totalPay,Double totalBenefit){
		String[] title = {"总收入","总支出","总利润"};
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		
		HSSFRow row=sheet.createRow(0);
	    HSSFCell cell=null;
	    for(int i=0;i<title.length;i++){
	   	 cell=row.createCell(i);
	   	 cell.setCellValue(title[i]);
	    }
	    HSSFRow nextrow=sheet.createRow(1);
    	HSSFCell cell2=nextrow.createCell(0);
    	cell2.setCellValue(totalCollection);
    	
    	cell2 = nextrow.createCell(1);
    	cell2.setCellValue(totalPay);
    	
    	cell2 = nextrow.createCell(2);
    	cell2.setCellValue(totalBenefit);
    	//
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss收益表");
 		String fileName = df.format(new Date());
 		
 		File file = new File("e:/"+fileName+".xls");
 		 try {
 			file.createNewFile();
 			FileOutputStream stream= new FileOutputStream(file);
 		   	 workbook.write(stream);
 		   	 stream.close();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
	}
	//-------------------------------------
	public void CollectionToExcel(){
		financeDataService = (FinanceDataService) rmi
				.findService("FinanceDataService");
		ArrayList<CollectionPO> list = null;
		try {
		    list = financeDataService.totalCollection();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//----------create excel title;
		String[] title = {"收款日期","收款金额","快件编号","快递员编号"};
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		
		HSSFRow row=sheet.createRow(0);
	    HSSFCell cell=null;
	    for(int i=0;i<title.length;i++){
	   	 cell=row.createCell(i);
	   	 cell.setCellValue(title[i]);
	    }
	    //--------create contain;
	    for(int i=0;i<list.size();i++){
	    	HSSFRow nextrow=sheet.createRow(i+1);
	    	HSSFCell cell2=nextrow.createCell(0);
	    	cell2.setCellValue(list.get(i).getDate());
	    	
	    	cell2 = nextrow.createCell(1);
	    	cell2.setCellValue(list.get(i).getMoney());
	    	
	    	cell2 = nextrow.createCell(2);
	    	cell2.setCellValue(list.get(i).getCourierid());
	    	
	    	cell2 = nextrow.createCell(3);
	    	cell2.setCellValue(list.get(i).getGoodsid()); 	
	    }
	    // fileName;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss收款单");
		String fileName = df.format(new Date());
		
		File file = new File("e:/"+fileName+".xls");
		 try {
			file.createNewFile();
			FileOutputStream stream= new FileOutputStream(file);
		   	 workbook.write(stream);
		   	 stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void PaymentToExcel(){
		ArrayList<PaymentPO> list = getDOList();
		String[] title = {"付款日期","付款金额","付款账号","付款人","条目","备注"};
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		
		HSSFRow row=sheet.createRow(0);
	    HSSFCell cell=null;
	    for(int i=0;i<title.length;i++){
	   	 cell=row.createCell(i);
	   	 cell.setCellValue(title[i]);
	    }
	    
	    for(int i=0;i<list.size();i++){
	    	HSSFRow nextrow=sheet.createRow(i+1);
	    	HSSFCell cell2=nextrow.createCell(0);
	    	cell2.setCellValue(list.get(i).getDate());
	    	
	    	cell2 = nextrow.createCell(1);
	    	cell2.setCellValue(list.get(i).getMoney());
	    	
	    	cell2 = nextrow.createCell(2);
	    	cell2.setCellValue(list.get(i).getPayaccount());
	    	
	    	cell2 = nextrow.createCell(3);
	    	cell2.setCellValue(list.get(i).getPaymen());
	    	
	    	cell2 = nextrow.createCell(4);
	    	cell2.setCellValue(list.get(i).getPaycat());
	    	
	    	cell2 = nextrow.createCell(5);
	    	cell2.setCellValue(list.get(i).getPs());
	    }
	    
	    // fileName;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss付款单");
		String fileName = df.format(new Date());
		
		File file = new File("e:/"+fileName+".xls");
		 try {
			file.createNewFile();
			FileOutputStream stream= new FileOutputStream(file);
		   	 workbook.write(stream);
		   	 stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 
	}
	
	public static void main(String[] args){
		ExcelHelper excelHelper = new ExcelHelper();
		excelHelper.CollectionToExcel();
 	}
}
