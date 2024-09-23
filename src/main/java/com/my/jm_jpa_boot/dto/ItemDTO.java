package com.my.jm_jpa_boot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 포함
@Builder // 빌더 패턴으로 객체를 생성할 수 있도록 지원
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드에 대한 생성자 자동 생성

//DTO : Data Transfer Object
public class ItemDTO {
    private Integer itemIdx;
    private String name;
    private LocalDateTime createdDate;
    private String userNick;  // User의 닉네임 정보

   

    // Getters and setters
    public Integer getItemIdx() {
        return itemIdx;
    }

    public void setItemIdx(Integer itemIdx) {
        this.itemIdx = itemIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}