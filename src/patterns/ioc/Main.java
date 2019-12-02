package patterns.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        //Composition Root
//        CreditCardProcessor cardProcessor = new SwedbankCardProcessorImpl();
//        TransactionLog logger = new DatabaseTransactionLogImpl();
//
//        BillingService billingService =
//                new RealBillingService(cardProcessor,logger);

        Injector injector = Guice.createInjector(new BillingModule());

        BillingService billingService = injector.getInstance(BillingService.class);

        billingService.bill();
    }
}
