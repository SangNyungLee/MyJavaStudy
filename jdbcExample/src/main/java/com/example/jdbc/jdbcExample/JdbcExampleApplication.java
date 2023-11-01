package com.example.jdbc.jdbcExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcExampleApplication.class, args);
	}

	/*
		@Component에서 파생 되어 나온 어노테이션(Annotation)

		@Repository : 데이터 계층 컴포넌트
		 - 데이터베이스 연산에서 발생할 수 있는 예외를 Spring의 'DataAccessException'으로
		 변하는 기능이 포함되어있다.

		@Service : 서비스 계층 컴포넌트
		 - 비즈니스 로직을 담당하는 클래스에서 사용한다.

		@Controller : 주로 어플리케이션에서 MVC패턴의 컨트롤러 역할을 담당한다. 이 어노테이션을 사용한 클래스는
		클라이언트의 요청을 받아 처리하고 응답을 반환한다.
		(@RestController : @Controller와 유사하지만 RESTful 웹 서비스에서 사용)

		=======================================================================================

		@Autowired
		- 이 어노테이션을 사용하면 Spring 컨테이너가 자동으로 해당 타입의 Bean을 해당 필드나 메서드에 주입한다.
		1. 필드 주입 : 필드에 직접 사용하면 Spring이 해당타입의 Bean을 찾아 자동으로 필드에 주입
		장점 : 코드가 간결해진다.
		단점 : 의존성을 변겯ㅇ하거나 테스트에 어려움이 발생할 수 있다.

		2. 생성자 주입 : 생성자에 주입하면 Spring이 생성자의 파라미터 타입에 맞는 Bean을 찾아 주입
		 - 불변성을 보장, 필요한 의존성이 명확하게 표시

		3. 메서드 주입 : Setter 메서드나 임의의 메서드에 사용하면 해당 메서드의 파라미터 타입에 맞는 변을 찾아 주입

		@Autowired vs new
		공통점 : 둘다 객체를 생성하고 참조한다.
		차이점 : Spring의 IoC 컨테이너를 통해 주입을 사용, 어노테이션이 붙은 필드나 생성자는 Spring이 해당타입의
				Bean을 찾아 주입해준다.

		new 키워드 : 개발자가 명시적으로 객체를 생성하고 주입,

	 */
}
