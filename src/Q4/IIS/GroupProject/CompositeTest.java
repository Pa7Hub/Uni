package Q4.IIS.GroupProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTest {
    @Test
    void depthTest() {
        Composite c = new Composite("Cool name");
        c.addElementsToNDepth(20);
        System.out.println(c);
    }
}
