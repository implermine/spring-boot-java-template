package io.dodn.springboot.core.api.controller.v1.response;

import io.dodn.springboot.application.core.port.SendMoneyUseCase;

public record SendMoneyResponse(
        Boolean isSuccess
) {

    public static SendMoneyResponse of(SendMoneyUseCase.Result result){
        return new SendMoneyResponse(result.getIsSuccess());
    }
}
