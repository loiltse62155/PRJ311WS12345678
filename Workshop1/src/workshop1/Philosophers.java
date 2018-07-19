/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

/**
 *
 * @author Ly Tan loi
 */
public class Philosophers extends Thread{
    private Chopstick leftStick, rightStick;
    private int position;

    public Philosophers(Chopstick leftStick, Chopstick rightStick, int position) {
        this.leftStick = leftStick;
        this.rightStick = rightStick;
        this.position = position;
    }
    
    public void eat(){
        leftStick.getUp();
        rightStick.getUp();
        System.out.println("The " + position + "(th) philosopher is eating!");
        
    }
    
    public void think(){
        leftStick.getDown();
        rightStick.getDown();
        System.out.println("The " + position + "(th) philosopher is thinking!");
        
    }
    
    @Override
    public void run(){
        while(true){
            eat();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }
            think();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }
        }
    }
}
