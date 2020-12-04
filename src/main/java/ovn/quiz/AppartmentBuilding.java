package ovn.quiz;

public class AppartmentBuilding extends Building{

    //Overloading
    public static int build(int a){
        return a;
    }

    //Hiding
    public static int build(){
        return 1;
    }
}
