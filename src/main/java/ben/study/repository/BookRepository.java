package ben.study.repository;

import java.util.List;

import org.springframework.data.repository.Repository;
//
import ben.study.domain.Book;


public interface BookRepository  extends Repository<Book, Long> {
    List<Book> findByName(String name);
}

