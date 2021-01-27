package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test @DisplayName("업데이트 테스트")
    void updateTEst() throws Exception{
        //given

        Book book = em.find(Book.class,1L);
        //when

        //TX
        book.setName("asdfasdf");

        //변경감지 == dirty checking


        //then


    }

}




