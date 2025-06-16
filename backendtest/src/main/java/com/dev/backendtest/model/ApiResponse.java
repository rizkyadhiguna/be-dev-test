package com.dev.backendtest.model;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse {
    private List<Transaction> data;
    private List<TransactionStatus> status;
}
