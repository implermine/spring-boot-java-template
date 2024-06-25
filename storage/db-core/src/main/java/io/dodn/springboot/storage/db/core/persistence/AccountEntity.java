package io.dodn.springboot.storage.db.core.persistence;

import io.dodn.springboot.application.core.domain.account.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId = 0L;
    private Long amount;
    private LocalDateTime localDateTime = LocalDateTime.now();

    //toDomain method
    public Account toDomain(){
        return new Account(
                this.accountId,
                this.amount
        );
    }
}
