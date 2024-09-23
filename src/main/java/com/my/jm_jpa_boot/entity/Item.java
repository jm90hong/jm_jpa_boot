package com.my.jm_jpa_boot.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 포함
@Builder // 빌더 패턴으로 객체를 생성할 수 있도록 지원
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드에 대한 생성자 자동 생성

public class Item {

    @Id
    @Column(name = "item_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemIdx;

//    @Column(nullable = false, name="user_idx")
//    private Integer userIdx;

    @Column(nullable = false,name="name")
    private String name;

    @Column(nullable = false,name="created_date")
    private LocalDateTime createdDate;


    // 연관된 User를 가져오기 위해 @ManyToOne 관계 설정
    //item에 user_idx가 있지만 연관관계를 User와 설정하므로 user_idx를 추가 할 필요 없음.
    
    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    @JsonIgnore
    private User user;

    
    // Lombok을 사용하여 생성자, getter, setter 등이 자동으로 생성됨
}