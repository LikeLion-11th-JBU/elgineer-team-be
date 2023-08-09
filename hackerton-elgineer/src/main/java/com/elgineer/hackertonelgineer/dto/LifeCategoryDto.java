package com.elgineer.hackertonelgineer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LifeCategoryDto {
    private Long id;

    private String content;

    public LifeCategoryDto toEntity(){
        LifeCategoryDto build = LifeCategoryDto.builder()
                .id(id)
                .content(content)
                .build();
        return build;
    }

    @Builder

    public LifeCategoryDto(Long id, String content) {
        this.id = id;

        this.content = content;
    }

}
