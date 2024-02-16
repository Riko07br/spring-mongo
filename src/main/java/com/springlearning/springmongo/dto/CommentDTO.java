package com.springlearning.springmongo.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //region Attributes
    private String body;
    private Date date;
    private AuthorDTO author;
    //endregion

    //region Constructors
    public CommentDTO() {
    }

    public CommentDTO(String body, Date date, AuthorDTO author) {
        this.body = body;
        this.date = date;
        this.author = author;
    }
    //endregion

    //region Getters & Setters
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
    //endregion
}
