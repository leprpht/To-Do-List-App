import java.util.Scanner;

public class Interface {
    public static void TakeInput(String input, TaskList list){
        if (null != input.toLowerCase().trim()) switch (input.toLowerCase().trim()){
            case "help":
                Help();
                return;
            case "show":
                Show(list);
                return;
            case "quit":
                System.exit(0);
            default:
                break;
        }
        String[] fullInput = input.trim().split(" ");
        if (fullInput.length != 2){
            System.out.println("Input error.");
            return;
        }
        switch (fullInput[0].toLowerCase().trim()) {
            case "create" -> {
                CreateTask(fullInput[1].trim().replace("_", " "), list);
                return;
            }
            case "remove" -> {
                RemoveTask(fullInput[1].trim().replace("_", " "), list);
                return;
            }
            case "check" -> {
                CheckTask(fullInput[1].trim().replace("_", " "), list);
                return;
            }
            case "edit" -> {
                EditTask(fullInput[1].trim().replace("_", " "), list);
                return;
            }
            default -> System.out.println("Input error.");
        }
    }
    public static void Help(){
        System.out.println("Available commands:\n  1. Help.\n  2. Show - to view the list of tasks.\n  3. Create + [task name] - to add a task to the list.\n  4. Remove + [task name] - to remove a task from the list.\n  5. Check + [task name] - to check/uncheck the box.\n  6. Edit + [task name] - to edit an existing task.\n  7. Quit.");
    }

    public static void Show(TaskList list){
        list.Display();
    }

    public static void CreateTask(String input, TaskList list){
        var task = new Task(input);
        list.Add(task);
    }

    public static void RemoveTask(String input, TaskList list){
        var task = list.List.get(input);
        if (task != null) list.Remove(task);
        else System.out.println("Task wasn't found.");
    }

    public static void CheckTask(String input, TaskList list){
        var task = list.List.get(input);
        if (task.Complete) task.ChangeStatus(false);
        else task.ChangeStatus(true);
    }

    public static void EditTask(String input, TaskList list){
        var task = list.List.get(input);
        while (true){
            Scanner scanner = new Scanner(System.in);
            String newInput = scanner.nextLine().toLowerCase().trim();
            if (null == newInput){
                System.out.println("Input error.");
                return;
            }
            switch (newInput){
                case "help" -> {
                    System.out.println("Available commands:\n  1. Help.\n  2. Rename - to rename the task.\n  3. Description Change - to edit task's description.\n  4. Description Erase - to erase task's description.\n 5. Quit.");
                }
                case "quit" -> {
                    return;
                }
                case "rename" -> {
                    System.out.println("Insert new task name.");
                    scanner = new Scanner(System.in);
                    String newerInput = scanner.nextLine().trim().replace("_", " ");
                    task.Rename(newerInput);
                }
            }
            String[] newInputSplit = newInput.split(" ");
            if (newInputSplit.length != 2) System.out.println("Input error.");
            if (!"description".equals(newInputSplit[0])){
                System.out.println("Input error.");
                return;
            } else {
                if (null == newInputSplit[1])System.out.println("Input error."); else switch (newInputSplit[1]){
                    case "change" -> {
                        System.out.println("Insert new description.");
                        scanner = new Scanner(System.in);
                        String newerInput = scanner.nextLine().toLowerCase().trim();
                        task.ChangeDescription(newerInput);
                    }
                    case "erase" -> task.EraseDescription();
                    default -> System.out.println("Input error.");
                }
            }
        }
    }
}
