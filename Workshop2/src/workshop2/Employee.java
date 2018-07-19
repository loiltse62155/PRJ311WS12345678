/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

/**
 *
 * @author Ly Tan loi
 */
public class Employee {
    String code, name, adress;
    boolean sex;
    int salary;

    public Employee(String code, String name, String adress, boolean sex, int salary) {
        this.code = code;
        this.name = name;
        this.adress = adress;
        this.sex = sex;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public boolean isSex(){
        return sex;
    }
    public void setSex(boolean sex){
        this.sex = sex;
    }

    @Override
    public String toString() {
        String sexEmp = "Male";
        if(sex == false){
            sexEmp = "Female";
        }
        return code + ";" + name + ";" + adress + ";" + sexEmp + ";" + salary;
    }
    
    
}
