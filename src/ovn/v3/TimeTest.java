package ovn.v3;

public class TimeTest {

    public static void main(String[] args) {
        Time time = new Time(12);
        Time copyofTime = new Time(time);
        Time time1 = time;
        int i = time.compareTo(copyofTime);


    }


}
