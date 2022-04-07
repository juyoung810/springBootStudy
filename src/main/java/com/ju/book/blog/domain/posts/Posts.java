package com.ju.book.blog.domain.posts;

import com.ju.book.blog.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 주요 어노테이션을 클래스에 가깝게 둔다. lombok은 코드를 단순화시켜주지만 필수는 아니다.
@Getter // 클래스 내 모든 필드 Getter 메서드 생성
/**** entity class 에서는 절대 Setter 메서드를 만들지 않는다. *****/
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 알린다. 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름 매칭한다.
public class Posts extends BaseTimeEntity { // 실제로 DB 테이블과 매칭될 클래스

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, IDENTITY 옵션 추가해야 auto_increment 된다.
    private Long id;

    // Column 굳이 선언안해도 Entity class의 필드 모두 칼럼된다.
    // 기본값(varchar(255) 외에 추가로 변경 필용한 옵션 있을 경우 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
