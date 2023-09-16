package ToDoList;

import ToDoList.Enum.Priority;
import ToDoList.Enum.Status;
import ToDoList.Service.Impl.TaskServiceImpl;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Создаем список задач
        List<Task> tasks = new ArrayList<>();

        // Создаем сервис для работы с задачами
        TaskServiceImpl taskService = new TaskServiceImpl(tasks);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Изменить статус задачи");
            System.out.println("3. Изменить приоритет задачи");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Удалить все задачи с определенным статусом");
            System.out.println("6. Вывести все задачи");
            System.out.println("7. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Переводим сканер на следующую строку после считывания числа.

            switch (choice) {
                case 1:
                    System.out.println("Введите описание задачи:");
                    String description = scanner.nextLine();
                    System.out.println("Введите приоритет задачи (Низкий, Высокий, Средний, Критический):");
                    String priorityStr = scanner.nextLine();
                    Priority priority = Priority.fromString(priorityStr);
                    if (priority == null) {
                        System.out.println("Неверный приоритет.");
                        break;
                    }
                    System.out.println("Введите статус задачи (Запланирована, ПринятаКИсполнению, Выполнена, Отменена, НаКонтроле, Возвращена, Проконтролирована):");
                    String statusStr = scanner.nextLine();
                    Status status = Status.fromString(statusStr);
                    if (status == null) {
                        System.out.println("Неверный статус.");
                        break;
                    }

                    Task newTask = new Task(description, priority, status);
                    taskService.addNewTask(newTask);
                    break;
                case 2:
                    System.out.println("Введите описание задачи, чтобы изменить ее статус:");
                    String descriptionToChangeStatus = scanner.nextLine();
                    Task taskToChangeStatus = findTaskByDescription(descriptionToChangeStatus, tasks);

                    if (taskToChangeStatus == null) {
                        System.out.println("Задача не найдена.");
                        break;
                    }
                    taskService.changeTaskStatus(taskToChangeStatus);
                    break;
                case 3:
                    System.out.println("Введите описание задачи, чтобы изменить ее приоритет:");
                    String descriptionToChangePriority = scanner.nextLine();
                    Task taskToChangePriority = findTaskByDescription(descriptionToChangePriority, tasks);
                    if (taskToChangePriority == null) {
                        System.out.println("Задача не найдена.");
                        break;
                    }
                    taskService.changeTasksPriority(taskToChangePriority);
                    break;
                case 4:
                    System.out.println("Введите описание задачи, чтобы удалить ее:");
                    String descriptionToDelete = scanner.nextLine();
                    Task taskToDelete = findTaskByDescription(descriptionToDelete, tasks);
                    if (taskToDelete == null) {
                        System.out.println("Задача не найдена.");
                        break;
                    }
                    taskService.deleteTask(taskToDelete);
                    break;
                case 5:
                    System.out.println("Введите статус задач, которые нужно удалить (Запланирована, ПринятаКИсполнению, Выполнена, Отменена, НаКонтроле, Возвращена, Проконтролирована):");
                    String statusToDeleteStr = scanner.nextLine();
                    Status statusToDelete = Status.fromString(statusToDeleteStr);
                    if (statusToDelete == null) {
                        System.out.println("Неверный статус.");
                        break;
                    }
                    taskService.deleteAllTasksByStatus(statusToDelete);
                    break;
                case 6:
                    System.out.println("Все задачи:");
                    taskService.getAll();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    // Метод для поиска задачи по описанию
    private static Task findTaskByDescription(String description, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                return task;
            }
        }
        return null;
    }
}


