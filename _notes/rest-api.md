


## UT
```$xslt
    @Test
    public void whenBookQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book")
                .param("categoryId", "1")
                .param("name", "abcd")
                .param("page", "1")
                .param("size", "10")
                .param("sort", "name,desc", "createdTime, asc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
```
[Document about json path] (https://github.com/json-path/JsonPath)

## Parameter
```$xslt
    public class BookCondition  {
        private String name;
        private Long categoryId;
    }
```

## Pagination
```$xslt
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-commons</artifactId>
    </dependency>
```

```$xslt
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<BookInfo> query(BookCondition condition, @PageableDefault(size=10 ) Pageable pageable){
        return new ArrayList<BookInfo>();
    }
```

## Date
```$xslt
    spring.jackson.time-zone = GMT-7
```

## Validation
```$xslt
   Add @NotBlank to bto class
```
Read validation from BindingResult
```$xslt
    @PostMapping
    public BookInfo create(@Valid @RequestBody BookInfo info, BindingResult result) {
        // Validation
        if(result.hasErrors())
        {
            result.getAllErrors().stream().forEach(error-> System.out.println(error.getDefaultMessage()));
        }
        info.setId(1L);
        return info;
    }
```

## Pass cookie
```$xslt
    public BookInfo getInfo(@PathVariable Long id, @CookieValue String token, @RequestHeader String auth) {
        System.out.println(id);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName("abcd");
        return bookInfo;
    }
```


## Error handling
Spring default error page
```$xslt
    resources/resources/error/404.html
    resources/resources/error/500.html

```
Customize
```$xslt
    @RestControllerAdvice
    public class ExceptionHandlerController {
        @ExceptionHandler(RuntimeException.class)
        @ResponseStatus(code = HttpStatus.BAD_REQUEST)
        public Map<String, Object> handlerException(RuntimeException exception)
        {
            Map<String, Object> result = new HashMap<>();
            result.put("result", "fail");
            result.put("errMsg", exception.getMessage());
    
            return result;
        }
    
    }
```

## Interceptor
```$xslt
    @Component
    public class TimeInterceptor implements HandlerInterceptor {
    }
    
    public class WebConfig implements WebMvcConfigurer 
    {
    }
```

## Async
```$xslt
    public Callable<BookInfo> getInfo(@PathVariable Long id, @CookieValue String token, @RequestHeader String auth) {
        Callable<BookInfo> result = () -> {
            System.out.println(id);
            BookInfo bookInfo = new BookInfo();
            bookInfo.setName("abcd");
            return bookInfo;
        };
        return result;
    }
```