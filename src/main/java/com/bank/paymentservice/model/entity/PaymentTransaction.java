package com.bank.paymentservice.model.entity;

import com.bank.paymentservice.model.enums.PaymentTransactionStatus;
import com.bank.paymentservice.model.enums.converter.PaymentTransactionStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity {

    private BigDecimal amount;
    private String currency;

    @Convert(converter = PaymentTransactionStatusConverter.class)
    private PaymentTransactionStatus status;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "destinationBankAccoundId")
    private BankAccount destinationBankAccount;

    @OneToMany
    private List<Refund> refunds;



}
