import java.util.*;

/**
 * Класс-итератор для работы с очередью вещественных чисел
 */
public class QueueRealNumberIterator implements Iterator<RealNumber> {

    /**
     * Очередь, содержащая объекты вещественных чисел
     */
    private static Queue<RealNumber> numbers;

    /**
     * Внутренний итератор для перебора элементов очереди
     */
    private final Iterator<RealNumber> internalIterator;

    private static int size;

    public QueueRealNumberIterator(){
        numbers = null;
        this.internalIterator = numbers.iterator();
        size = 0;
    }

    /**
     * Конструктор класса QueueRealNumberIterator
     *
     * @param number очередь, содержащая объекты типа RealNumber
     * @throws NullPointerException если переданная очередь равна null
     */
    public QueueRealNumberIterator(Queue<RealNumber> number) {
        numbers = number;
        this.internalIterator = numbers.iterator();
        QueueRealNumberIterator.setSize();
    }

    /**
     * Проверяет наличие следующего элемента в очереди
     *
     * @return true, если есть следующий элемент, иначе false
     */
    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }

    /**
     * Возвращает следующий элемент из очереди
     *
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

    /**
     * Находит максимальный элемент в очереди
     * @return максимальный элемент
     */
    public static RealNumber maxElement(Queue<RealNumber> numbers) {
        RealNumber Max = new RealNumber(Double.MIN_VALUE);
        Iterator<RealNumber> iterator = new QueueRealNumberIterator(numbers);
        while (iterator.hasNext()) {
            RealNumber num = iterator.next();
            if (Max.getValue() < num.getValue()) Max = num;
        }
        return Max;
    }

    /**
     * Сеттер Size
     */
    public static void setSize() {
        size = numbers.size();
    }

    /**
     * Геттер Size
     * @return size
     */
    public static int getSize(){
        RealNumber.createIter();
        return size;
    }
}