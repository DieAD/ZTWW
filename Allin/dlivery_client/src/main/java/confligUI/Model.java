package confligUI;

import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel{
	
	Object[][] orders = null;
	String[] head = null;
	 Class[] typeArray = { Boolean.class, String.class, String.class,  
			 String.class, String.class};
	
	public Model(Object[][] orders, String[] head){
		this.orders = orders;
		this.head = head;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return orders.length;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return head.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		 return orders[rowIndex][columnIndex];
	}
	public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];// 返回每一列的数据类型  
    }  
	 public boolean isCellEditable(int rowIndex, int columnIndex) {  
	        return true;  
	    }  
	 @Override  
	    public String getColumnName(int column) {  
	        return head[column];  
	    }  
	 @Override  
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
	        orders[rowIndex][columnIndex] = aValue;  
	        fireTableCellUpdated(rowIndex, columnIndex);  
	    }  
	 
	 
}
