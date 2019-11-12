package patterns.builder;

public class Test {
    private String text;
    private int id = 0;
    private int phone;
    private int houseNumber;
    private String name;
    private String city;

    public Test(String text, int id, int phone, int houseNumber, String name, String city) {
        this.text = text;
        this.id = id;
        this.phone = phone;
        this.houseNumber = houseNumber;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Test{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", phone=" + phone +
                ", houseNumber=" + houseNumber +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
