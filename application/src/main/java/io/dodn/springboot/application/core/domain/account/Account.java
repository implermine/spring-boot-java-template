package io.dodn.springboot.application.core.domain.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account{

    private final Long accountId;
    private Long amount;

    public Long withdrawal(Long amount){
        if(this.amount - amount <0){
            throw new IllegalStateException("withdrawal failed.");
        }
        this.amount = this.amount - amount;
        return this.amount;
    }

    public void deposit(Long amount){
        this.amount = this.amount + amount;
    }
}
