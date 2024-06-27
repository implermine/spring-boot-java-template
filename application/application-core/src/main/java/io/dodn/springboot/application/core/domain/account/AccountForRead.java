package io.dodn.springboot.application.core.domain.account;

import io.dodn.springboot.application.core.support.annotation.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Purpose("Read")
@Data
@AllArgsConstructor
public class AccountForRead {

    private final Long accountId;
    private Long amount;
    private String ownerName;
    private Account frequentSendingAccount;

}
