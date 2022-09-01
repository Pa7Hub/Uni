package Q4.IIS.GroupProject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
    Class to generate a .xmi File from a given tree structure
 */
public class XMIGenerator {

    public void generateFile(Component tree) {
        // TODO BEFORE RUNNING THE CODE, SPECIFY THE CORRECT PATH HERE!
        String path = "D:\\Repositories\\Uni\\";
        String name = "generatedTree";
        try {
            File xmiFile = new File(path + name + ".xmi");
            if (xmiFile.createNewFile()) {
                System.out.println("File has been created: " + xmiFile.getName() + " at Path: " + xmiFile.getPath());
                this.generateContent(tree, xmiFile);
            } else {
                System.out.println("The File already exists. Make sure to delete it before calling generate()!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    private void generateContent(Component tree, File file) {
        try {
            FileWriter w = new FileWriter(file);
            w.write("Line 1");
            w.write("Line 2");
            w.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

}
