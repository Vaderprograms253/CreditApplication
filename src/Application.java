import java.util.concurrent.atomic.AtomicInteger;

/**
 * Xavier Denson
 * 3/21/2022
 * This class represents a credit application
 */
public class Application {

    private static AtomicInteger nextId = new AtomicInteger(1000);
    private int applicationId;
    private int creditScore;
    private int requestedLimit;
    private int approvedLimit;
    private boolean approved;


    public Application(int creditScore, int requestedLimit){
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
        applicationId = nextId.intValue();

    }

    public static int getNextId() {
        return nextId.getAndIncrement();

    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getRequestedLimit() {
        return requestedLimit;
    }

    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    public int getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
