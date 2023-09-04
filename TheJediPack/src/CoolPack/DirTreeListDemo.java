package CoolPack;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/*
This program displays files using walkFileTree()
kwi directory ka \MyDir.
 */

// Create a custom version of SimpleFileVisitor that overrides
// the visitFile( ) method.
class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DirTreeListDemo {
    public static void main(String... args) {
        String dirname = "\\MyDir";
        System.out.println("Directory tree starting with " + dirname + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException exc) {
            System.out.println("I/O Error");
        }
    }

}
