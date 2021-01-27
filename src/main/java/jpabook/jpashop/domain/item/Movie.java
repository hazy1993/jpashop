package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
//저장할때 구분하기 위해 사용(싱글테이블이기떄문에)
@Getter
@Setter
public class Movie  extends Item {

    private String director;
    private String actor;
}
