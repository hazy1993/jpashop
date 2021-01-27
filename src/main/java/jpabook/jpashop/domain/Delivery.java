package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name ="delivery_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "delivery")
    private Order order;

    @Embedded
    private   Address address;

    @Enumerated(EnumType.STRING)
    //주의, Eunm은은  @Enumerated꼭 작성해주고
    //기본값은 ORDINAL(숫자)다, 중간에 다른 상태가 생기면 망한다
    //꼭 스트링써주자
   private DeliveryStatus status;//Ready, Comp




}
