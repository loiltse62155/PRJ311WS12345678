
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ly Tan loi
 */
public class Suppliers extends Vector<Supplier>{

    public Suppliers() {
        super();
    }
    public int find (String supCode){
        for(int i =0; i< this.size(); i++){
            if(supCode.equals(this.get(i).getSupCode()))
                return i;
        }
        return -1;
    }
    public Supplier findSupplier(String supCode){
        int i = find(supCode);
        return i < 0 ? null : this.get(i);
    }
    
    public void loadFromDB(ItemDBAccess dbObj){
        String supCode, supName, address;
        boolean colloborating;
        String sql = "select * from Suppliers";
        try {
            ResultSet rs = dbObj.executeQuery(sql);
            while(rs.next()){
                supCode = rs.getString(1);
                supName = rs.getString(2);
                address = rs.getString(3);
                colloborating = rs.getBoolean(4);
                Supplier supplier = new Supplier(supCode, supName, address, colloborating);
                this.add(supplier);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
}
