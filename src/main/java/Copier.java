import java.nio.file.*;

public class Copier {

    public void copy(Path what, Path where) {
        Path copyPath;
        String filePath;

        try {
            TreeMaker dirTree = new TreeMaker();
            Files.walkFileTree(what, dirTree);

            for (Path p : dirTree.getTree()) {
                filePath = p.getParent().toString() + "/" + p.getFileName().toString();
                filePath = filePath.replace(what.toString(), where.toString());
                copyPath = Paths.get(filePath);

               if (!copyPath.getParent().toFile().exists())
                    Files.createDirectories(copyPath.getParent());

               Files.copy(p, copyPath, StandardCopyOption.REPLACE_EXISTING);
               System.out.println("Копирование успешно завершено!");
            }
        } catch (Exception e) {
            ExceptionLogger.logIt(e);
        }
    }
}


