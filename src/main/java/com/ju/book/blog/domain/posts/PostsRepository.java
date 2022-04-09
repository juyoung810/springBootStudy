package com.ju.book.blog.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Posts 클래스로 Database를 접근하게 해줄 JpaRepository
// 보통 MyBatis 등에서 Dao로 불리는 DB Layer 접근자
// Jpa에서는 Repository 인터페이스로 생성 -> JpaRepository<Entity 클래스, PK 타입> 상속시 기존적 CRUD 자동 생성
// @Repository 추가 안할 경우 Entity와 같이 위치
public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("Select p from Posts p order by p.id DESC ")
    List<Posts> findAllDesc();
}
