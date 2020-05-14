package com.wm.es;

import com.wm.es.bean.Article;
import com.wm.es.bean.Book;
import com.wm.es.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootEsApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;
    @Test
    void contextLoads() {

        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("王五");
        article.setContent("Hello bb");
        Index in = new Index.Builder(article).index("atguigu").type("news").build();
         try {
             jestClient.execute(in);
         }catch (IOException e){
             e.printStackTrace();
         }
    }

    @Test
    public void search(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("红楼梦");
        book.setAuthor("sss");
        bookRepository.index(book);
    }

}
