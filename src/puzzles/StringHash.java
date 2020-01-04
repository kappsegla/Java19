package puzzles;

import javax.annotation.WillClose;

public class StringHash {

    public static void main(String[] args) {

        //0 hashCode strings can be combined together...
        //Will it break the caching of hashCode method also?
        System.out.println("\u0001!qbygvW".hashCode());
        System.out.println("9 $Ql(0".hashCode());
        System.out.println(" #t(}lrl".hashCode());
        System.out.println(" !!#jbw}a".hashCode());
        System.out.println(" !!#jbw|||".hashCode());
        System.out.println(" !!!!Se|aaJ".hashCode());
        System.out.println(" !!!!\"xurlls".hashCode());
        System.out.println("ARbyguv".hashCode());
        System.out.println("XwgBbSk".hashCode());
        System.out.println("zsjpyCI".hashCode());
        System.out.println("XwgBbSkzsjpyCIzsjpyCI".hashCode());

        System.out.println("ARbyguv".hashCode());
        System.out.println("ARbyguv".hashCode());
        System.out.println("ARbyguv".hashCode());

    }
}
