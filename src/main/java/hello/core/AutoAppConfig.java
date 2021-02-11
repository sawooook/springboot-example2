package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//       모든 코드를 다뒤지기 때문에 오래 걸림 그래서 시작 패키지를 정해줌
//        basePackages = "hello.core",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 배제 해주겠다.
)
public class AutoAppConfig {
//나의 프로젝트 최상단위에서 한다
//프로젝트를 대ㅠㅛ하는 정보이기때문에 프로젝트 시작 루트에 두는것이 좋음
}

/*
* @Component 컴포넌트 스캔에 사용
*
* @Controller -> MVC 컨트롤러로 인식
*
* @Service 비지니스 로직 -> 특별처리는 없지만 핵심 비지니스 로직이 여기있구나
* 라고 암
*
* @Repository JPA JDBC ->스프링 데이터 접근계층으로 인식하고 ,
* 데이터 계층의 예외를 스프링 예외로 변환해줌
* ex) DB접근 예외를 스프링 예외로 벼녕해줌
*
* @Configuration 스프링 설정 정보 -> 스프링 설정 정보를 인식하고
* 스프링 빈이 싱글톤을 유지하도록 추가 처리를함
*
*
* 에노테이션은 상속관계가 없음 -> 메타정보임
* */


/**
 * # spring boot 사용 x
 *   new AnnotationConfigApplicationContext(AutoAppConfig.class);
 *    1. ApplicatonContext(스프링 컨테이너) 생성
 *    2.  AutoAppConfig를 스프링 빈으로 등록
 *    3. AutoAppConfig에 @ComponentScan이 달려있으므로, @Component 어노테이션이 달려있는 클래스를 스프링 컨테이너에 빈으로 등록
 *
 * # spring boot 사용
 *    1-1. @SpringBootApplication 이 붙어있는 class(이 예제에서는 CoreApplication)의 main 함수가 실행.
 *    1-2. @SpringBootTest 테스트 실행 -> @SpringBootApplication 어노테이션을 찾아감
 *    2. 위 둘 중 하나를 하면 스프링부트 내부에서 자동으로 ApplicationContext (스프링 컨테이너)를 생성.
 *    3. @SpringBootApplication에는 @ComponentScan이 포함되어 있음.
 *       => @Component 어노테이션이 달려있는 클래스를 스프링 컨테이너에 빈으로 등록
 *       (@Configuration에도 @Component가 포함되어있으므로 이 어노테이션이 달려있는 설정 클래스도 빈으로 컨테이너에 등록,
 *        이때 만약 @Bean 어노테이션이 있으면 빈을 컨테이너에 등록)
 */