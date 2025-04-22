import java.util.Scanner;
import java.util.HashSet;

public class Main{
    public static void main(String [] args){
       
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while(true){

         System.out.print("Main-> ");
         String command = input.nextLine();
         command = command.trim();
         if(command.equals("exit")){
             break;
         }
         commandLine(manager,command);

        }
          

    }
    
    private static void commandLine(TaskManager manager, String command){
        Scanner input = new Scanner(System.in);
        if(command.isEmpty())return;

     
            switch(command){
                
               case "en": 
                   //Enter Task
                System.out.print("Enter task: ");
                String task = input.nextLine();
                task = task.trim();
                manager.addTask(task);
                System.out.println("Total Tasks : "+manager.getTask().size());
                System.out.println("Task added Successfully");
                

                   break;
               case "dl":
                   //Delete Task:
             
                   
                   if(manager.getTask().size()>0){

                       System.out.print("Task no: ");
                       try{
                       int id = input.nextInt();
                       manager.removeTask(id); //Index Adjusted in TaskManager
                       System.out.println("Task"+"["+id+"]"+" has been deleted");
                       }catch(Exception e){
                           System.out.println("Input not valid");
                       }
                   }
                   
                   
                   break;


               case "rn": 
                //rename task;
                if(manager.getTask().size()>0){

                System.out.print("Task no.: ");
                try{
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Rename: ");
                    String renamedTask = input.nextLine();
                    manager.getTask().get(id-1).setTitle(renamedTask);
                    System.out.println("Task "+id+" has been successfully renamed");
                    }catch(Exception e){
                      System.out.println("Invalid not valid");
                    }
                }

                break;

               case "sts":
                   //Status Update
                   if(manager.getTask().size()>0){

                     System.out.print("Task no: ");
                     int id = input.nextInt();
                     input.nextLine(); //Consumes the leftover newline

                     Task selectedTask = manager.getTask().get(id-1);

                     System.out.print("Completed? [y/n] : ");
                     String res = input.nextLine();
                     do{
                         if(res.equals("y")){
                             selectedTask.setCompleted(true);
                         }else if(res.equals("n")){
                             selectedTask.setCompleted(false);
                         }
                       
                     }while(!res.equals("y") && !res.equals("n"));
                   
                     System.out.println("Status Updated");
                   }
                
                   break;



               case "ptc":
                   //Print completed task
                   manager.printComplete();
                   break;
               case "ptp":
                   //print Pending task;
                   manager.printPending();
                   break;
               case "pt":
                   //print all Task
                   manager.printAll();
                   break;
               default: 
                    System.out.println("Invalid Command");
 
             }   

    }
    
    
}
