package ben.study.controller;


import ben.study.bto.BookCondition;
import ben.study.bto.BookInfo;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<BookInfo> query(BookCondition condition, @PageableDefault(size=10 ) Pageable pageable){
        return new ArrayList<BookInfo>();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public BookInfo getInfo(@PathVariable Long id){
        System.out.println(id);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("abcd");
        return bookInfo;
    }
}
