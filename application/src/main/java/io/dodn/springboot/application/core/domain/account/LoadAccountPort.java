package io.dodn.springboot.application.core.domain.account;

import java.util.Optional;

public interface LoadAccountPort {

    Optional<Account> loadAccount(Long accountId);
}
