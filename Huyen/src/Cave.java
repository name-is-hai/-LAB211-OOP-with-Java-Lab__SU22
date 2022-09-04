/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Cave extends Area {

    public Pig pig;
    public Duck duck;

    public Cave(Pig pig, Duck duck, double aSpace, double gSpace, double wSpace) {
        super(aSpace, gSpace, wSpace);
        this.pig = pig;
        this.duck = duck;
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
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
