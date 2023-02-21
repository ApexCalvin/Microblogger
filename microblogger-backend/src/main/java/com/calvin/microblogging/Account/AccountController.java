package com.calvin.microblogging.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("http://localhost:8080") //localhost:3000 to send data to frontend
public class AccountController {
    @Autowired
    AccountServices accountServices;
    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/add") //requires ID??
    public String addAccount(@RequestBody Account account) {
        return accountServices.saveAccount(account);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountServices.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountServices.findAccountById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable Integer id) {
        return accountServices.deleteAccountById(id);
    }

    @PutMapping("/{id}")
    public String editAccountById(@PathVariable Integer id, @RequestBody Account accWithEdits) {
        return accountServices.editAccountById(id, accWithEdits);
    }

    @GetMapping("/") //localhost:8080/account/?handle=variableName
    public Account getAccountByHandle(@RequestParam String handle) {
        return accountRepository.findAccountByHandle(handle);
    }

}
