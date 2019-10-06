import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class TreeMaker extends SimpleFileVisitor<Path> {
    private List<Path> tree = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        tree.add(file);
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getTree() {
        return tree;
    }
}


