import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MyClass myClass = (MyClass) context.getBean("myClass");

        myClass.introduction();
    }
}
