package ben.study.web.controller;


import ben.study.bto.BookCondition;
import ben.study.bto.BookInfo;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @GetMapping
    @JsonView(BookInfo.BookListView.class)
    public List<BookInfo> query(BookCondition condition, @PageableDefault(size = 10) Pageable pageable) {
        return new ArrayList<BookInfo>();
    }

    @GetMapping("/{id:\\d+}")   // regex on id
    @JsonView(BookInfo.BookDetailView.class)
    @ApiOperation("Get book information")
    public Callable<BookInfo> getInfo(@ApiParam("Book id") @PathVariable Long id, @CookieValue String token, @RequestHeader String auth) {
        Callable<BookInfo> result = () -> {
            System.out.println(id);
            BookInfo bookInfo = new BookInfo();
            bookInfo.setName("abcd");
            return bookInfo;
        };
        return result;
    }


    @PostMapping
    public BookInfo create(@Valid @RequestBody BookInfo info, BindingResult result) {
        // Validation
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        info.setId(1L);
        return info;
    }

    @PutMapping("/{id}")
    public BookInfo update(@Valid @RequestBody BookInfo info, BindingResult result) {
        // Validation
        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        info.setId(1L);
        return info;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    }
}
