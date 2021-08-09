package Spring_start.hello;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

// 컴포넌트 스캔은 default로 이 패키지 포함 하위패키지 까지만 자동으로 뒤져서 등록
@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
