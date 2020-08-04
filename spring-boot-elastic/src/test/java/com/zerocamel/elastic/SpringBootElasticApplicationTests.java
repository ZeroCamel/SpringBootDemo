package com.zerocamel.elastic;

import com.zerocamel.elastic.bean.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@SpringBootTest
class SpringBootElasticApplicationTests {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {

        Article article = new Article();
        article.setId(1);
        article.setAuthor("张三");
        article.setContent("hhh这是正文");
        article.setTitle("好消息");


    }

}
