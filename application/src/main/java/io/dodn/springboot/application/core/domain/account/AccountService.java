package io.dodn.springboot.application.core.domain.account;

import io.dodn.springboot.application.core.port.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountServiceUseCase
 */
@Service
@RequiredArgsConstructor
public class AccountService implements SendMoneyUseCase { // Port를 늘릴것.

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;


    @Override
    @Transactional // needed
    public Result sendMoney(Command command) {
        Account fromAccount = loadAccountPort.loadAccount(command.getFromAccountId())
                .orElseThrow(() -> new IllegalStateException("not exist account"));
        Account toAccount =loadAccountPort.loadAccount(command.getToAccountId())
                .orElseThrow(() -> new IllegalStateException("not exist account"));

        toAccount.deposit(fromAccount.withdrawal(command.getAmount()));

        //commit
        updateAccountPort.updateAccount(fromAccount);
        updateAccountPort.updateAccount(toAccount);

        return new Result(true);
    }
}