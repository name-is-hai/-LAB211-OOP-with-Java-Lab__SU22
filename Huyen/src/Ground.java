/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Ground extends Area {

    public Pig pig;
    public Chicken chicken;
    public Duck duck;

    public Ground(Pig pig, Chicken chicken, Duck duck, double aSpace, double gSpace, double wSpace) {
        super(aSpace, gSpace, wSpace);
        this.pig = pig;
        this.chicken = chicken;
        this.duck = duck;
    }

    public Ground(double aSpace, double gSpace, double wSpace) {
        super(aSpace, gSpace, wSpace);
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
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

    public boolean check(Chicken newMem) {
        if (newMem.getaSpace() > getaSpace() || newMem.getgSapce() > getgSpace() ) {
            return false;
        }
        return true;
    }

    public boolean check(Pig newMem) {
        if (newMem.getgSpace() > getgSpace()) {
            return false;
        }
        return true;
    }

    public boolean check(Duck newMem) {
        if (newMem.getaSpace() > getaSpace() || newMem.getwSapce() > getwSpace()) {
            return false;
        }
        return true;
    }
    
    public void updateSapceForPig(Pig newMem){
        setgSpace(gSpace - newMem.getgSpace());
    }
    
    public void updateSapceForChicken(Chicken newMem){
        setaSpace(aSpace - newMem.getaSpace());
        setgSpace(gSpace - newMem.getgSapce());
    }
    
    public void updateSapceForDuck(Duck newMem){
        setaSpace(aSpace - newMem.getaSpace());
        setwSpace(wSpace - newMem.getwSapce());   
    }

    @Override
    public String toString() {
        return "Ground{" + aSpace+ "," + gSpace+ "," + wSpace +'}';
    }
    
    
}
