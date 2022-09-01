package Q4.IIS.GroupProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMIGeneratorTest {
    @Test
    void test() {
        XMIGenerator gen = new XMIGenerator();
        ComponentFactory fac = new ComponentFactory();
        gen.generateFile(fac.create(Operation.LEAF, "Cool Leaf", 1));
    }
}
