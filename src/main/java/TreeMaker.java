import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TreeMaker extends SimpleFileVisitor<Path> {
    private Path what;
    private Path where;

    public TreeMaker(Path what, Path where) {
        this.what = what;
        this.where = where;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Path subDir = where.resolve(what.relativize(file.getParent()));
        Files.createDirectories(subDir);

        Path filePath = where.resolve(what.relativize(file));
        Files.copy (file, filePath, StandardCopyOption.REPLACE_EXISTING);

        return FileVisitResult.CONTINUE;
    }
}


