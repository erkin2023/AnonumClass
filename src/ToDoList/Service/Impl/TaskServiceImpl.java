package ToDoList.Service.Impl;

import ToDoList.Enum.Priority;
import ToDoList.Enum.Status;
import ToDoList.Service.TaskInterface;
import ToDoList.Task;
import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TaskServiceImpl implements TaskInterface, Comparable {
    List<Task> tasks;


    public TaskServiceImpl(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public Task addNewTask(Task task) {
        System.out.println("Задача добавлено ! " + tasks.add(task));
        return task;
    }

    @Override
    public List<Status> getAllTaskStatus() {
        for (Task s : tasks) {
                System.out.println(s.getDescription() + "\n" + s.getStatus() + "\n" + s.getPriority());

        }
        return null;
    }

    @Override
    public String changeTaskStatus(Task task) {
        Scanner scanner = new Scanner(System.in);
        for (Task t : tasks) {
            if (t.equals(task)) {
                System.out.println("Напишите статус : ");
                System.out.println("Запланирована\n" +
                        "    ПринятаКИсполнению\n" +
                        "    Выполнена\n" +
                        "    Отменена\n" +
                        "    НаКонтроле\n" +
                        "    Возвращена\n" +
                        "    Проконтролирована: ");
                String statusSInput = scanner.next();
                Status gens = Status.fromString(statusSInput);
                if (gens != null) {
                    t.setStatus(gens);
                    System.out.println("Успешно измен статус на "+ gens);
                }
            }

        }return null;
    }

        @Override
        public String changeTasksPriority (Task task) {
            Scanner scanner = new Scanner(System.in);
            for (Task t : tasks) {
                if (t.equals(task)) {
                    System.out.println("Напишите Приоритет : ");
                    System.out.println(" Низкий,\n" +
                            "    Высокий,\n" +
                            "    Средний,\n" +
                            "    Критический;");
                    String prioritySInput = scanner.next();
                    Priority gens = Priority.fromString(prioritySInput);
                    if (gens != null) {
                        t.setPriority(gens);
                        System.out.println("Успешно изменен приоритет "+gens);
                    }
                }
            }
            return null;
        }


        @Override
        public void deleteTask (Task task) {
        Iterator<Task>iterator = tasks.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(task)){
                iterator.remove();
                System.out.println("Задача успено удалено "+task);
            }
        }
        }

        @Override
        public void deleteAllTasksByStatus (Status status) {
        for(Task t: tasks){
            if(t.getStatus().equals(status)){
                tasks.remove(t);
                System.out.println("Deleted all task by status ");
            }
        }
        }

        @Override
        public List<Task> sortByStatus (Status o,Status o2) {
            System.out.println(o.compareTo(o2));
            return null;
        }

        @Override
        public List<Task> sortByPriority (Priority o, Priority o2) {
            System.out.println(o.compareTo(o2));
            return null;
        }

        @Override
        public List<Task> getAll () {
        for (Task t:tasks){
            System.out.println(t);
        }
            return null;
        }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}