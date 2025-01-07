import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // getters & setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    // string representation of a task
    // might want to swap [Completed] : [Not Completed] to [C] : [NC] ... but that feels less readable
    @Override
    public String toString() {
        return (isCompleted ? "[Completed] " : "[Not Completed] ") + description;
    }
}

public class TodoApp {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TodoApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // add a task to the list
    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + description);
    }

    // remove a task by index
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task removed: "+ removedTask.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // mark task completed
    public void markCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed: " + tasks.get(index).getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i) + ". " + tasks.get(i));
            }
        }
    }

    // main menu
    public void showMenu() {
        while (true) {
            System.out.println("\nTo-Do List App");
            System.out.println("0. View tasks");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Exit");
            System.out.print("Choose an option (0-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            
            switch (choice) {
                case 0:
                    viewTasks();
                    break;
                case 1:
                    System.out.print("Enter the task description: ");
                    String description = scanner.nextLine();
                    addTask(description);
                    break;
                case 2:
                    viewTasks();
                    System.out.print("Enter the task number to remove: ");
                    int removeIndex = scanner.nextInt();
                    removeTask(removeIndex);
                    break;
                case 3:
                    viewTasks();
                    System.out.print("Enter the task number to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    markCompleted(completeIndex);
                    break;
                case 4:
                    System.out.println("deuces o7");
                    return; // exit the program here
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp();
        todoApp.showMenu();
    }
}
