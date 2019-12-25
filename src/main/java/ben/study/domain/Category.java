package ben.study.domain;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue   // How to generate PK
    private Long id;

    @Column(name="name", length = 10, nullable = false)
    private String name;

    @Transient   // Don't create column in table
    private String temp;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)   // Don't create extra table
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
