package Q4.IIS.GroupProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMIGeneratorTest {
    @Test
    void test() {
        XMIGenerator gen = new XMIGenerator();
        ComponentFactory fac = new ComponentFactory();
        CompositeFactory cf = (CompositeFactory) fac.createFactory(Operation.COMPOSITE);
        LeafFactory lf = (LeafFactory) fac.createFactory(Operation.LEAF);
        Composite tree = cf.create("1");
//        tree.addToList(cf.create("2"));
//        Composite branch = cf.create("3");
//        branch.addToList(lf.create("1"));
//        tree.addToList(branch);
//        tree.addToList(lf.create("1"));
        tree.addElementsToNDepth(200, 20);

        gen.generateFile(tree, "BigTree");
    }

    @Test
    void testTabulators() {
        XMIGenerator gen = new XMIGenerator();
        String result = gen.generateNTabulators(5);
        String expected = "\t\t\t\t\t";
        assertEquals(expected, result);
    }
}
