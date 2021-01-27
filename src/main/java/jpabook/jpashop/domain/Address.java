package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable//어딘가에 내장이 될 수 있다
@Getter
public class Address {

    private  String city;
    private  String street;
    private  String zipcode;

    //기본생성자 필수
    //함부로 접근 할 수 없게 protected 사용
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
