package patterns.ioc;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLogImpl.class).asEagerSingleton();
        bind(CreditCardProcessor.class).to(SwedbankCardProcessorImpl.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
