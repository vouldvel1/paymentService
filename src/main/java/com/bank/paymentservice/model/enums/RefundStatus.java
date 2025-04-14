package com.bank.paymentservice.model.enums;

import jakarta.servlet.http.PushBuilder;
import lombok.Getter;

@Getter
public enum RefundStatus {
    COMPLETED,
    FAILED;

    public static RefundStatus fromString(String status) {
        for (RefundStatus statu : RefundStatus.values()) {
            if (statu.name().equalsIgnoreCase(status)) {
                return statu;
            }
        }
        throw new IllegalArgumentException("Unknown refund status: " + status);
    }
}
