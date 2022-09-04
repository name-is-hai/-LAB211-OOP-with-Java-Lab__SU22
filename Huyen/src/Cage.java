/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Cage extends Area {

    private Dog dog;

    public Cage(Dog dog, double aSpace, double gSpace, double wSpace) {
        super(aSpace, gSpace, wSpace);
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public double getaSpace() {
        return aSpace;
    }

    public void setaSpace(double aSpace) {
        this.aSpace = aSpace;
    }

    public double getgSpace() {
        return gSpace;
    }

    public void setgSpace(double gSpace) {
        this.gSpace = gSpace;
    }

    public double getwSpace() {
        return wSpace;
    }

    public void setwSpace(double wSpace) {
        this.wSpace = wSpace;
    }

}
