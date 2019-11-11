package repetition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rep {

    final int value = 0;

    public static void main(String[] args) {
        System.out.println("hej");
        Rep rep  = new Rep();
    }

    public int test(int b){
        return b;
    }
    public int test(int b,int a){
        return b;
    }
}


interface LandBound {
    int numberOfLegs();
}
interface Journey {
    int numberOfLegs();
}
class SDSKDFKSD implements Journey{

    Horse horse;
    int legs;

    public SDSKDFKSD(){
        horse = new Horse();
    }

    public SDSKDFKSD(Horse horse, int legs){
        this.horse = horse;
        this.legs = legs;
    }

    @Override
    public int numberOfLegs() {
        return legs;
    }
}

class Horse implements LandBound {
    @Override
    public int numberOfLegs() {
        return 4;
    }
}


