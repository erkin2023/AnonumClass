package ToDoList.Enum;

public enum Priority {
    Низкий,
    Высокий,
    Средний,
    Критический;
    public static Priority fromString(String genderStr) {
        String lowerCaseStr = genderStr.toLowerCase();
        switch (lowerCaseStr) {
            case "низкий":
                return Низкий;
            case "высокий":
                return Высокий;
            case "средний":
                return Средний;
            case "критический":
                return Критический;
            default:
                return null;
        }
    }
}
