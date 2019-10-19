package com.ss.lms.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbl_author")
public class Author implements Serializable {
    
	private static final long serialVersionUID = 19094896619401193L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private Integer authorId;
    @Column(name = "authorName")
    private String authorName;


    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
