package ben.study.support;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class BookShopRepositoryImpl<T> extends SimpleJpaRepository<T, Long> {

    public BookShopRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public <S extends T> S save(S entity) {
        // Do something here
        System.out.println("Do something when save " + entity.getClass().getSimpleName());
        return super.save(entity);
    }
}
