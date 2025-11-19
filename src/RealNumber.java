import java.util.*;

/**
 * Класс для работы с вещественными числами
 */
public class RealNumber implements Iterable<RealNumber>, Comparable<RealNumber>{
    /** Значение вещественного числа */
    private double value;
    /**
     * Вещественное число по счёту в очереди
     */
    private static int CountNumber = 0;
    /**
     * Очередь вещественных чисел
     */
    private static final Queue<RealNumber> numbers = new LinkedList<>();

    /**
     * Конструктор по умолчанию
     * Инициализирует число значением 0
     */
    public RealNumber(){
        this.value = 0;
        CountNumber = 0;
    }

    /**
     * Конструктор с параметрами
     * @param value Действительное число
     */
    public RealNumber(double value) {
        setValue(value);
    }

    /**
     * Геттер для получения значения числа
     * @return Вещественное число
     */
    public double getValue() {
        return value;
    }

    /**
     * Сеттер для установки значения числа
     * @param value Вещественное число
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Добавить число в очередь
     * Создает новый объект RealNumber и добавляет его в статическую очередь
     * @param number вещественное число
     */
    public static void addToQueue(double number) {
        numbers.add(new RealNumber(number));
    }

    /**
     * Метод выводит очередь
     * @return очередь в строке
     */
    public static String printQueue() {
        StringBuilder result = new StringBuilder();

        if (numbers.isEmpty()) {
            result.append("Очередь пустая");
        } else {
            Iterator<RealNumber> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                RealNumber num = iterator.next();
                result.append(num.getValue());
                if (iterator.hasNext()) {
                    result.append(" -> ");
                }
            }
        }
        return result.toString();
    }

    /**
     * Получить очередь
     * @return очередь вещественных чисел
     */
    public static Queue<RealNumber> getNumbers() {
        return numbers;
    }

    /**
     * Cеттер countNumber
     */
    public static void setCountNumber(int i) {
        CountNumber += i;
    }

    /**
     * Получить по счёту в очереди
     * @return Вещественное число по счёту в очереди
     */
    public static int getCountNumber() {
        return CountNumber;
    }

    /**
     * Проверить пустая ли очередь
     * @return true если очередь пуста, false в противном случае
     */
    public static boolean isQueueEmpty() {
        return numbers.isEmpty();
    }

    /**
     * Строковое представление объекта
     * @return строковое представление вещественного числа
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Сравнение объектов на равенство
     * @param obj объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RealNumber that = (RealNumber) obj;
        return Double.compare(that.value, value) == 0;
    }

    /**
     * Вычисление хэш-кода объекта
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public int compareTo(RealNumber o) {
        return 0;
    }

    // В классе RealNumber меняем реализацию метода iterator()
    @Override
    public Iterator<RealNumber> iterator() {
        return new QueueRealNumberIterator(numbers);
    }

    public static Iterator<RealNumber> getIterator() {
        return new QueueRealNumberIterator(numbers);
    }

}