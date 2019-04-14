package ch09.collection;

import java.util.Collection;

public class GenericCollectionMethod {

    public static <E> boolean contains(Collection<E> c, Object o) {
        for( E element: c) {
            if(element.equals(o)) {
                return true;
            }
        }
        return false;
    }
}
