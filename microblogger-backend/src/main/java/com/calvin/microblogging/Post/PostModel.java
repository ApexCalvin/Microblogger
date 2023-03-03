package com.calvin.microblogging.Post;

import com.calvin.microblogging.Account.AccountModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
//@NamedNativeQuery(name = "findPostsDESC",
//        query = """
//                SELECT * FROM post_model ORDER BY date_time DESC;
//                """,
//        resultSetMapping = "mapToPostModel")
//
//@SqlResultSetMapping(
//        name = "mapToPostModel",
//        classes = @ConstructorResult(targetClass = PostModel.class,
//                                        columns = {
//                                                    @ColumnResult(name = "id", type = Integer.class),
//                                                    @ColumnResult(name = "date_time", type = Date.class),
//                                                    @ColumnResult(name = "message", type = String.class),
//                                                    @ColumnResult(name = "edited", type = Boolean.class) }
//        )
//)

public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateTime; //2023-02-27T14:52:50.197+00:00
    private String message;
    private Boolean edited = false;
//    @ManyToOne
//    private AccountModel assocAccount;

    public PostModel() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Date getDateTime() { return dateTime; }

    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Boolean getEdited() { return edited; }

    public void setEdited(Boolean edited) { this.edited = edited; }

    //public AccountModel getAssocAccount() { return assocAccount; }

    //public void setAssocAccount(AccountModel assocAccount) { this.assocAccount = assocAccount; }
}
