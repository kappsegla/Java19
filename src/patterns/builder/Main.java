package patterns.builder;

public class Main {
    public static void main(String[] args) {

        Test test = TestBuilder.getBuilder()
                .setText("Hello World")
                .setDefaultMale()   //We can create methods with side effects, changes several params
                .setName("Martin")
                .createTest();
        System.out.println(test);
    }
}
