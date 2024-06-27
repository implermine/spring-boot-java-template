package io.dodn.springboot.application.core.domain.account;

import io.dodn.springboot.application.core.port.CompareAccountUseCase;
import io.dodn.springboot.application.core.port.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountServiceUseCase
 */
@Service
@RequiredArgsConstructor
public class AccountService implements
        SendMoneyUseCase,
        CompareAccountUseCase { // Port를 늘릴것.

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;


    @Override
    @Transactional // needed
    public SendMoneyUseCase.Result sendMoney(SendMoneyUseCase.Command command) {
        Account fromAccount = loadAccountPort.loadAccount(command.getFromAccountId())
                .orElseThrow(() -> new IllegalStateException("not exist account"));
        Account toAccount =loadAccountPort.loadAccount(command.getToAccountId())
                .orElseThrow(() -> new IllegalStateException("not exist account"));

        toAccount.deposit(fromAccount.withdrawal(command.getAmount()));

        //commit
        updateAccountPort.updateAccount(fromAccount);
        updateAccountPort.updateAccount(toAccount);

        return new SendMoneyUseCase.Result(true);
    }

    public CompareAccountUseCase.Result getCompareAccount(CompareAccountUseCase.Command command){
        //do something
        return null;
    }
}