package Q4.IIS.GroupProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMIGeneratorTest {
    XMIGenerator gen;
    ComponentFactory f;
    CompositeFactory cf;
    LeafFactory lf;

    @BeforeEach
    void init() {
        gen = new XMIGenerator();
        f = new ComponentFactory();
        cf = (CompositeFactory) f.createFactory(Operation.COMPOSITE);
        lf = (LeafFactory) f.createFactory(Operation.LEAF);
    }

    @Test
    void test() {
        Composite tree = cf.create("1");
        tree.addToList(cf.create("2"));
        Composite branch = cf.create("3");
        branch.addToList(lf.create("1"));
        tree.addToList(branch);
        tree.addToList(lf.create("1"));
//        tree.addElementsToNDepth(500, 50);

        gen.generateFile(tree, "test");
    }

    @Test
    void testTabulators() {
        String result = gen.generateNTabulators(5);
        String expected = "\t\t\t\t\t";
        assertEquals(expected, result);
    }

    @Test
    void generateSmallTree() {
        Composite tree = cf.create("1");
        tree.addToList(lf.create("1.1"));
        tree.addToList(lf.create("1.2"));
        Composite branch = cf.create("2");
        branch.addToList(lf.create("2.1"));
        branch.addToList(lf.create("2.2"));
        Composite branch2 = cf.create("2.3");
        branch2.addToList(lf.create("2.3.1"));
        branch2.addToList(lf.create("2.3.2"));
        branch.addToList(branch2);
        tree.addToList(branch);
        gen.generateFile(tree, "smallTree");
    }

    @Test
    void generateSmallRandomTree() {
        Composite tree = cf.create("1");
        tree.addElementsToNDepth(5, 3);
        gen.generateFile(tree, "smallRandomTree");
    }

    @Test
    void generateMediumTree() {
        Composite tree = cf.create("1");
        tree.addElementsToNDepth(50, 5);
        gen.generateFile(tree, "mediumTree");
    }

    @Test
    void generateBigTree() {
        Composite tree = cf.create("1");
        tree.addElementsToNDepth(500, 10);
        gen.generateFile(tree, "bigTree");
    }
}