package ovn.v3;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeTest {

    public static void main(String[] args) {
        Time time = new Time(2,10,0);
        Time copyofTime = new Time(time);
        Time time1 = time;
        Time time2 = new Time(12,0,10);
        //System.out.println( time2.compareTo(time) );

        Time[] times = {new Time(20),
                new Time(2, 15),
                new Time(2),
                new Time(1)};
        System.out.println(times[0]);

        Arrays.sort(times);

        System.out.println(times[0]);
//        String s = "Kalle";
//        String s1 = "Pelle";
//        int i1 = s.compareTo(s1);
    }


}
