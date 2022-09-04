
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Manager {

    public void addTask(int id, ArrayList<Task> tasks) {
        System.out.println("--------- add task ---------");
        System.out.println("Requirement Name: ");
        String requirement = inputRequimentName();
        System.out.println("Task Type: ");
        String taskType = InputTaskTypeId();
        System.out.println("Date: ");
        String date = inputDate();
        System.out.println("From: ");
        String from = InputPlanFrom();
        System.out.println("To: ");
        String to = InputPlanTo(from);
        System.out.println("Assignee: ");
        String assigne = inputAssignee();
        System.out.println("Reviewer: ");
        String reviewer = inputReviewer();
        if (!checkIntesaction(tasks, assigne, date, to, from)) {
            System.out.println("Task is Intersaction");
            return;
        } else {
            Task task = new Task(id, taskType, requirement, date, from, to, assigne, reviewer);
            tasks.add(task);
            System.out.println("Add success");
        }
    }

    public String InputTaskTypeId() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                int tmp = Integer.parseInt(input);
                if (tmp < 1 || tmp > 4) {
                    System.out.println("Need input in the range.");
                    System.out.println("Please re-enter:");
                } else {
                    String result = "";
                    switch (tmp) {
                        case 1:
                            result = "code";
                            break;
                        case 2:
                            result = "test";
                            break;
                        case 3:
                            result = "manager";
                            break;
                        case 4:
                            result = "learn";
                    }
                    return result;
                }
            }
        }
    }

    public String inputID() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String ID = sc.nextLine();
            if (ID.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return ID;
            }
        }
    }

    public String inputRequimentName() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String requiment = sc.nextLine();
            if (requiment.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return requiment;
            }
        }
    }

    public String inputAssignee() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String ass = sc.nextLine();
            if (ass.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return ass;
            }
        }
    }

    public String inputReviewer() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String reviewer = sc.nextLine();
            if (reviewer.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return reviewer;
            }
        }
    }

    public String inputDate() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setLenient(false);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Input can not be empty");
                System.err.println("Re-input:");
                continue;
            } else if (!result.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                System.out.println("Input wrong format dd/MM/yyyy");
                System.err.println("Re-input:");
                continue;
            }
            try {
                Date date = format.parse(result);
                Date now = new Date();
                if (date.before(now)) {
                    System.out.println("Date can not be in the past");
                    System.err.println("Re-input:");
                    continue;
                }
                return result;
            } catch (Exception ex) {
                System.out.println("Date is not exist");
            }
        }
    }

    public String InputPlanTo(String planFrom) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!input.matches("\\d+\\.([5]|[0])|\\d+")) {
                    System.out.println("Wrong format");
                    System.err.println("Re-input:");
                } else {
                    double num1 = Double.parseDouble(planFrom);
                    double num = Double.parseDouble(input);
                    if (num > 17.5) {
                        System.out.println("Plan To must be less than 17h30");
                        System.out.println("Please re-enter:");
                    } else {
                        if (num < num1) {
                            System.out.println("Plan to need to smaller than plan from");
                            System.out.println("Please re-enter:");
                        } else {
                            return input;
                        }
                    }
                }
            }
        }
    }

    public String InputPlanFrom() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!input.matches("\\d+\\.([5]|[0])|\\d+")) {
                    System.out.println("Wrong format");
                    System.err.println("Re-input:");
                } else {
                    double num = Double.parseDouble(input);
                    if (num < 8.0) {
                        System.out.println("Plan From must be geater than 8h");
                    } else {
                        return input;
                    }
                }
            }
        }
    }

    public void print(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : tasks) {
            double num1 = Double.parseDouble(task.getPlanFrom());
            double num = Double.parseDouble(task.getPlanTo());
            String plan = String.valueOf(num - num1);
            System.out.printf("%-5d%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    task.getId(), task.getRequimentName(), task.getTaskTypeID(), task.getDate(), plan, task.getAssignee(), task.getReviewer());
        }
    }

    public boolean checkIntesaction(ArrayList<Task> tasks, String assignee, String date, String planTo, String planFrom) {
        for (Task task : tasks) {
            if (assignee.equalsIgnoreCase(task.getAssignee()) && date.equalsIgnoreCase(task.getDate())) {
                double plan1 = Double.parseDouble(planTo);
                double plan2 = Double.parseDouble(planFrom);
                double plan3 = Double.parseDouble(task.getPlanFrom());
                double plan4 = Double.parseDouble(task.getPlanTo());
                if (plan2 < plan3){
                    if(plan1 < plan4 && plan1 > plan3)
                    return false;
                }
                if(plan2 > plan3){
                    if(plan2 < plan4){
                        return false;
                    }
                }
                if(plan2 > plan4){
                    return true;
                }
                if (plan2 < plan3){
                    if(plan1 < plan3)
                    return true;
                }
            }
        }
        return true;
    }

    public void deleteTask(ArrayList<Task> tasks) {
        Scanner sc = new Scanner(System.in);
        if (tasks.isEmpty()) {
            System.out.println("Task empty");
            return;
        }
        System.out.println("ID:");
        String id = inputID();
        boolean isExist = false;
        int indexOfTask = -1;
        for (Task task : tasks) {
            if (id.equalsIgnoreCase(String.valueOf(task.getId()))) {
                indexOfTask = tasks.indexOf(task);
                isExist = true;
            }
        }
        if (isExist) {
            tasks.remove(indexOfTask);
            System.out.println("Delete success");
        } else {
            System.out.println("Not find that ID.");
            System.out.println("Delete fail");
        }

    }
}
