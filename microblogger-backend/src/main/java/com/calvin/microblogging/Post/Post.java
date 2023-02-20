package com.calvin.microblogging.Post;

import com.calvin.microblogging.Account.Account;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateTime;
    private String message;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Account assocAccount;

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public Account getAssocAccount() {
//        return assocAccount;
//    }
//
//    public void setAssocAccount(Account assocAccount) {
//        this.assocAccount = assocAccount;
//    }
}
