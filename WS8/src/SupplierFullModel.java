
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ly Tan loi
 */
public class SupplierFullModel extends  AbstractTableModel{
    Suppliers suppliers = null;

    public SupplierFullModel(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
    
    public Suppliers getSuppliers(){
        return suppliers;
    }
    
    public int getRowCount(){
        return suppliers.size();
    }
    
    public int getColumnCount(){
        return 4;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
    
    public String getColumnName(int column){
        String columnName = "";
        switch(column){
            case 0:{
                columnName = "Code";
                break;
            }
            case 1:{
                columnName = "Name";
                break;
            }
            case 2:{
                columnName = "Address";
                break;
            }
            case 3:{
                columnName = "Colloborating";
                break;
            }
           
            
        }
        return  columnName;
    }
    public Object getValueAt(int row, int column){
        Supplier supplier = suppliers.get(row);
        Object obj = null;
        switch(column){
            case 0:{
                obj = supplier.getSupCode();
                break;
            }
            case 1:{
                obj = supplier.getSupName();
                break;
            }
            case 2:{
                obj = supplier.getAddress();
                break;
            }
            case 3:{
                obj = supplier.isColloborating();
                break;
            }
           
        }
        return obj;
    }
}
