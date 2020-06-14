import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.util.HashMap;
import java.util.Scanner;

public class StudentNumberException {
    public static void main (String[]args) throws IOException {
     Scanner sc =new Scanner(System.in);
     String[] one;
     factory  shuzhu = new factory();
     while (sc.hasNext()){
           one=sc.nextLine().split(" ");
           switch (one[0]){
               case"init": {
                   switch (one[1]) {
                       case "0":
                           SalaridEmployee x = new SalaridEmployee(one[2], one[3], one[4], Double.valueOf(one[5]));
                           shuzhu.initEmployees(x);
                           break;

                       case "1":
                           HourlyEmployee y = new HourlyEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Integer.valueOf(one[6]));
                           shuzhu.initEmployees(y);
                           break;

                       case "2":
                           CommisionEmployee z = new CommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]));
                           shuzhu.initEmployees(z);
                           break;

                       case "3":
                           BasePlusCommisionEmployee v = new BasePlusCommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]), Double.valueOf(one[7]));
                           shuzhu.initEmployees(v);
                           break;
                       case "-1":break;
                   }break;
               }
               case"get":shuzhu.getEmployee(one[1]);break;
               case"add": {
                   switch (one[1]) {
                       case "0":
                           SalaridEmployee x = new SalaridEmployee(one[2], one[3], one[4], Double.valueOf(one[5]));
                           shuzhu.addEmployee(x);
                           break;

                       case "1":
                           HourlyEmployee y = new HourlyEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Integer.valueOf(one[6]));
                           shuzhu.addEmployee(y);
                           break;

                       case "2":
                           CommisionEmployee z = new CommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]));
                           shuzhu.addEmployee(z);
                           break;

                       case "3":
                           BasePlusCommisionEmployee v = new BasePlusCommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]), Double.valueOf(one[7]));
                           shuzhu.addEmployee(v);
                           break;

                   }break;
               }
               case "update": {
                   switch (one[1]) {
                       case "0":
                           SalaridEmployee x = new SalaridEmployee(one[2], one[3], one[4], Double.valueOf(one[5]));
                           shuzhu.updateEmployee(x.getSocialSecurityNumber(), x);
                           break;

                       case "1":
                           HourlyEmployee y = new HourlyEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Integer.valueOf(one[6]));
                           shuzhu.updateEmployee(y.getSocialSecurityNumber(), y);
                           break;

                       case "2":
                           CommisionEmployee z = new CommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]));
                           shuzhu.updateEmployee(z.getSocialSecurityNumber(), z);
                           break;

                       case "3":
                           BasePlusCommisionEmployee v = new BasePlusCommisionEmployee(one[2], one[3], one[4], Double.valueOf(one[5]), Double.valueOf(one[6]), Double.valueOf(one[7]));
                           shuzhu.updateEmployee(v.getSocialSecurityNumber(), v);
                           break;

                   }break;

               }
               case"delete":shuzhu.deleteEmployee(one[1]);break;
               case"print":shuzhu.printEmployees();break;
           }
     }
    }

}

class factory{
    private HashMap employees;
    public HashMap getEmployees(){
        return employees;
    }
    public factory(){
        employees =new HashMap();
    }
     public void initEmployees(Employee es){
        employees.put(es.getSocialSecurityNumber(),es);
     }
     public Employee getEmployee( String empSecNum){
          if(employees.containsKey(empSecNum)){
              System.out.println (employees.get(empSecNum));
              return null;

          }
          else {
              System.out.println("get: employee not found.");
              return null;
          }
     }
     public Employee deleteEmployee(String empSecNum){
         if(employees.containsKey(empSecNum)){
             System.out.println (employees.get(empSecNum));
             employees.remove(empSecNum);
             return null;

         }
         else {
             System.out.println("delete: employee not found.");
             return null;
         }
     }
     public Employee addEmployee(Employee stu){
        if (employees.containsKey(stu.getSocialSecurityNumber())){
            System.out.println("add: employee exists.");
            return null;
        }
        else{employees.put(stu.getSocialSecurityNumber(),stu);
            System.out.println(stu);
            return null;
        }
     }
     public Employee updateEmployee(String empSecNum ,Employee emp){
        if (employees.containsKey(empSecNum)){
            employees.remove(empSecNum);
            employees.put(emp.getSocialSecurityNumber(),emp);
            System.out.println(employees.get(empSecNum));
            return emp;
        }
        else {
            System.out.println("update: employee not found.");
            return null;
        }
     }
     public void printEmployees(){
        System.out.println(employees);
     }
}

abstract class Employee{
    private String firstName,lastName;
    public String socialSecurityNumber;

    public Employee(String first,String last,String number){
        this.firstName=first;
        this.lastName=last;
        this.socialSecurityNumber=number;
    };
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
public abstract double earning();

}
class SalaridEmployee extends Employee{
    private double weeklySalary;
    public SalaridEmployee(String first1,String last1,String number1,double s){
        super(first1,last1,number1);
          weeklySalary =s;
    }
    public void setWeeklySalary(double zhouxin){
        weeklySalary=zhouxin;
    }
    public  double getWeeklySalary(){
        return weeklySalary;
    }
    public double earning() {
        return weeklySalary*4;
    }
    public String toString(){
        return("firstName:"+getFirstName()+"; "+"lastName:"+getLastName()+"; "+"socialSecurityNumber:"+getSocialSecurityNumber()+"; "+"earning:"+String.format("%.2f",earning()));
    }
}
class HourlyEmployee extends Employee{
    private double wage;
    private int  hour;
    public HourlyEmployee(String first2,String last2,String number2,double wage2,int hour2){
        super(first2,last2,number2);
        wage=wage2;
        hour=hour2;
    }
    public void setWage(double wage1){
        wage=wage1;
    }
    public double getWage(){
        return wage;
    }
    public void setHour(int hour1){
        hour=hour1;
    }
    public int getHour() {
        return hour;
    }
    public double earning() {
        return wage*hour;

    }
    public String toString(){
        return("firstName:"+getFirstName()+"; "+"lastName:"+getLastName()+"; "+"socialSecurityNumber:"+getSocialSecurityNumber()+"; "+"earning:"+String.format("%.2f",earning()));
    }
}
class CommisionEmployee extends Employee{
    private double grosssales,commissionrate;
    public CommisionEmployee(String first2,String last2,String number2,double grosssales2,double commissionrate2){
        super(first2,last2,number2);
        grosssales=grosssales2;
        commissionrate=commissionrate2;
    }
    public void setGrosssales(double grosssales1){
        grosssales = grosssales1;
    }
    public void setCommissionrate(double commissionrate1){
        commissionrate=commissionrate1;
    }

    public double getGrosssales() {
        return grosssales;
    }

    public double getCommissionrate() {
        return commissionrate;
    }

    public double earning() {
        return grosssales*commissionrate;
    }
    public String toString(){
        return("firstName:"+getFirstName()+"; "+"lastName:"+getLastName()+"; "+"socialSecurityNumber:"+getSocialSecurityNumber()+"; "+"earning:"+String.format("%.2f",earning()));
    }
}
class BasePlusCommisionEmployee extends CommisionEmployee{
   private double basesalary;
    public BasePlusCommisionEmployee(String first2,String last2,String number2,double grosssales2,double commissionrate2,double basesalary1){
        super(first2,last2,number2,grosssales2,commissionrate2);
        basesalary=basesalary1;
    }
    public void setBasesalary(double basesalary2){
        basesalary=basesalary2;
    }
    public double getBasesalary(){
        return basesalary;
    }
    public double earning(){
       return (this.getCommissionrate()*getGrosssales()+basesalary);

    }
    public String toString(){
        return("firstName:" + getFirstName() + "; " + "lastName:" + getLastName() + "; " + "socialSecurityNumber:" + getSocialSecurityNumber() + "; " + "earning:" +String.format("%.2f",earning()));
    }
}
