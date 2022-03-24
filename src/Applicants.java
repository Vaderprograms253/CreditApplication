import java.util.concurrent.ThreadLocalRandom;

/**
 * Xavier Denson
 * 3/20/2022
 * This class represents applicants for credit applications are created with random params to store into the shared queue
 */
public class Applicants implements Runnable{

    private ApplicationQueue mySharedQueue;

    public Applicants(ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * this method will create applications for a period of one minute
     */
    @Override
    public void run() {
        //parameters for credit applications
        int creditScore;
        int requestedLimit;

        Application app;
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 60000){
            //set param
            creditScore = ThreadLocalRandom.current().nextInt(300,850 + 1);
            requestedLimit = ThreadLocalRandom.current().nextInt(5000,50000);
            //creat and add application to queue
            app = new Application(creditScore, requestedLimit);
            mySharedQueue.addApplication(app);
            //print application created
            System.out.println(Thread.currentThread().getName() + ": created application #" + Application.getNextId());
            //flip a coin
            int coin = ThreadLocalRandom.current().nextInt(1,2 + 1);
            if (coin == 1){
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100,1200 +1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("finished!");

    }
}
