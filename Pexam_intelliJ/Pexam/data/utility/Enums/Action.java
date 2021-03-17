package Pexam.data.utility.Enums;

public enum Action{
    FREE("Free Action"),
    STANDARD("Standard Action"),
    SWIFT("Swift Action"),
    SHIFT("Shift Action"),
    FULL("Full Action"),
    NON("");

    private final String name_;

    Action(String name){
        this.name_ = name;
    }
}