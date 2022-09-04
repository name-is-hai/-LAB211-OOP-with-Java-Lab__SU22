/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SalaryHistory;
import Model.Worker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 *
 * @author anhnb
 */
public class Management {

    ArrayList<Worker> list;
    Scanner in;
    Helpers helpers;

    public Management() {
        list = new ArrayList<>();
        in = new Scanner(System.in);
        helpers = new Helpers();
    }

    public void menu() {
        System.out.println("======== Worker Management =========\n"
                + "1.	Add Worker\n"
                + "2.	Up salary\n"
                + "3.	Down salary\n"
                + "4.	Display Information salary\n"
                + "5.	Exit");

        int option = 0;
        while (true) {
            System.out.println("Enter option: ");
            option = helpers.checkInt();

            switch (option) {
                case 1:
                    if(addWorker(enterWorker())){
                        System.out.println("success");
                    }else{
                        System.out.println("fails");
                    }
                    break;
                case 2: upSalary();break;
                case 3: display();break;
                case 4: displaySalary();break;
            }

        }

    }

    public Worker enterWorker()  {
        Worker worker = null;

        System.out.println("Enter Code: ");
        String code = in.nextLine();
        if(checkCodeExits(code)){
            return null;
        }
        
        System.out.println("Enter Name: ");
        String name = in.nextLine();

        System.out.println("Enter Age: ");
        int age = helpers.checkInt();
        if(!checkAge(age)){
            return null;
        }
        System.out.println("Enter Salary: ");
        double salary = helpers.checkDoub();
        System.out.println("Enter work location: ");
        String loca = in.nextLine();
        worker = new Worker(code, name, age, salary, loca);

        return worker;
    }

    public boolean checkCodeExits(String code) {
        for (Worker worker : list) {
            if (code.contentEquals(worker.getCode())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAge(int age) {
        if (age < 18) {
            return false;
        }
        return true;
    }
    
    public boolean addWorker(Worker worker) {
       return (null == worker) ?  false :  list.add(worker);
    }
    
    public boolean upSalary(){
        System.out.println("Enter code: ");
        String code = in.nextLine();
        Worker worke = null;
         for (Worker worker : list) {
            if (code.contentEquals(worker.getCode())) {
                worke= worker;
            }
        }
        System.out.println("Enter salary: ");
        double salary = helpers.checkDoub();
        SalaryHistory salaryHistory = new SalaryHistory("UP", new Date());
        worke.setSalaryHistories(salaryHistory);
        return true;
    }
    public void display(){
        for (Worker worker : list) {
            System.out.println(worker.toString());
        }
    }
    
    public void displaySalary(){
        for (Worker worker : list) {
            for (SalaryHistory salariesHistory : worker.getSalariesHistories()) {
                System.out.println(worker.getCode()+"\t"+ salariesHistory.getStatus()
                        +"\t"+ salariesHistory.getDate());
            }
        }
    }
}
