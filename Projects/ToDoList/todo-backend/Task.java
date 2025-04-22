public class Task{
    //Declare Task related variables
    private int id; //Unique identitiy of each task
    private String title; //title of the task
    private boolean isCompleted; //is this task complete

    //Declare the constructor which takes id and title
    public Task(int id, String title){
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    //Create Getters and Setters
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isCompleted(){
        return isCompleted;
    }

    //Create Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setCompleted(boolean completed){
        this.isCompleted = completed;
    }
    
    
    

    //toString to print
    @Override
    public String toString(){
        return "[" + (isCompleted ? "X" : " ") + "] " + id + ": " + title;
    }


}
