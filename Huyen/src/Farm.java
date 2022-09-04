
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Farm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create dog
        Dog dog = new Dog(2, 2);
        // create pig
        Pig pig = new Pig(2, 1);
        // create duck
        Duck duck = new Duck(1, 0, 2, 2);
        // create duck
        Chicken chicken = new Chicken(1, 4, 0, 1);

        //create ground
        Ground ground = new Ground(3, 4, 0);
        ground.updateSapceForDuck(duck);
        ground.updateSapceForPig(pig);

        //check that have any space or not
        if(!ground.check(chicken)){
            System.err.println("Cant add!");
        //if yes update space in that areas
        }else{
            ground.updateSapceForChicken(chicken);
            System.err.println("Add success!");
        }
        System.out.println(ground);
        Pig pig1 = new Pig(2, 3);
        if(!ground.check(pig1)){
            System.err.println("Cant add!");
        }else{
            ground.updateSapceForPig(pig1);
            System.out.println("Add success!");
        }
        System.out.println(ground);
    }
}
