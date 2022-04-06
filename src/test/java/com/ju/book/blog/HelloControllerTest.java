package com.ju.book.blog;
// WAS 실행하지 않고 , 테스트 코드로 검증
// 일반적으로 테스트 클래스는 대상 클래스 이름 + Test

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
/*
- 테스트 진행 시 JUnit에 내장된 실행자 외 SpringRunner라는 다른 스프링 실행자를 사용한다.
- 즉, 스프링 부트 테스트와 JUnit 사이 연결자 역할한다.
 */
@WebMvcTest
/*
- Web에 집중할 수 있는 어노테이션
- @Controller, @ControllerAdvice 사용가능, @service, @Component, @Repository 사용불가능
- 여기서는 controller 만 사용하기 때문에 선언한 것
 */
public class HelloControllerTest {

    @Autowired
    // 스프링이 관리하는 bean을 주입 받는다.
    private MockMvc mvc;
    /*
    - 웹 API 테스트 시 사용
    - 스프링 MVC 테스트의 시작점
    - 이 클래스 통해 HTTP GET, POST에 대한 API 테스트 진행가능
     */

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(MockMvcRequestBuilders.get("/hello")) //Mock MVC 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform의 결과 HTTP header의 status 검증 -> 200인지 아닌지
                .andExpect(content().string(hello)); //mvc.perform의 결과 응답 본문 내용 검증 -> 값이 일치하는지 검증
    }
}
