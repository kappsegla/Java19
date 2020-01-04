package puzzles;

public interface Single<T> {
    default void partyHard(String songName) {
        System.out.println(songName);
    }
    void partyHard(T songName);
    void drinkIn(T drinkName);
    void dringIn(String drinkName);
}


