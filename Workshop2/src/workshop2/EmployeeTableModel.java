/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ly Tan loi
 */
public class EmployeeTableModel<E> extends AbstractTableModel {

    String[] header;
    int[] indexes;
    Vector<Employee> data;

    public EmployeeTableModel(String[] header, int[] indexes) {
         int i = 0;
        this.header = new String[header.length];
        for (i = 0; i < header.length; i++) {
            this.header[i] = header[i];
        }
        this.indexes = new int[indexes.length];
        for (i = 0; i < header.length; i++) {
            this.indexes[i] = indexes[i];
        }

        this.data = new Vector<Employee>();
    }

    public Vector<Employee> getData() {
        return data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return (column >= 0 && column < header.length ? header[column] : "");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || rowIndex >= data.size() || columnIndex < 0 || columnIndex> header.length){
            return null;
        }
        Employee emp = data.get(rowIndex);
        switch(indexes[columnIndex]){
            case 0:{
                return emp.getCode();
            }
            case 1:{
                return emp.getName();
            }
            case 2:{
                return emp.getAdress();
            }
            case 3:{
                return emp.isSex();
            }
            case 4:{
                return emp.getSalary();
            }
           
        }
         return null;
    }

}
