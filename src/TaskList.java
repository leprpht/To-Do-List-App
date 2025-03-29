import java.util.HashMap;
import java.util.Map;

public class TaskList {
    public Map<String, Task> List;
    public int Size;
    public int Capacity = 25;

    public TaskList(){
        this.List = new HashMap<>();
        this.Size = 0;
    }

    public void Add(Task task){
        if (Size == Capacity){
            System.out.println("To-Do List is full.");
            return;
        }
        if (List.containsKey(task.Title)){
            System.out.println("Task" + task.Title + "already exists.");
            return;
        }
        this.List.put(task.Title, task);
        this.Size++;
    }

    public void Remove(Task task){
        if (!List.containsKey(task.Title)){
            System.out.println("Task" + task.Title + "wasn't found.");
        } else {
            this.List.remove(task.Title);
            this.Size--;
        }
    }

    public void Display(){
        System.out.println("To-Do List:\n");
        for (Map.Entry<String, Task> entry : List.entrySet()){
            entry.getValue().Display();
            System.out.println("");
        }
    }
}