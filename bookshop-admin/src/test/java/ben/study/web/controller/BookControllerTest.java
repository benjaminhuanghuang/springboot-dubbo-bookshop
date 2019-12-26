package ben.study.web.controller;

import ben.study.BookShopAdminApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookShopAdminApplication.class)
class BookControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

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

    @Test
    public void whenGetBookInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("abcd"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/a")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void whenCreateBookSuccess() throws Exception {
        String input = "{\"name\":\"abcd\",\"id\":null,\"content\":null, \"publishDate\":\"2017-05-05\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/book").content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void whenUpdateBookSuccess() throws Exception {
        String input = "{\"name\":\"abcd\",\"id\":null,\"content\":null, \"publishDate\":\"2017-05-05\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/book/1").content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void whenDeleteBookSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenCookieOrHeaderExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
                .cookie(new Cookie("token", "123456"))
                .header("auth", "asdf")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenUploadSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart("/file/upload")
                .file(new MockMultipartFile("file", "testFile.txt", "multipart/form-data", "Hello".getBytes("UTF-8"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}