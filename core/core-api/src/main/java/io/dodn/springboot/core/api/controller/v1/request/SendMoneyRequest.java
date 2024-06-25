package io.dodn.springboot.core.api.controller.v1.request;

import io.dodn.springboot.application.core.port.SendMoneyUseCase;

public record SendMoneyRequest(
        Long fromAccountId,
        Long toAccountId,
        Long amount
) {

    public SendMoneyUseCase.Command toCommand(){
        return new SendMoneyUseCase.Command(fromAccountId, toAccountId, amount);
    }
}
