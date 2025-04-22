public class Printer{
    
    


    public static void printHeader(){
        System.out.println("

888       888          888                                              888                 88888888888              8888888b.           
888   o   888          888                                              888                     888                  888  "Y88b          
888  d8b  888          888                                              888                     888                  888    888          
888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.       888888 .d88b.           888   .d88b.         888    888  .d88b.  
888d88888b888 d8P  Y8b 888 d88P"   d88""88b 888 "888 "88b d8P  Y8b      888   d88""88b          888  d88""88b        888    888 d88""88b 
88888P Y88888 88888888 888 888     888  888 888  888  888 88888888      888   888  888          888  888  888 888888 888    888 888  888 
8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.          Y88b. Y88..88P          888  Y88..88P        888  .d88P Y88..88P 
888P     Y888  "Y8888  888  "Y8888P "Y88P"  888  888  888  "Y8888        "Y888 "Y88P"           888   "Y88P"         8888888P"   "Y88P"");  
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
    }

    public static void printAll(int size, int taskId, String taskName, boolean status){
        
        System.out.printf("| %-7s | %-20s | %-12s |\n", "Task ID", "Task Name", "Status");
        System.out.println("|---------|----------------------|--------------|");

        for(int i = 0; i<size; i++){
            if(status){
               System.out.printf("| %-7d | %-20s | %-12s |\n", taskId, taskName, "Completed");
            }else{
               System.out.printf("| %-7d | %-20s | %-12s |\n", taskId, taskName, "Pending");
            }
        }
    
    }
}
