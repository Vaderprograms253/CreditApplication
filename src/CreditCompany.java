/**
 * Xavier Denson
 * 3/20/2022
 * This class represents the credit company and removes applications from the shared queue to process them
 */
public class CreditCompany implements Runnable{

    private ApplicationQueue mySharedQueue;

    public CreditCompany(ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * This method removes applications from the ArrayBlockingQueue and processes them
     * it checks to see if an applications credit score is 580 or greater to approve an application
     * otherwise approved will be set to false
     */
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 60000){
            //check if application credit score is 580 or greater
            String approveDecline;
            Application processApp = mySharedQueue.removeApplication();
            if (processApp !=null){
                processApp.setApproved(processApp.getCreditScore() >= 580);
                if (processApp.isApproved()){
                    processApp.setApprovedLimit(checkApprovalAmount(processApp));
                    approveDecline = " is approved for $" + processApp.getApprovedLimit() + " (requested: $" + processApp.getRequestedLimit() + ").";
                } else {
                    approveDecline = " is not approved";
                }
                System.out.println(Thread.currentThread().getName() + ": Application #" + processApp.getApplicationId() + " with credit score " + processApp.getCreditScore() + approveDecline);

            }
        }
    }

    /**
     * This method checks the applications credit score to assign credit limit
     * @param application current application being processed
     * @return credit limit for approved application
     */
    public int checkApprovalAmount(Application application){
        int creditLimit = 0;
        if (application.getCreditScore() < 669){
            creditLimit = 5000;
        } if (application.getCreditScore() >= 670 && application.getCreditScore() <= 739){
            creditLimit = 10000;
        } if (application.getCreditScore() >= 740 && application.getCreditScore() <= 799){
            creditLimit = 25000;
        } if (application.getCreditScore() > 800){
            creditLimit = 50000;
        }
        return creditLimit;
    }
}
