import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Xavier Denson
 * 3/21/2022
 * This class represents a shared queue used by Applicants and CreditCompany threads
 */
public class ApplicationQueue {

    private static BlockingQueue<Application> apps = new LinkedBlockingQueue<>();

    /**
     * This method adds an Application object to apps queue
     * using BlockingQue put() and Application will be added to the end of the queue
     *
     * @param app added application
     */
    public void addApplication(Application app) {
        try {
            apps.put(app);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method removes an Application object from apps queue using BlockingQueue take()
     * an application will be removed from the front of the queue
     *
     * @return removed application
     */
    public Application removeApplication() {
        Application removedApp = null;
        try {
            if (apps.size() > 1) {
                removedApp = apps.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return removedApp;
    }
}
