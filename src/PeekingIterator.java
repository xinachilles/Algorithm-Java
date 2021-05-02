
import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // Avoid an exception being thrown in the constructor.
        iter = iterator;
        peek();
    }

    public Integer peek() {
        if (iter.hasNext()) {
            next = iter.next();
        }
        return next;
    }

    @Override
    public Integer next() {
        /* As per the Java Iterator specs, we should throw a NoSuchElementException
         * if the next element doesn't exist. */
        if (next == null) {
            throw new NoSuchElementException();
        }
        Integer toReturn = next;
        next = null;
        return toReturn;
    }

    @Override
    public boolean hasNext() {
        peek();
        return  next!=null;
    }
}