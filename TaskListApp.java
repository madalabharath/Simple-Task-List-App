package Basic_Project;

import java.util.ArrayList;
import java.util.*;

public class TaskListApp {
    private ArrayList <Task> tasks;
    private Scanner sc;

    public TaskListApp() {
        tasks = new ArrayList<>();
        sc = new Scanner (System.in);
    }

   

    public void run() {
        while (true) {
            showMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    listTasks();
                    break;
                case "4":
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Task List View:");
        System.out.println("1. Add a Task");
        System.out.println("2. Remove a Task");
        System.out.println("3. List the Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your Option: ");
    }

    private void addTask() {
        System.out.print("Enter the task : ");
        String description = sc.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task Added.");
    }

    private void removeTask() {
        System.out.print("Enter task number to remove: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(sc.nextLine());
            if (taskNumber < 1 || taskNumber > tasks.size()) {
                System.out.println("Invalid Task Number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task Removed.");
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

        public static void main(String[] args) {
             TaskListApp app = new TaskListApp();
                 app.run();
               }

}