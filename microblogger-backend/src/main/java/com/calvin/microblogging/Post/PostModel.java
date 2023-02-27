package com.calvin.microblogging.Post;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateTime; //2023-02-27T14:52:50.197+00:00
    private String message;
    private Boolean edited = false;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Account assocAccount;

    public PostModel() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Date getDateTime() { return dateTime; }

    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Boolean getEdited() { return edited; }

    public void setEdited(Boolean edited) { this.edited = edited; }

    //public Account getAssocAccount() { return assocAccount; }

    //public void setAssocAccount(Account assocAccount) { this.assocAccount = assocAccount; }
}
