import java.security.DigestException;
import java.util.Arrays;

public class StringTest {


    public static void main(String[] args) {
//        String s = "Martin";
//        String s1 = "Martin";
//        String s2 = new String("Martin");
//        String s3 = new String("Martin").intern();
//
//        System.out.println( s == s1 );
//        System.out.println( s == s2 );
//        System.out.println( s == s3 );

        String a = "Hej";
        String b = "Då";
        String c = "1,2,3,4";

        String[] strings =  c.split(",");

        System.out.println(strings.length);
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);

        System.out.println(String.join(":", Arrays.copyOfRange(strings,1,3)));

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            sb.append(i).append(" ");
//        }
//        System.out.println(sb.toString());

    }

}
