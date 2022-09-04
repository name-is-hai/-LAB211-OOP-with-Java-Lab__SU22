
package Model;

import Controller.Helpers;
import java.util.ArrayList;



/**
 *
 * @author anhnb
 */
public class Worker {
    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private ArrayList<SalaryHistory> salaryHistories;
    public Worker() {
      salaryHistories = new ArrayList<>();
    }
    
    public Worker(String code, String name, int age, double salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
         salaryHistories = new ArrayList<>();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    public void setSalaryHistories(SalaryHistory salaryHistory){
        salaryHistories.add(salaryHistory);
    }
    
    public ArrayList<SalaryHistory> getSalariesHistories(){
        return this.salaryHistories;
    }
    @Override
    public String toString() {
        return "Worker{" + "code=" + code + ", name=" + name + ", age=" + age + ", salary=" + salary + ", workLocation=" + workLocation + '}';
    }
    
    
    
    
}
