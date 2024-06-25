package io.dodn.springboot.storage.db.core.port;

import io.dodn.springboot.application.core.domain.account.Account;
import io.dodn.springboot.application.core.domain.account.LoadAccountPort;
import io.dodn.springboot.application.core.domain.account.UpdateAccountPort;
import io.dodn.springboot.storage.db.core.persistence.AccountEntity;
import io.dodn.springboot.storage.db.core.persistence.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final AccountRepository accountRepository;


    @Override
    public Optional<Account> loadAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .map(AccountEntity::toDomain);
    }

    @Override
    public void updateAccount(Account account) {
        AccountEntity accountEntity = accountRepository.findById(account.getAccountId())
                .orElseThrow(() -> new IllegalStateException("account not found"));

        accountEntity.setAmount(account.getAmount());

    }
}
