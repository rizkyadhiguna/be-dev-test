package com.dev.backendtest.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productID;
    private String productName;
    private String amount;
    private String customerName;
    private Integer status;
    private LocalDateTime transactionDate;
    private String createBy;
    private LocalDateTime createOn;
}
