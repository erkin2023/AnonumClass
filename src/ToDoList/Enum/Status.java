package ToDoList.Enum;

public enum Status {
    Запланирована,
    ПринятаКИсполнению,
    Выполнена,
    Отменена,
    НаКонтроле,
    Возвращена,
    Проконтролирована;
    public static Status fromString(String genderStr) {
        switch (genderStr.toLowerCase()) {
            case "запланирована":
                return Запланирована;
            case "принятакисполнению":
                return ПринятаКИсполнению;
            case "выполнена":
                return Выполнена;
            case "отменена":
                return Отменена;
            case "наконтроле":
                return НаКонтроле;
            case "возвращена":
                return Возвращена;
            case "проконтролирована":
                return Проконтролирована;
            default:
                return null;
        }
    }

}
