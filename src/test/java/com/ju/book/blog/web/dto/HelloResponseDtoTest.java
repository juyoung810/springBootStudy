package com.ju.book.blog.web.dto;


import com.ju.book.blog.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;



public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        // 검증하고 싶은 대상을 메서드 인자로 받고, 메소드 체이닝이 지원되어 isEqualTo와 같이 메서드 이어서 사용 가능
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

        //롬복의 @Getter로 get 메서드가 , @RequiredArgsConstructor로 생성자가 자동으로 생성되는 것 증명 가능


    }
}
