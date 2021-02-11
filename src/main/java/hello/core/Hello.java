package hello.core;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hello {
    private String name;

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setName("test");

        System.out.println("hello"+hello);
    }
}
