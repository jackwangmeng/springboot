package com.wm.es.repository;

import com.wm.es.bean.Book;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
