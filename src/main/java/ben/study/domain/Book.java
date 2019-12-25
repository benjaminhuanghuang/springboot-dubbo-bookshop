package ben.study.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends DomainImpl {
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }
}
