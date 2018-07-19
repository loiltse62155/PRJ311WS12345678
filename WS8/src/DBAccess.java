
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DBAccess {
    Connection con = null;
    Statement stmt = null;

    public DBAccess() {
    }
    public void connectDB(String driver, String url){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    public ResultSet executeQuery(String selectSql){
        if(con == null){
            return null;
        }
        try {
            return (stmt.executeQuery(selectSql));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return null;
    }
    
    public int executeUpdate(String updatedSql){
        if(con == null)
            return 0;
        try {
            return (stmt.executeUpdate(updatedSql));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return 0;
    }
}
