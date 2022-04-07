package com.ju.book.blog.web.dto;

import com.ju.book.blog.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    // Entity 클래스 절대로 Req/Res 클래스로 사용하면 안된다.
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

   public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .build();
   }
}
