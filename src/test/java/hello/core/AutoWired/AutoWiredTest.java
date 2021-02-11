package hello.core.AutoWired;

import hello.core.Member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void autoWierd() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }


    static class TestBean {


        @Autowired(required = false)
        public void setNoBean1(Member nobean1) {
            System.out.println("novean=" + nobean1);
        }
//       자동 주입 대상이 없으면 호출이 안된다


        @Autowired
        public void setNoBean2(@Nullable Member nobean2) {
            System.out.println("novean2=" + nobean2);
        }
//        호출은 된다 하지만 null로 들어옴

        @Autowired
        public void setNoBean3(Optional <Member> nobean3) {
            System.out.println("novean3=" + nobean3);
        }
//얘는 들어오면 Oprtional.empty로 들어옴

    }


}
