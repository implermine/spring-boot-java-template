package io.dodn.springboot.application.core.port;

import lombok.Data;

/**
 * 자주 보내는 계좌와 내 계좌의 잔액 비교
 */
public interface CompareAccountUseCase {

    @Data
    class Command{
        private final Long fromAccountId;
    }

    @Data
    class Result{
        private final Long accountId;
        private final Long amount;
        private final String ownerName;
        private final String amountOfFrequentSendingAccount;
    }
}
