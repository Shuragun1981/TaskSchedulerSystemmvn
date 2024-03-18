public class Meeting extends Task {
    private String topic;
    private String project;
    private String dateTime;

    public Meeting(int id, String topic, String project, String dateTime) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project;
        this.dateTime = dateTime;
    }
    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}

