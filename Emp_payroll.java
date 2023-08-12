//Employee Payroll Management System

import java.util.ArrayList;

abstract class Employee{      //it is a abstract class
    private String name;
    private int id;
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getid(){
        return id;
    }
    public abstract double CalculateSalary();    //it is a abstract method which is used to give the salary
    public String toString(){
        return "Employee[Name="+name+", id="+id+", Salary="+CalculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    public double CalculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyrate;
    public PartTimeEmployee(String name,int id,int hoursworked,double hourlyrate){
        super(name, id);
        this.hoursworked=hoursworked;
        this.hourlyrate=hourlyrate;
    }

    public double CalculateSalary(){
        return hoursworked*hourlyrate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getid()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
public class Emp_payroll {
    public static void main(String[] args) {
        PayrollSystem prs=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Arnam", 100, 20000);
        PartTimeEmployee emp2=new PartTimeEmployee("Arnay", 200, 10, 50);
        prs.addEmployee(emp1);
        prs.addEmployee(emp2);
        System.out.println("Initial Employee Details:");
        prs.displayEmployee();
        System.out.println("Removing Employees:");
        prs.removeEmployee(200);
        System.out.println("Remaining Employee Details:");
        prs.displayEmployee();
    }
}
