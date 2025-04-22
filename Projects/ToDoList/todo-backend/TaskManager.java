import java.util.ArrayList;
import java.util.List;

public class TaskManager{
    private List<Task> tasks; //Made a list of "Task" type
    private int nextId; //set a instance nextId count


    public TaskManager(){
        tasks = new ArrayList<>(); //initializes the arraylist
        nextId = 0; //initializes id to 0
    }

    public List<Task> getTask(){
        return tasks;
    }


    void addTask(String title){
        Task task1 = new Task(++nextId,title); //creates new task
        tasks.add(task1); //adds the task to arraylist
    }

    void removeTask(int id){ //Adding removeTask to remove using id
        tasks.remove(id-1);
    }
    void printComplete(){  //Prints Completed task
        for(int i = 0; i<tasks.size(); i++){
            if(tasks.get(i).isCompleted()){
                System.out.println("Task " + "["+tasks.get(i).getId()+ "]" + " Title -> "+ tasks.get(i).getTitle() + ": Completed"); 
            }

          
        }
    }
    void printPending(){  //Prints Pending task
        for(int i = 0; i<tasks.size();i++){
            if(!tasks.get(i).isCompleted()){
                
                System.out.println("Task " + "["+tasks.get(i).getId()+ "]" + " Title -> "+ tasks.get(i).getTitle() + " : Pending"); 
            }
        }
    }
    void printAll(){ //Prints all task
        System.out.printf("| %-7s | %-20s | %-12s |\n", "Task ID", "Task Name", "Status");
        System.out.println("|---------|----------------------|--------------|");

        for(int i = 0; i<tasks.size(); i++){
            if(tasks.get(i).isCompleted()){
               System.out.printf("| %-7d | %-20s | %-12s |\n", tasks.get(i).getId(), tasks.get(i).getTitle(), "Completed");
            }else{
               System.out.printf("| %-7d | %-20s | %-12s |\n", tasks.get(i).getId(), tasks.get(i).getTitle(), "Pending");

            }
        }
    }
}
