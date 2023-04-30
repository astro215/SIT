/*
Assignment description: Write a Java Program for Thread Creating and use of its various methods.


Name - Nisarg Patel
PRN - 21070126060
Batch - AIML A3

LAB ASSIGNMENT - 10
*/


public class ThreadExample implements Runnable{
    public void run() {
        // Code to be executed in the thread
        System.out.println("Thread is running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread completed");
    }
    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new Thread());
        // Set the thread's priority to the highest value
        thread.setPriority(Thread.MAX_PRIORITY);
        // Start the thread
        thread.start();
        // Wait for the thread to complete its execution
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        // Using the methods of the thread -
        System.out.println("Thread name: " + thread.getName());
        System.out.println("Thread priority: " + thread.getPriority());
        System.out.println("Thread state: " + thread.getState());
        System.out.println("Thread is alive: " + thread.isAlive());
    }
}
