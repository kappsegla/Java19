package puzzles;

import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of equals method using Optional and stream methods on Optional
 */
public class OptionalForEquals {

    String name;
    int age;

    @Override
    public boolean equals(Object o) {
//        if( this == o)
//            return true;
       return Optional.ofNullable(o)
               .filter(that -> that instanceof OptionalForEquals)
               .map(that -> (OptionalForEquals) that)
               .filter(that -> Objects.equals(this.name, that.name))
               .filter(that -> Objects.equals(this.age, that.age))
               .isPresent();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        OptionalForEquals that = (OptionalForEquals) o;
//
//        if (age != that.age) return false;
//        return name != null ? name.equals(that.name) : that.name == null;
//    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
