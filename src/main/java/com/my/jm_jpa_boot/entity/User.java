package com.my.jm_jpa_boot.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 포함
@Builder // 빌더 패턴으로 객체를 생성할 수 있도록 지원
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드에 대한 생성자 자동 생성

public class User {

    @Id
    @Column(name = "user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userIdx;

    @Column(nullable = false, unique = true,name="id")
    private String id;

    @Column(nullable = false,name="pw")
    private String pw;

    @Column(nullable = false,name="nick")
    private String nick;

    @Column(nullable = false,name="created_date")
    private LocalDateTime createdDate;

    // Item과의 연관 관계 설정 (User는 여러 Item을 가질 수 있음)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;


    // Lombok을 사용하여 생성자, getter, setter 등이 자동으로 생성됨
}