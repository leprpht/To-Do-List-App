public class Task {
    public String Title;
    public String Description;
    public Boolean Complete;

    public Task(String title){
        if (title.isBlank() || title.isEmpty()){
            System.out.println("Invalid task name.");
            return;
        }
        if (title.length() >= 30){
            System.out.println("Task name cannot exceed 30 characters.");
            return;
        }
        this.Title = title;
        this.Complete = false;
        this.Description = "";
    }

    public void ChangeDescription(String description){
        if (description.isBlank() || description.isEmpty()){
            System.out.println("Invalid description.");
            return;
        }
        this.Description = description;
    }

    public void EraseDescription(){
        this.Description = null;
    }

    public void ChangeStatus(Boolean status){
        this.Complete = status;
    }

    public void Rename(String rename){
        if (rename.isBlank() || rename.isEmpty()){
            System.out.println("Invalid task name.");
            return;
        }
        this.Title = rename;
    }

    public void Display(){
        if (Complete){
            System.out.print("☑ - ");
        } else {
            System.out.print("☐ - ");
        }
        System.out.println(this.Title);
        System.out.println(this.Description);
    }
}
