
import java.util.Scanner;
import jdk.nashorn.internal.runtime.JSType;


public class Person {

    private String name;
    private String address;
    private double salary;

    //contructor of person
    public Person() {
    }

    //contructor of person
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    //get name when not in this class
    public String getName() {
        return name;
    }

    //Fix name when not in this class
    public void setName(String name) {
        this.name = name;
    }

    //get address when not in this class
    public String getAddress() {
        return address;
    }

    //Fix address when not in this class
    public void setAddress(String address) {
        this.address = address;
    }

    //get salary when not in this class
    public double getSalary() {
        return salary;
    }

    //Fix salary when not in this class
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Input person information
    public Person inputPersonInfo()throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Information of Person");
        System.out.print("Please input name:");
        name = input.nextLine();
        input = new Scanner(System.in);
        System.out.print("Please input address:");
        address = input.nextLine();
        input = new Scanner(System.in);
        System.out.print("Please input salary:");
        salary = checkSalary();
        return new Person(name, address, salary);
    }

    //Check salary is positive number or not 
    public double checkSalary() {
        Scanner sc = new Scanner(System.in);
        //try to get correct format of salary
        while (true) {
            try {
                String sSalary = sc.nextLine();
                if (sSalary.isEmpty()){
                    System.out.println("Please dont let input blank.");
                }else{
                    double tmp = Double.parseDouble(sSalary);
                    //check if SALARY is positive number.
                    if (tmp < 0) {
                        System.err.println("Salary is greater than zero.");
                        System.out.println("Please input salary:");
                    } else {
                        return tmp;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("You must input digit.");
                System.out.println("Please input salary:");
            }
        }
    }

    public static Person[] sortBySalary(Person[] person)throws Exception {
        //loop to access each array element
        for (int i = 0; i < person.length; i++) {
            //loop to compare array elements
            for (int j = 0; j < person.length; j++) {
                Person tmp;
                //compare salary
                if (person[i].salary < person[j].salary) {
                    //switch person
                    tmp = person[i];
                    person[i] = person[j];
                    person[j] = tmp;
                }
            }
        }
        return person;
    }

    //Display person properties
    public void displayPersonInfo(Person person) {
        System.out.println("");
        System.out.println("Information of Person you have entered:");
        System.out.println("Name:" + person.name);
        System.out.println("Address:" + person.address);
        System.out.println("Salary:" + person.salary);
    }
}
