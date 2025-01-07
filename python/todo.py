import os
 
# read tasks from the file
def read_tasks():
    if not os.path.exists("todo.txt"):
        return []
    
    with open("todo.txt", "r") as file:
        tasks = file.readlines()
    return [task.strip() for task in tasks]

# write tasks to the file
def write_tasks(tasks):
    with open("todo.txt", "w") as file:
        for task in tasks:
            file.write(task + "\n")

# add a task
def add_task(task):
    tasks = read_tasks()
    tasks.append(task)
    write_tasks(tasks)
    print("Task added!")

# remove a task
def remove_task(task_number):
    tasks = read_tasks()
    if 0 < task_number <= len(tasks):
        task = tasks.pop(task_number - 1)
        write_tasks(tasks)
        print(f"Task '{task}' removed!")
    else:
        print("Invalid task number!")

# view all tasks
def view_tasks():
    tasks = read_tasks()
    if tasks:
        print("\nYour To-Do List:")
        for i, task in enumerate(tasks, start=1):
            print(f"{i}. {task}")
    else:
        print("No tasks in the list!")

#  display the menu and handle user input
def main():
    while True:
        print("\nTo-Do List App")
        print("0. View tasks")
        print("1. Add a task")
        print("2. Remove a task")
        print("3. Exit")

        choice = input("Choose an option (0-3): ")

        if choice == "0":
            view_tasks()
        elif choice == "1":
            task = input("Enter the task: ")
            add_task(task)
        elif choice == "2":
            view_tasks()
            try:
                task_number = int(input("Enter the task number to remove: "))
                remove_task(task_number)
            except ValueError:
                print("Please enter a valid number.")
        elif choice == "3":
            print("Goodbye!")
            break
        else:
            print("Invalid choice, please try again.")

# Run the app
if __name__ == "__main__":
    main()
[]