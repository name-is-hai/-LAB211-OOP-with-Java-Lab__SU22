/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Pond extends Area {

    public Duck duck;

    public Pond(Duck duck, double aSpace, double gSpace, double wSpace) {
        super(aSpace, gSpace, wSpace);
        this.duck = duck;
    }

    public Duck getDuck() {
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
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
