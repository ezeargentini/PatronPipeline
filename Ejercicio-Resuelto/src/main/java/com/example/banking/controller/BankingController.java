package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.BankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return bankingService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return bankingService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return bankingService.getAccountById(id);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam double amount) {
        return bankingService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam double amount) {
        return bankingService.withdraw(id, amount);
    }
}
