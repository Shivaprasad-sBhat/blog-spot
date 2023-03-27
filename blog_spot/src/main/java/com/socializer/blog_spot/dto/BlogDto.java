package com.socializer.blog_spot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer blogId;
    private LocalDateTime postingDate;

}
