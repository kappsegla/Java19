package patterns.ioc;

import com.google.inject.Inject;

public class RealBillingService implements BillingService {

    private CreditCardProcessor cardProcessor;
    private TransactionLog logger;

    @Inject
    public RealBillingService(CreditCardProcessor cardProcessor, TransactionLog logger){
        this.cardProcessor = cardProcessor;
        this.logger = logger;
    }

    @Override
    public void bill() {
        System.out.println("Billing");
    }
}
