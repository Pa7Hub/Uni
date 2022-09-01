package Q4.IIS.GroupProject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
    Class to generate a .xmi File from a given tree structure
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
            if (tree instanceof Composite) {
                Composite c = (Composite) tree;
                this.generateContent(w, c);
            }
            w.write("</" + tree.getType() + ">");
            w.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    private void generateContent(FileWriter w, Composite c) {
        c.getList().forEach((e) -> {
            try {
                w.write("<components xsi:type=\"" + e.getType() + "\" name=\"" + e.getName() + "\"");
                // if Composite and has atleast 1 element in components list
                if (e instanceof Composite) {
                    w.write(">\n");
                    this.generateContent(w, (Composite) e);
                    w.write("</components>\n");
                } else if (e instanceof Leaf) {
                    Leaf l = (Leaf) e;
                    w.write(">\n");
                    w.write("</components>\n");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    private void generateHeader(FileWriter w, String type, Component tree) {
        try {
            w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            // This sucks but whatever
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

}
