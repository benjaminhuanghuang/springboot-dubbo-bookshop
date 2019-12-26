## Spring Data JPA 
JPA(Java Persistence API) is a standard of ORM

request => Spring Data JPA => JPA => Hibernate => JDBC => DB


http json => Controller => Service => Repository => Domain => DB

## Domain layer: map entity to database

- Spring generate table for all @Entity
```$xslt
    spring.jpa.generate-ddl = true
```

- Customize naming strategy for table and column
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
    
    
 ## Repository
No business logic, work as DAO layer

### Configuration
Add config to show SQL details
```
spring.jpa.show-sql = true
spring.jpa.properties.hibernate.format_sql = true
```

### Define the SQL
- Implement Repository Interface
 - Repository<Type of Entity, Type of ID>
 - 
 - JpaRepository
 
 
 
- Static Query:
  Method naming convention
 
- Customize SQL
 Use @Query on method to customize sql
   
- Dynamic Query: JpaSpecificationExecutor<Type of Entity>
 
 
### Customize Repository
```$xslt
    public class BookShopRepositoryImpl<T> extends SimpleJpaRepository<T, Long> 
```
Tell spring
```$xslt
    @EnableJpaRepositories(repositoryBaseClass = BookShopRepositoryImpl.class)
```

### 持久化上下文


### 抓取策略


