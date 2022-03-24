import java.util.concurrent.ThreadLocalRandom;

/**
 * Xavier Denson
 * 3/22/2022
 * This class is used to test the shared queue
 */
public class TestCreditApplication {
    public static void main(String[] args) throws InterruptedException {
        ApplicationQueue mySharedQueue = new ApplicationQueue();

        //PART 1
        /*
        //pass in shared queue and start
        Thread producers = new Thread(new Applicants(mySharedQueue));
        producers.setName("P1");
        Thread consumers = new Thread(new CreditCompany(mySharedQueue));
        consumers.setName("C1");
        producers.start();
        consumers.start();
         */

        //PART 2
        //create threads
        Thread producerOne = new Thread(new Applicants(mySharedQueue));
        Thread producerTwo = new Thread(new Applicants(mySharedQueue));
        Thread producerThree = new Thread(new Applicants(mySharedQueue));
        Thread consumerOne = new Thread(new CreditCompany(mySharedQueue));
        Thread consumerTwo = new Thread(new CreditCompany(mySharedQueue));
        //name threads
        producerOne.setName("P1");
        producerTwo.setName("P2");
        producerThree.setName("P3");
        consumerOne.setName("C1");
        consumerTwo.setName("C2");
        //start threads
        producerOne.start();
        producerTwo.start();
        producerThree.start();
        consumerOne.start();
        consumerTwo.start();
    }


}
