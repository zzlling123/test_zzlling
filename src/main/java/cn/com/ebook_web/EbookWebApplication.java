package cn.com.ebook_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.com.ebook_web.dao")
public class EbookWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbookWebApplication.class, args);
    }

}
