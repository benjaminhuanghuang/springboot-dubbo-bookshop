## Spring Data JPA 
JPA(Java Persistence API) is a standard of ORM

request => Spring Data JPA => JPA => Hibernate => JDBC => DB


http json => Controller => Service => Repository => Domain => DB



- Spring generate table for all @Entity
```$xslt
    spring.jpa.generate-ddl = true
```

- Using naming strategy for table and column
```
    spring.jpa.hibernate.naming.implicit-strategy = ben.study.support.BSNamingStrategy
```

- Type Mapping
@Table
@Column


- Internal class
```
   @Embeddable
```

- Map List
    @ElementCollection   
    
- One to Many
    @ManyToOne
    N book to 1 category
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE) 


- Many to Many
    Use intermediary entity
  
- Inheritance
    @MappedSupperclass
    