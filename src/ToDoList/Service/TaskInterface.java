package ToDoList.Service;

import ToDoList.Enum.Priority;
import ToDoList.Enum.Status;
import ToDoList.Task;

import java.util.List;

public interface TaskInterface {
    Task addNewTask(Task task);
    List<Status> getAllTaskStatus();
    String changeTaskStatus(Task task);
    String changeTasksPriority(Task task);
    void deleteTask(Task task);
    void deleteAllTasksByStatus(Status status);
    List<Task> sortByStatus(Status o,Status o2);
    List<Task> sortByPriority(Priority o, Priority o2);
    List<Task> getAll();
}
