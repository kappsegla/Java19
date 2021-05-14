package functional;

public class Functional {


    public static void main(String[] args) {
        new Functional().run();
    }

    public void run(){
        
    }

    void lambdaTest() {
        testNPE(null);
    }

    private static void testNPE(String s) {
//invocation target of a method reference is evaluated when its declaration is first encountered
//        Thread t = new Thread(() -> s.toLowerCase());
        Thread t = new Thread(s::toLowerCase);
        t.setUncaughtExceptionHandler((t1, e) -> System.out.println("Exception!"));
        t.start();
    }
}
