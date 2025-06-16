package com.dev.backendtest.controller;

import com.dev.backendtest.model.ApiResponse;
import com.dev.backendtest.model.Transaction;
import com.dev.backendtest.model.TransactionStatus;
import com.dev.backendtest.repository.TransactionRepository;
import com.dev.backendtest.repository.TransactionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    @GetMapping("/viewData")
    public ApiResponse getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionStatus> statuses = transactionStatusRepository.findAll();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(transactions);
        apiResponse.setStatus(statuses);

        return apiResponse;
    }
}