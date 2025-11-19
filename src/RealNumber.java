import java.util.Queue;
import java.util.LinkedList;

/**
 * Кла для работы с вещественными числами
 */
public class RealNumber {
    /** Значение вещественного числа */
    private double value;
    /**
     * Вещественное число по счёту в очереди
     */
    private static int CountNumber = 0;
    /** Статическая очередь как поле класса */
    private static final Queue<RealNumber> queue = new LinkedList<>();

    /**
     * Конструктор по умолчанию
     * Инициализирует число значением 0
     */
    public RealNumber(){
        this.value = 0;
        CountNumber++;
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
     * Создае новый объект RealNumber и добавляет его в статическую очередь
     * @param number вещественное число
     */
    public static void addToQueue(double number) {
        queue.add(new RealNumber(number));
    }

    /**
     * Получить очередь
     * @return очередь вещественных чисел
     */
    public static Queue<RealNumber> getQueue() {
        return queue;
    }

    /**
     * Cеттер countNumber
     */
    public static void setCountNumber() { CountNumber++;}

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
        return queue.isEmpty();
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
}