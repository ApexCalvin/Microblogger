package com.calvin.microblogging.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/account")
@CrossOrigin("http://localhost:8080") //localhost:3000 to send data to frontend
public class AccountController {
    @Autowired
    AccountServices accountServices;

    @PostMapping("/add")
    public String addAccount(@RequestBody AccountModel account) { return accountServices.saveAccount(account); }

    @GetMapping("/all")
    public List<AccountModel> getAllAccounts() {
        return accountServices.findAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel> getAccountById(@PathVariable Integer id) {
        try {
            AccountModel account = accountServices.findAccountById(id);
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
    public String editAccountById(@PathVariable Integer id, @RequestBody AccountModel accWithEdits) {
        return accountServices.editAccountById(id, accWithEdits);
    }

    @GetMapping("/handle/{handle}") //localhost:8080/account/handle/variableName
    public ResponseEntity<profileDTO> getAccountByHandle(@PathVariable String handle) {
        try {
            profileDTO profile = accountServices.findAccountByHandle(handle);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/") //localhost:8080/account/?handle=variableName
    public AccountModel getAccountByHandle2(@RequestParam String handle) {
        return accountRepository.findAccountModelByHandle(handle);
    }
}
