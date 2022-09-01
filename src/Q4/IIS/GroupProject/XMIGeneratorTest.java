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
        String name = "generatedTree";
        Composite tree = cf.create("1");
//        tree.addToList(cf.create("2"));
//        Composite branch = cf.create("3");
//        branch.addToList(lf.create("1", 7));
//        tree.addToList(branch);
//        tree.addToList(lf.create("1", 7));
        tree.addElementsToNDepth(20);

        gen.generateFile(tree, "pleaseWork");
    }
}
