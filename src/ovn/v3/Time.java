package ovn.v3;

public class Time implements Comparable {

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

    @Override
    public String toString() {
        return "Time: " + hour + ":" + min + ":" + sec;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o)
            return 0;

        Time other = (Time) o;

        if (this.hour == other.hour &&
                this.min == other.min &&
                this.sec == other.sec)
            return 0;

        int i = this.hour * 10000 + this.min * 100 + this.sec;
        int k = other.hour * 10000 + other.min * 100 + other.sec;

        if (i > k)
            return 1;

        return -1;
    }
}
