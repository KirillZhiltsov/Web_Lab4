import java.util.*;

/**
 * Класс-итератор для работы с очередью вещественных чисел
 */
public class QueueRealNumberIterator implements Iterator<RealNumber> {

    /**
     * Очередь, содержащая объекты вещественных чисел
     */
    private final Queue<RealNumber> numbers;

    /**
     * Внутренний итератор для перебора элементов очереди
     */
    private final Iterator<RealNumber> internalIterator;

    /**
     * Конструктор класса QueueRealNumberIterator
     * @param numbers очередь, содержащая объекты типа RealNumber
     * @throws NullPointerException если переданная очередь равна null
     */
    public QueueRealNumberIterator(Queue<RealNumber> numbers) {
        this.numbers = numbers;
        this.internalIterator = numbers.iterator();
    }

    /**
     * Проверяет наличие следующего элемента в очереди
     * @return true, если есть следующий элемент, иначе false
     */
    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }

    /**
     * Возвращает следующий элемент из очереди
     * @return объект типа RealNumber
     * @throws NoSuchElementException если элементы в очереди закончились
     */
    @Override
    public RealNumber next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Элементы в очереди закончились");
        }
        return internalIterator.next();
    }
}