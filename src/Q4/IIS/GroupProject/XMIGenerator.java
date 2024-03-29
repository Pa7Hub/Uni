package Q4.IIS.GroupProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
    Class to generate a .xmi File from a given tree structure
    Conforms to our Component2List Metamodel

    TODO The way cleaner version to do this, is to implement a "xmi format" for each class and then just generate the .xmi file from those, instead of hardcoding the xmi code here
     that would mean that any structure, even the non-tree ones can be generated with the generator.
     However as this was simply made for a tree .xmi file, I will probably not update this to a "universal" .xmi generator
 */
public class XMIGenerator {

    public void generateFile(Component tree, String name) {
        String path = System.getProperty("user.dir") + "\\";
        try {
            File xmiFile = new File(path + name + ".xmi");
            if (xmiFile.createNewFile()) {
                System.out.println("File has been created: " + xmiFile.getName());
                System.out.println("at Path: " + xmiFile.getPath());
                this.generateHeaderAndFooter(tree, xmiFile);
            } else {
                System.out.println("The File already exists. Make sure to delete it before calling generate()!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    private void generateHeaderAndFooter(Component tree, File file) {
        try {
            FileWriter w = new FileWriter(file);
            this.generateHeader(w, tree.getType(), tree);
            // We have to instanceof here again because otherwise we'd be executing the code for a Leaf aswell
            Integer depth = 1;
            if (tree instanceof Composite) {
                Composite c = (Composite) tree;
                this.generateContent(w, c, depth);
            }
            w.write("</" + tree.getType() + ">");
            w.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    // Generates the main content from the given Composite tree
    // Will indent the lines depending on their depth tree-wise
    private void generateContent(FileWriter w, Composite c, Integer depth) {
        c.getList().forEach((e) -> {
            try {
                w.write( this.generateNTabulators(depth) + "<components xsi:type=\"" + e.getType() + "\" name=\"" + e.getName() + "\"");
                // if Composite and has atleast 1 element in components list
                if (e instanceof Composite) {
                    w.write(">\n");
                    this.generateContent(w, (Composite) e, depth+1);
                    w.write(this.generateNTabulators(depth) + "</components>\n");
                } else if (e instanceof Leaf) {
                    Leaf l = (Leaf) e;
                    w.write(">\n");
                    w.write(this.generateNTabulators(depth) + "</components>\n");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    // Generates the Header content for the .xmi file
    private void generateHeader(FileWriter w, String type, Component tree) {
        try {
            w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            w.write("<" + type + " xmi:version=\"2.0\"\n");
            w.write("\txmlns:xmi=\"http://www.omg.org/XMI\"\n");
            w.write("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
            if (type.equals("Leaf")) {
                Leaf l = (Leaf) tree;
                w.write("\txmlns=\"platform:/resource/Component2List/Metamodels/MMComponent.ecore\"\n");
                w.write("\tname=\"" + l.getName() + "\">\n");
            } else {
                w.write("\txmlns=\"platform:/resource/Component2List/Metamodels/MMComponent.ecore\"\n");
                w.write("\tname=\"" + tree.getName() + "\">\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    // Will generate a string consisting of n "\t" appended after each other
    // Will throw IndexOutOfBounds Exception for n < 0
    // FIXME public for testing
    public String generateNTabulators(Integer n) {
       return new String(new char[n]).replace("\0", "\t");
    }

}
