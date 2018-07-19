/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws6;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Ly Tan loi
 */
public class ManagerServerProgram {
    public static void main(String[] args){
        String serviceName = "rmi://localhost:1098/EmployeeService";
        String filename = "employee.txt";
        EmployeeServer server = null;
        try {
            server = new EmployeeServer(filename);
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            System.out.println(e
            );
        }
    }
}
