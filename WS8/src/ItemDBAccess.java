/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ly Tan loi
 */
public class ItemDBAccess extends DBAccess{
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://LOILTSE62155:1433; " + " databaseName = EmployeeDB; " + " user=sa; password=thebest96";
    public ItemDBAccess(){
        super();
        connectDB(driver, url);
    }
}
