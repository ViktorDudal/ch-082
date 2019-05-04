package ua.softserve.ita.utility;

import javax.persistence.NoResultException;
import java.util.Optional;
import java.util.function.Supplier;

public class QueryUtility {

    private QueryUtility() {}

    public static <T> Optional<T> findOrEmpty(final Supplier<T> sup) {
        try {
            return Optional.ofNullable(sup.get());
        }catch (NoResultException ex) {
           ex.printStackTrace();
        }
        return Optional.empty();
    }
}
