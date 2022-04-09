package com.ju.book.blog.service.posts;

// 서비스 메서드는 트랜잭션과 도메인 간의 순서만 보장해준다.
// 각각의 비즈니스 로직 처리는 domain에서 한다.

import com.ju.book.blog.domain.posts.Posts;
import com.ju.book.blog.domain.posts.PostsRepository;
import com.ju.book.blog.web.dto.PostsListResponseDto;
import com.ju.book.blog.web.dto.PostsResponseDto;
import com.ju.book.blog.web.dto.PostsSaveRequestDto;
import com.ju.book.blog.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자로 하는 생성자 -> autowired 안써도 됨
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        // update 기능에서 DB에 쿼리 달리는 부분 없다. -> JPA의 영속성 컨텍스트 때문!
        // 영속성 컨텍스트 : 엔티티를 영구 저장하는 환경
        // JPA의 엔티티 매니저가 활성화된 상태로 트랜잭션 안에서 DB에서 데이터 가져오면, 트랙잭션 끝나느 시점에 해당 테이블에 변경값 반영한다.
        // -> 더티 체킹
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // posts-> new PostListResponseDto(posts)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
}
