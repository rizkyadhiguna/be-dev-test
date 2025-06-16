package com.dev.backendtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaction_statuses")
@Data
public class TransactionStatus {
    @Id
    private Integer id;
    private String name;
}
