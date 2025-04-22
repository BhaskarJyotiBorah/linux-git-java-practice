# To-Do List Break-Down:




## Project Structure
    
      todo-backend/
        ├---Task.java 
        ├---TaskManager.java
        ├---Main.java
        ├---Readme.md
        └---data/
             └---tasks.txt

## Importance of Project BreakDown (Importance of each File):
      1. Task.java : The Blueprint Model that holds info like id, title, isCompleted.
      2. TaskManager.java : 
             1. This is the Brain(Controller).
             2. This task manages the list of tasks
             3. It is responsible for:
                    1. Adding tasks
                    2. Deleting tasks
                    3. Marking them as completed
                    4. Saving/loading from file
      3. Main.java:
             1. This is the main class with the main() method
             2. Starts the program
             3. Shows menu , keeps the program running
             4. Calls methods from TaskManager to actually perform actions
      4. tasks.txt :
             1. Stores the tasks persistently
             2. When we restart the app, TaskManager can read from this file and reload the tasks.
             3. Without this task would disappear everytime the app stops.

## How they work?
      
      1. User runs Main.java --> Shows Main menu
      2. Through main we access TaskManager which stores and manipulates tasks
      3. Tasks are custom data structure which contains Task-details, like id, title , completion status.
      4. Main.java -> TaskManager -> Task

## Features: 
      1. Added CommandLine method with custom commands.
      2. The Main will keep running until we exit using CommandLine commands
## Problems Faced:
      1. Created Manager inside CommandLine which is WRONG. This resulted in the creation of a New TaskManager( a list) and not 1 list Containing many task.
       Solution: Moved The TaskManager to the main method. And passed its instance to CommandLine.
       2. Did not use input.nextLine() right after first int input. This resulted in residual newline which interrupted the flow.
       3. Use of try catch to surround any InputMisMatchException
       4. Should Create a PrintClass + Color class for Advance Terminal display.


