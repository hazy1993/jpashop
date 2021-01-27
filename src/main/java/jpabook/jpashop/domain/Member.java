package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded//임베디드 타입을 내장했다는 뜻
    private Address address;

    @OneToMany(mappedBy = "member") //하나의 멤버가 여러개의 주문을 하기때문에 !! 1대 다
    //(mappedBy = "member") 누구에 의해 매핑이 됬는지 알려주고, 나는 거울이다(값변경 불가하다,읽기 전용) 라고 알려줌
    private List<Order> orders = new ArrayList<>();



}
