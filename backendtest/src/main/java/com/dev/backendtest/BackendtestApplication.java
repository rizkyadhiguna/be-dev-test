package com.dev.backendtest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dev.backendtest.model.Transaction;
import com.dev.backendtest.model.TransactionStatus;
import com.dev.backendtest.repository.TransactionRepository;
import com.dev.backendtest.repository.TransactionStatusRepository;

@SpringBootApplication
public class BackendtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendtestApplication.class, args);
	}

	@Bean
    public CommandLineRunner loadData(TransactionRepository transactionRepository,
                                      TransactionStatusRepository transactionStatusRepository) {
        return args -> {
            if (transactionRepository.count() == 0) {
                System.out.println("Loading initial transaction data...");
                List<Transaction> initialTransactions = new ArrayList<>();
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-07-10 11:14:52", "abc", "2022-07-10 11:14:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "2000", "abc", 0, "2022-07-11 13:14:52", "abc", "2022-07-10 13:14:52"));
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-08-10 12:14:52", "abc", "2022-07-10 12:14:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "1000", "abc", 1, "2022-08-10 13:10:52", "abc", "2022-07-10 13:10:52"));
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-08-10 13:11:52", "abc", "2022-07-10 13:11:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "2000", "abc", 0, "2022-08-12 13:14:52", "abc", "2022-07-10 13:14:52"));
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-08-12 14:11:52", "abc", "2022-07-10 14:11:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "1000", "abc", 1, "2022-09-13 11:14:52", "abc", "2022-07-10 11:14:52"));
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-09-13 13:14:52", "abc", "2022-07-10 13:14:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "2000", "abc", 0, "2022-09-14 09:11:52", "abc", "2022-07-10 09:11:52"));
                initialTransactions.add(createTransaction("10001", "Test 1", "1000", "abc", 0, "2022-09-14 10:14:52", "abc", "2022-07-10 10:14:52"));
                initialTransactions.add(createTransaction("10002", "Test 2", "1000", "abc", 1, "2022-08-15 13:14:52", "abc", "2022-07-10 13:14:52"));

                transactionRepository.saveAll(initialTransactions);
                System.out.println("Initial transaction data loaded.");
            }

            if (transactionStatusRepository.count() == 0) {
                System.out.println("Loading initial status data...");
                List<TransactionStatus> initialStatuses = new ArrayList<>();
                initialStatuses.add(createStatus(0, "SUCCESS"));
                initialStatuses.add(createStatus(1, "FAILED"));
                transactionStatusRepository.saveAll(initialStatuses);
                System.out.println("Initial status data loaded.");
            }
        };
    }

    private Transaction createTransaction(String productID, String productName, String amount, String customerName, Integer status, String transactionDate, String createBy, String createOn) {
        Transaction t = new Transaction();
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

    private LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}