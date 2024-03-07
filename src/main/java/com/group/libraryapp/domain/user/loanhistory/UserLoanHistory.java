package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.*;


@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private User user;

    private String bookName;

    @Column(name = "is_return", nullable = false)
    private boolean loanStatus;

    protected UserLoanHistory(){}

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.loanStatus = false;
    }

    public void doReturn() {
        this.loanStatus = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
