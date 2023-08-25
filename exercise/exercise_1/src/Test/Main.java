package Test;

import java.util.Random;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numPermits = 5; // Numero di permessi iniziali
        Semaphore semaphore = new Semaphore(numPermits);

        // Creazione e avvio di 10 thread
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Worker(semaphore, i));
            thread.start();
        }
    }
}

class Worker implements Runnable {
    private Semaphore semaphore;
    private int workerId;

    public Worker(Semaphore semaphore, int workerId) {
        this.semaphore = semaphore;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        try {
     
            semaphore.acquire(); // Acquisisce un permesso

            // Simuliamo qualche lavoro
            System.out.println("Worker " + workerId + " is working...");
            Thread.sleep(2000); // Simulazione di un lavoro di 2 secondi

            System.out.println("Worker " + workerId + " has finished working.");

            // Rilascia il permesso
            semaphore.release();
            System.out.println("Worker " + workerId + " has released a permit.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
