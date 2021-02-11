package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
