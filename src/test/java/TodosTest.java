import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask}; // Ожидается пустой массив, так как нет совпадений по поисковому запросу
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnForEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic}; // Ожидается пустой массив, так как нет совпадений по поисковому запросу
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnForMeeting() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnForEmptyArray() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {}; // Ожидается пустой массив, так как нет совпадений по поисковому запросу
        Task[] actual = todos.search("Великие планы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmptySearch() {
        Todos todos = new Todos();
        Task task = new Task(555);
        todos.add(task);

        Task[] expected = {};
        Task[] actual = todos.search("любой запрос");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnsStringMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("3й версии");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Молоко");
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtask);

        Meeting meeting1 = new Meeting(555, "Молоко", "Приложение НетоБанка", "Во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting1);

        Task[] expected = {simpleTask, epic, meeting1};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }
}


