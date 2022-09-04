
// Input and display Person Info.
public class Main {

    public static void main(String[] args) throws Exception {
        Person persons = new Person();
        System.out.println("====Manager Person programer====");
        //Step1: Input person information of person.
        //loop for input array of persons.
            persons.inputPersonInfo();
        //Step2: Sort Person list ascending
        
        //Step3: Show 3 person information by ascending of salary.
        //loop for display array of persons.
            persons.displayPersonInfo(persons);

    }
}
