package com.calvin.microblogging.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/account")
@CrossOrigin("http://localhost:8080") //localhost:3000 to send data to frontend
public class AccountController {
    @Autowired
    AccountServices accountServices;
    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/add")
    public String addAccount(@RequestBody Account account) { return accountServices.saveAccount(account); }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountServices.findAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        try {
            Account account = accountServices.findAccountById(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable Integer id) {
        return accountServices.deleteAccountById(id);
    }

    @PutMapping("/{id}")
    public String editAccountById(@PathVariable Integer id, @RequestBody Account accWithEdits) {
        return accountServices.editAccountById(id, accWithEdits);
    }

    @GetMapping("/handle/{handle}") //localhost:8080/account/handle/variableName
    public ResponseEntity<Optional<Account>> getAccountByHandle(@PathVariable String handle) {
            Optional<Account> account = Optional.ofNullable(accountRepository.findAccountByHandle(handle));
            if(account.isPresent()) return new ResponseEntity<>(account, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/") //localhost:8080/account/?handle=variableName
    public Account getAccountByHandle2(@RequestParam String handle) {
        return accountRepository.findAccountByHandle(handle);
    }
}
