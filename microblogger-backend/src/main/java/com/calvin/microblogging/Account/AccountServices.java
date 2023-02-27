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

    public String saveAccount(AccountModel account) {
        accountRepository.save(account);
        return "Account id "+account.getId()+" has been created.";
    }

    public List<AccountModel> findAllAccounts() {
        return accountRepository.findAll();
    }

    public AccountModel findAccountById(Integer id) {
        return accountRepository.findById(id).get();
    }

    public String deleteAccountById(Integer id) {
        Optional<AccountModel> exist = accountRepository.findById(id);

        if(exist.isPresent()) {
            accountRepository.deleteById(id);
            return "Account ID: "+id+" has been deleted.";
        }
        return "Account ID: "+id+" does not exist.";
    }

    public String editAccountById(Integer id, AccountModel accWithEdits) {
        Optional<AccountModel> exist = accountRepository.findById(id);

        if(exist.isPresent()) {
            if(accWithEdits.getId() != null) {
                accountRepository.save(accWithEdits);
                return "Account ID: "+id+" has been edited.";
            }
            return "JSON object is missing an account ID.";
        }
        return "Failed to edit Account ID: "+id;
    }

    public profileDTO findAccountByHandle (String handle) {
        Optional<AccountModel> exist = Optional.ofNullable(accountRepository.findAccountModelByHandle(handle));
        return saveToProfileDTO(exist.get());
    }

    public profileDTO saveToProfileDTO(AccountModel account) {
        profileDTO profile = new profileDTO();
        profile.setAccount_id(account.getId());
        profile.setName(account.getName());
        profile.setHandle(account.getHandle());
        return profile;
    }
}
