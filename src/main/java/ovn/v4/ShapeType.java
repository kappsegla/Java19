package ovn.v4;

//Enum constants are implicitly static and final and you can not change their value once created. Enum in Java provides type-safety and can be used inside switch statement like int variables.
//Since enum is a keyword you can not use as a variable name and since its only introduced in JDK 1.5 all your previous code which has an enum as a variable name will not work and needs to be refactored.
//https://www.baeldung.com/java-enum-values
public enum ShapeType {
    RECTANGLE,
    ELLIPSE,
    RESIZABLE_RECTANGLE
}
