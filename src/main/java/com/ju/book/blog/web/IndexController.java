package com.ju.book.blog.web;

import com.ju.book.blog.service.posts.PostsService;
import com.ju.book.blog.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체 저장
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
//    @GetMapping("/")
//    public String index() {
//        return "index"; //머스테치에서 문자열 반환 시 앞의 경로와 뒤의 파일 확장자 자동으로 지정된다
//    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
