package edu.multhreading.problems;

// Worker1 needs a tool. There is no tool. Worker waits infinitely.
// Request resources from another server. There is no server, waiting infinitely. (timeout)
// Starvation- requiring for resources, when there is none.

// Worker1 has resource1, Worker2 has resource2.
// Worker1 wants resource2, worker2 wants resource1.
// Worker1 can give resource1 only when it gets resource2.
// Worker2 can give resource2 only when it gets resource1.
// Deadlock- Both conditions contradict- therefore resource will never be available.

// 2 different trucks deliver the goods.
// There are two shopkeepers in the shop. Shopkeeper1 spots truck1, Shopkeeper2 spots truck2.
// Shopkeeper1 loads current list of goods at 12:30. He then submits truck1 goods to the system at 12:32.
// Shopkeeper2 loads current list of goods at 12:31. He then submits truck2 goods to the system at 12:33.
// What's the outcome?
// Shopkeeper1 changes are gone.
// Race condition- two requests change the same source.
// When resource changes matter depending on who gets to it first- we call it not thread-safe
// When resource changes do not matter depending on who gets to it first- we call it thread-safe

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceCondition {
    public static int Total = 0;

    public static void add100x100(){
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            es.submit(new Adder());
        }

        es.shutdown();
        try {
            es.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Total);
    }

    private static class Adder implements Runnable{
        // Any object which is shared by all adders.
        private static Object object = new Object();

        // Runnable and callable implementations MUST HANDLE exceptions within themselves.
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // only one thread can run this block at a time.
            // JUST FOR THIS CODE BLOCK.
            synchronized (object) {

                Total += 100;
                // object.unlock
            }

            // if(object.isInUseByAnotherThread()){
               // object.lock(); // in use
               //Total += 100;
               //object.unlock(); // no longer in use
            // }

            // For example
        }

        // only one thread can run this block at a time FOR THE WHOLE METHOD
        // This exact example below makes no sense.
        // Because runnable is supposed to be multithreaded.
        // This prevents multithreading.
//        @Override
//        public synchronized void run() {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Total += 100;
//        }
    }

}
