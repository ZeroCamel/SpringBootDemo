package com.zerocamel.elastic.repository;

import com.zerocamel.elastic.bean.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author 与JPA的仓库使用方式一致
 */
public interface BookRepository extends CrudRepository<Book,Integer> {

}
