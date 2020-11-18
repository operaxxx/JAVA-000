import homework0401.javaconfig.StudentC;
import homework0401.javaconfig2.StudentE;
import homework0401.javaconfig2.StudentF;
import homework0401.xml.StudentA;
import homework0401.scan.StudentB;
import homework0401.xml.StudentD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyClass implements IClass {

    private StudentA studentA;

    @Autowired
    private StudentB studentB;

    @Autowired
    private StudentC studentC;

    private StudentD studentD;

    @Autowired
    private StudentE studentE;

    @Autowired
    private StudentF studentF;

    public MyClass () {}

    public MyClass(StudentA studentA) {
        this.studentA = studentA;
    }

    public void introduction() {
        studentA.introduction();
        studentB.introduction();
        studentC.introduction();
        studentD.indroduction();
        studentE.introduction();
        studentF.introduction();
    }

    public void setStudentD(StudentD studentD) {
        this.studentD = studentD;
    }
}
