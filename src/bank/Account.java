package bank;

import java.math.BigDecimal;

public class Account {

    static long accountCounter = 0;

    private long id;
    private BigDecimal saldo = BigDecimal.ZERO;//new BigDecimal(0.0);

    public Account(){
        id = accountCounter++;
    }

    public void deposit(BigDecimal amount){
        saldo = saldo.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if( amount.compareTo(saldo) <= 0 )
            saldo = saldo.subtract(amount);
    }

    public BigDecimal getSaldo(){
        return saldo;
    }
}
