package patterns.builder;

public class TestBuilder  implements TestName{
    private String text;
    private int id = 0;
    private int phone;
    private int houseNumber;
    private String name;
    private String city;

    public static TestName getBuilder() {
        return new TestBuilder();
    }

    public TestBuilder setDefaultMale(){
        this.name="Man";
        this.city="Göteborg";
        this.phone = 123;
        return this;
    }

    public TestBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public TestBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TestBuilder setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public TestBuilder setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public TestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TestBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Test createTest() {
        return new Test(text, id, phone, houseNumber, name, city);
    }
}