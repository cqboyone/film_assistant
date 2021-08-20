package com.vv.tool.film.assistant.crawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class CrawlerApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Pattern.matches("[a]", "aa"));
    }

    public static void main(String[] args) {
        String regex = "a*";
        System.out.println("aaa".matches(regex));
        System.out.println("aa".replaceAll(regex, "b"));
    }
}
