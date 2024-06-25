package io.dodn.springboot.core.api.controller.v1;

import io.dodn.springboot.application.core.port.SendMoneyUseCase;
import io.dodn.springboot.core.api.controller.v1.request.SendMoneyRequest;
import io.dodn.springboot.core.api.controller.v1.response.SendMoneyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/api/v1/account/send-money")
    public SendMoneyResponse sendMoney(SendMoneyRequest request){

        SendMoneyUseCase.Result result = sendMoneyUseCase.sendMoney(request.toCommand());

        return SendMoneyResponse.of(result);

    }
}
