package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;


import javax.persistence.*;
import java.util.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//부모에게 전략을 지정해줘야함(Inheritance)
//SINGLE_TABLE 한테이블에 다 때려박는것
//TABLE_PER_CLASS n개의 테이블만 나오게 하는방법(Album,Book,Movie)
//JOINED 가장 정규화된 스타일
@DiscriminatorColumn(name ="dtype")
//OO타입이면 어떻게할꺼야?? 자식에서 구현
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name ="item_id")
    private Long id;

    private String name;

    private int price;
    private int stockQuantity;//재고 수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();

    //==비즈니스 로직==//
    //재고 수량 늘리는 로직
    // stock 증가
    public void addStock(int quantity){
        this.stockQuantity+=quantity;
    }
    //stock 감소
    public void removeStock(int quantity){
        int restStock = this.stockQuantity-quantity;
        if(restStock <0){
            throw  new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
