package ben.study.repository;

import ben.study.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest extends BaseTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    void test1() {
        bookRepository.findByName("abc");

    }
}