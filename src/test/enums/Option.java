package enums;

public enum Option {
    OPTION1("Option 1", "1"), OPTION2("Option 2", "2");

    private String name, value;

    Option(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
