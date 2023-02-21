package com.calvin.microblogging.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {
    @Autowired
    AccountRepository accountRepository;

    /*
    Create  |   Save                    |   Post
    Read    |   Get (Singular/Plural)   |   Get
    Update  |   Save                    |   Put
    Delete  |   Delete                  |   Delete
     */

    public String saveAccount(Account account) {
        Optional<Account> exist = accountRepository.findById(account.getId());

        if(exist.isEmpty()) {
            accountRepository.save(account);
            return "Account has been created.";
        }
        return "Failed to create account.";
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findAccountById(Integer id) {
        //Optional<Account> exist = accountRepository.findById(id);
        return accountRepository.findById(id).get();
    }

    public String deleteAccountById(Integer id) {
        Optional<Account> exist = accountRepository.findById(id);

        if(exist.isPresent()) {
            accountRepository.deleteById(id);
            return "Account ID: "+id+" has been deleted.";
        }
        return "Account ID: "+id+" does not exist.";
    }

    public String editAccountById(Integer id, Account accWithEdits) {
        Optional<Account> exist = accountRepository.findById(id);

        if(exist.isPresent()) {
            //fix no id with response
            accountRepository.save(accWithEdits);
            //fix +id+
            return "Account ID: \"+id+\" has been edited.";
        }
        return "Failed to edit Account ID: "+id;
    }
}
