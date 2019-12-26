


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