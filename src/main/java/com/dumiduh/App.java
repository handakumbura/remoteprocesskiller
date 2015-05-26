package com.dumiduh;


import java.util.Random;
/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
        
        int elapse = new Random().nextInt(9)+1;
        elapse=elapse*60000;
        System.out.println("Application Started \t elapse : "+elapse);
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                Controller controller = new Controller();
                controller.findAndKill();
            }
        }, 
        elapse 
);
    }
}
