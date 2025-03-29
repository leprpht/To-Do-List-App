import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var list = new TaskList();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase().trim();
            Interface.TakeInput(input, list);
        }
    }
}
