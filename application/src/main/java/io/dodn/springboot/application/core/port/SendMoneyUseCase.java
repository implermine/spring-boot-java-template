package io.dodn.springboot.application.core.port;

import lombok.Data;

/**
 * this class name could implicitly mean SendMoneyInputPort
 */
public interface SendMoneyUseCase {

    Result sendMoney(Command command);

    @Data
    class Command{
        private final Long fromAccountId;
        private final Long toAccountId;
        private final Long amount;
    }

    @Data
    class Result{
        private final Boolean isSuccess;

    }
}
