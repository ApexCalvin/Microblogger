package com.calvin.microblogging.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
    AccountModel findAccountModelByHandle(String handle);
}
