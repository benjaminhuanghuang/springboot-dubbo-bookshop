package ben.study.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue   // How to generate PK
    private Long id;

    @Column(name="name", length = 10, nullable = false)
    private String name;

    @Column(columnDefinition = "INT(3)")
    private int age;

    @Temporal(TemporalType.DATE)  // How to save Date into database
    private Date birthday;

    @Enumerated(EnumType.STRING)   // to VARCHAR(255)
    private Sex sex;
    public Long getId() {
        return id;
    }

    @Embedded
    private Address address;

    @ElementCollection              // Create a hobbies table
    private List<String> hobbies;

    @OneToMany(mappedBy = "author")
    private List<BookAuthor> books;


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BookAuthor> getBooks() {
        return books;
    }

    public void setBooks(List<BookAuthor> books) {
        this.books = books;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
