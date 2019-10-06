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

            Copier copier = new Copier();
            copier.copy(whatCopy, whereCopy);
            }

            catch (Exception e) {
                ExceptionLogger.logIt(e);
            }
        }
    }
}
