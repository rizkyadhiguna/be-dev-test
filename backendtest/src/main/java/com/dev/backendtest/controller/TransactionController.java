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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    private LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    @GetMapping("/viewData")
    public ApiResponse getAllTransactions() {
        if (transactionRepository.count() == 0) {
            loadInitialData();
        }

        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionStatus> statuses = transactionStatusRepository.findAll();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(transactions);
        apiResponse.setStatus(statuses);

        return apiResponse;
    }

    private void loadInitialData() {
        List<Transaction> initialTransactions = new ArrayList<>();
        initialTransactions.add(createTransaction(1372L, "10001", "Test 1", "1000", "abc", 0, "2022-07-10 11:14:52", "abc", "2022-07-10 11:14:52"));
        initialTransactions.add(createTransaction(1373L, "10002", "Test 2", "2000", "abc", 0, "2022-07-11 13:14:52", "abc", "2022-07-10 13:14:52"));
        initialTransactions.add(createTransaction(1374L, "10001", "Test 1", "1000", "abc", 0, "2022-08-10 12:14:52", "abc", "2022-07-10 12:14:52"));
        initialTransactions.add(createTransaction(1375L, "10002", "Test 2", "1000", "abc", 1, "2022-08-10 13:10:52", "abc", "2022-07-10 13:10:52"));
        initialTransactions.add(createTransaction(1376L, "10001", "Test 1", "1000", "abc", 0, "2022-08-10 13:11:52", "abc", "2022-07-10 13:11:52"));
        initialTransactions.add(createTransaction(1377L, "10002", "Test 2", "2000", "abc", 0, "2022-08-12 13:14:52", "abc", "2022-07-10 13:14:52"));
        initialTransactions.add(createTransaction(1378L, "10001", "Test 1", "1000", "abc", 0, "2022-08-12 14:11:52", "abc", "2022-07-10 14:11:52"));
        initialTransactions.add(createTransaction(1379L, "10002", "Test 2", "1000", "abc", 1, "2022-09-13 11:14:52", "abc", "2022-07-10 11:14:52"));
        initialTransactions.add(createTransaction(1380L, "10001", "Test 1", "1000", "abc", 0, "2022-09-13 13:14:52", "abc", "2022-07-10 13:14:52"));
        initialTransactions.add(createTransaction(1381L, "10002", "Test 2", "2000", "abc", 0, "2022-09-14 09:11:52", "abc", "2022-07-10 09:11:52"));
        initialTransactions.add(createTransaction(1382L, "10001", "Test 1", "1000", "abc", 0, "2022-09-14 10:14:52", "abc", "2022-07-10 10:14:52"));
        initialTransactions.add(createTransaction(1383L, "10002", "Test 2", "1000", "abc", 1, "2022-08-15 13:14:52", "abc", "2022-07-10 13:14:52"));

        transactionRepository.saveAll(initialTransactions);

        List<TransactionStatus> initialStatuses = new ArrayList<>();
        initialStatuses.add(createStatus(0, "SUCCESS"));
        initialStatuses.add(createStatus(1, "FAILED"));
        transactionStatusRepository.saveAll(initialStatuses);
    }

    private Transaction createTransaction(Long id, String productID, String productName, String amount, String customerName, Integer status, String transactionDate, String createBy, String createOn) {
        Transaction t = new Transaction();
        t.setId(id);
        t.setProductID(productID);
        t.setProductName(productName);
        t.setAmount(amount);
        t.setCustomerName(customerName);
        t.setStatus(status);
        t.setTransactionDate(parseDateTime(transactionDate));
        t.setCreateBy(createBy);
        t.setCreateOn(parseDateTime(createOn));
        return t;
    }

    private TransactionStatus createStatus(Integer id, String name) {
        TransactionStatus ts = new TransactionStatus();
        ts.setId(id);
        ts.setName(name);
        return ts;
    }
}