package ovn.v3;

public class Time {

    private int hour;
    private int min;
    private int sec;

    //Constructor chaining, call a more advanced constructor

    public Time(int h) {
        this(h, 0);
    }

    public Time(int h, int m) {
        this(h, m, 0);
    }

    public Time(int h, int m, int s) {
        if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59)
            throw new IllegalArgumentException("Time: Bad value");

        hour = h;
        min = m;
        sec = s;
    }

    //Copy constructor
    public Time(Time t) {
        this(t.hour, t.min, t.sec);
    }

    public int compareTo(Time other) {
        if (this == other)
            return 0;

        if (this.hour == other.hour &&
                this.min == other.min &&
                this.sec == other.sec)
            return 0;

        


        return -1;


    }


}
