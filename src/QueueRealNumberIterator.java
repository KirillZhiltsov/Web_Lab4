import java.util.*;

public class QueueRealNumberIterator implements Iterator<RealNumber> {
    private final Queue<RealNumber> numbers;
    private final Iterator<RealNumber> internalIterator;

    /**
     * Конструктор с параметрами
     * @param numbers Коллекция RealNumber
     */
    public QueueRealNumberIterator(Queue<RealNumber> numbers) {
        this.numbers = numbers;
        this.internalIterator = numbers.iterator();
    }

    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }

    @Override
    public RealNumber next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элементы в очереди закончились");
        }
        return internalIterator.next();
    }
}
