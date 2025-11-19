import java.io.FileWriter;
import java.util.Iterator;
import java.util.Queue;

/**
 * Итератор для работы с коллекцией вещественных чисел
 * Работает со статической очередью из класса RealNumber
 */
public class RealNumberIterator implements Iterator<RealNumber> {
    /** Внутренний итератор для обхода очереди */
    private Iterator<RealNumber> iterator;

    /**
     * Конструктор по умолчанию
     * Инициализирует итератор статической очередью из класса RealNumber
     */
    public RealNumberIterator() {
        // Используем статическую очередь из RealNumber
        this.iterator = RealNumber.getQueue().iterator();
    }

    /**
     * Добавляет число в статическую очередь
     * @param number вещественное число для добавления в очередь
     */
    public void addNumber(double number) {
        RealNumber.addToQueue(number);
        // Обновляем итератор после добавления элемента
        this.iterator = RealNumber.getQueue().iterator();
    }

    /**
     * Проверяет наличие следующего элемента в очереди
     * @return true если в очереди есть следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Возвращает следующий элемент из очереди
     * @return следующий элемент типа RealNumber
     * @throws java.util.NoSuchElementException если в очереди больше нет элементов
     */
    @Override
    public RealNumber next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("В коллекции больше нет элементов");
        }
        return iterator.next();
    }

    /**
     * Удаляет текущий элемент из очереди
     */
    @Override
    public void remove() {
        iterator.remove();
    }

    /**
     * Находит максимальный элемент в очереди
     * @return максимальный элемент очереди
     * @throws Exception если очередь пуста
     */
    public RealNumber findMaxElement() throws Exception {
        Queue<RealNumber> queue = RealNumber.getQueue();
        QueueException.checkNotEmptyForMax(queue);

        RealNumber max = queue.peek();
        Iterator<RealNumber> tempIterator = queue.iterator();

        while (tempIterator.hasNext()) {
            RealNumber current = tempIterator.next();
            if (current.getValue() > max.getValue()) {
                max = current;
            }
        }

        return max;
    }

    /**
     * Выполняет циклический сдвиг очереди так, чтобы максимальный элемент был в начале
     * @throws Exception если очередь пуста
     */
    public void cyclicShiftToMax() throws Exception {
        Queue<RealNumber> queue = RealNumber.getQueue();
        QueueException.checkNotEmptyForShift(queue);

        RealNumber maxElement = findMaxElement();

        while (!queue.peek().equals(maxElement)) {
            RealNumber element = queue.poll();
            queue.add(element);
        }
        // Обновляем итератор после изменения очереди
        this.iterator = queue.iterator();
    }

    /**
     * Выводит очередь с позициями в консоль
     * @throws Exception если очередь пуста
     */
    public void printQueueWithPositions() throws Exception {
        Queue<RealNumber> queue = RealNumber.getQueue();
        QueueException.checkNotEmptyForPrint(queue);

        int position = 1;
        Iterator<RealNumber> tempIterator = queue.iterator();
        while (tempIterator.hasNext()) {
            System.out.println(position + ": " + tempIterator.next().getValue());
            position++;
        }
    }

    /**
     * Записывает очередь в FileWriter
     * @param writer FileWriter для записи данных
     * @throws Exception если очередь пуста или ошибка записи
     */
    public void writeQueueToFile(FileWriter writer) throws Exception {
        Queue<RealNumber> queue = RealNumber.getQueue();
        QueueException.checkNotEmptyForFile(queue);

        int position = 1;
        Iterator<RealNumber> tempIterator = queue.iterator();
        while (tempIterator.hasNext()) {
            writer.write(position + ": " + tempIterator.next().getValue() + "\n");
            position++;
        }
    }

    /**
     * Проверяет, пуста ли очередь
     * @return true если очередь пуста, false в противном случае
     */
    public boolean isEmpty() {
        return RealNumber.isQueueEmpty();
    }

}