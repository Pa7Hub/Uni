package Q4.IIS.w2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTest {


    @Test
    void whenNotRootOfTreeReturnsRootCorrectly() {
        Root root = new Root();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();
        Composite composite4 = new Composite();
        Composite composite5 = new Composite();
        Composite composite6 = new Composite();
        Composite composite7 = new Composite();
        Composite composite8 = new Composite();

        root.addToContents(composite1);
        root.addToContents(composite2);
        composite2.addToContents(composite3);
        composite2.addToContents(composite4);
        composite3.addToContents(composite5);
        composite4.addToContents(composite6);
        composite6.addToContents(composite7);
        composite6.addToContents(composite8);

        assertEquals(root, composite8.getRootOfTree());
        assertEquals(root, composite4.getRootOfTree());
        assertEquals(root, composite3.getRootOfTree());
        assertEquals(root, composite6.getRootOfTree());

    }

    @Test
    void whenRootOfTreeReturnsRootCorrectly() {
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();
        Composite composite4 = new Composite();
        Composite composite5 = new Composite();
        Composite composite6 = new Composite();
        Composite composite7 = new Composite();
        Composite composite8 = new Composite();

        composite1.addToContents(composite2);
        composite2.addToContents(composite3);
        composite2.addToContents(composite4);
        composite3.addToContents(composite5);
        composite4.addToContents(composite6);
        composite6.addToContents(composite7);
        composite6.addToContents(composite8);

        assertEquals(composite1, composite8.getRootOfTree());
        assertEquals(composite1, composite6.getRootOfTree());
        assertEquals(composite1, composite3.getRootOfTree());
    }

    @Test
    void addingAlreadyContainedElementWillNotWork() {
        Root root = new Root();
        Composite rootComposite = new Composite();
        Composite secondComposite = new Composite();
        Composite unrelatedComposite = new Composite();
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();

        root.addToContents(rootComposite);
        rootComposite.addToContentsWithoutCheck(secondComposite);
//        rootComposite.addToContentsWithoutCheck(leaf1);
//        rootComposite.addToContentsWithoutCheck(leaf2);
//        rootComposite.addToContentsWithoutCheck(leaf3);

        secondComposite.addToContents(rootComposite);
        secondComposite.addToContents(unrelatedComposite);

    }
}
