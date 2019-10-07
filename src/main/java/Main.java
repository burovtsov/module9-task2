import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(;;)
        {
            System.out.println("Кого будем копировать, начальник?");
            try {
            Path whatCopy = Paths.get(scanner.nextLine());
            System.out.println("Куда будем копировать?");
            Path whereCopy = Paths.get(scanner.nextLine());

            TreeMaker dirTree = new TreeMaker(whatCopy, whereCopy);
            Files.walkFileTree(whatCopy, dirTree);
            System.out.println("Копирование успешно завершено.");

            }
            catch (Exception e) {
                ExceptionLogger.logIt(e);
            }
        }
    }
}
