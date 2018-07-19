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
public class Workshop1 {
    static int n;
    static Chopstick[] sticks = new Chopstick[5];
    static Philosophers[] philosophers = new Philosophers[5];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        n = 5;
        for(int i = 0; i< n; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosophers(sticks[i], sticks[(i+1)%5], i);
        }
        for (int i = 0; i < n; i++) {
            philosophers[i].start();
        }
    }
    
}
