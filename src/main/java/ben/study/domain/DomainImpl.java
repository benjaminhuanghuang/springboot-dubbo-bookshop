package ben.study.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class DomainImpl {
    @Id
    @GeneratedValue   // How to generate PK
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime = new Date();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
