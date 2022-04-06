package com.ju.book.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
- 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
- @ResponseBody를 각 메서드마다 선언했던 것을 한번에 사용할 수 있도록
 */
public class HelloController {
    /*
    - HTTP method인 GET 요청을 받을 수 있는 API
    - 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었음

     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
