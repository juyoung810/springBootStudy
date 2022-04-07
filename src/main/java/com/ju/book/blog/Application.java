package com.ju.book.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA auditing annotation 모두 활성화
@SpringBootApplication // 스프링 부트 자동설정, 스프링 bean 읽기와 생성 자동으로 설정된다.
// 이 annotation이 있는 위치부터 설정을 읽어간다. -> 이 클래스가 항상 프로젝트의 최상단에 위치 필요
public class Application { // 프로젝트의 main class
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
        // 내장 WAS : 외부에 WAS 두지 않고 애플리케이션 실행마다 내부에서 WAS 실행하는 것
        // 서버에 톰캣 서ㄹ치할 필요 없고, 스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행하면 된다.
        // 스프링 부트에서는 내장 WAS 사용을 권장한다. -> '언제 어디서나 같은 환경에서 스프링 부트를 배포' 할 수 있기 때문
    }
}
