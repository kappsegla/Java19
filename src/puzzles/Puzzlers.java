package puzzles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://www.youtube.com/watch?v=NG-27PnRcTc

public class Puzzlers {


    // Runnable or Callable Interface?  write casts Exception so Callable will be used
    // Will second submit compile?, without return.
    void killAll() {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        List<String> sentence = Arrays.asList("Punish");
        ex.submit(() -> Files.write(Paths.get("Sentence.txt"), sentence)); //Implicit return
        //ex.submit(()-> { Files.write(Paths.get("Sentence.txt"),sentence); }); //Explicit return
        ex.submit(() -> {
            return Files.write(Paths.get("Sentence.txt"), sentence);
        }); //Explicit return
    }


    //ConcurrentModificationException, ArrayIndexOutOfBoundsException,Y - NullPointerException,No exception
    //Removing elements add null to the end of the array.
    //[Arnie,Chuck,Slay]-> [Arnie,Slay,null]
    //forEach -> spliterator().forEachRemaining() checks for mod count once, in the end.
    //Use list.removeIf("Chuck"::equals);
    void chuck() {
        List<String> list = new ArrayList<>(Arrays.asList("Arnie", "Chuck", "Slay"));
        list.stream().forEach(x -> {
            if (x.equals("Chuck")) {
                list.remove(x);
            }
        });
        //list.removeIf("Chuck"::equals);
    }

    //You killed them all, you killed only even ones, they all survive, only odd ones are removed,all answers are correct
    //All answers are correct, depends on the implementation of the collection.
    //Don't do that.
    //Testrun with arraylist, linkedlist
    void killThemAll(Collection<String> expendables) {
        Iterator<String> heroes = expendables.iterator();
        heroes.forEachRemaining(e -> {                  //Iterating on an iterator. :( Gets two steps each time but not for all implementations
                    if (heroes.hasNext()) {
                        heroes.next();
                        heroes.remove();
                    }
                }
        );
        System.out.println(expendables);
    }

    //null, 42, won't compile, NullPointerException
    //Java language specification 15.25
    //int and null... -> Integer
    //First int and Integer... -> int. Null pointer exception
    void ultimateQuestion(){
        boolean ultimate = false;
        System.out.println(ultimate ? 42 : ultimate ? 42: null);
    }


    public static void main(String[] args) {
        new Puzzlers().ultimateQuestion();

        //new Puzzlers().chuck();

//        new Puzzlers().killThemAll(new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G")));
//        //LinkedList gives nullpointer exception?
// //       new Puzzlers().killThemAll(new LinkedList<>(Arrays.asList("A","B","C","D","E","F","G")));
//        new Puzzlers().killThemAll(new ArrayDeque<>(Arrays.asList("A","B","C","D","E","F","G")));
//        new Puzzlers().killThemAll(new TreeSet<>(Arrays.asList("A","B","C","D","E","F","G")));
    }
}