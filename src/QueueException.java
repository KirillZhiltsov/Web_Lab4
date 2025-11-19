import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class QueueException {

    private QueueException() {}

    // Константы сообщений об ошибках
    private static final String EMPTY_QUEUE_MAX = "Очередь пуста, невозможно найти максимальный элемент";
    private static final String EMPTY_QUEUE_SHIFT = "Очередь пуста, невозможно выполнить циклический сдвиг";
    private static final String EMPTY_QUEUE_PRINT = "Очередь пуста, нечего выводить";
    private static final String EMPTY_QUEUE_FILE = "Очередь пуста, нечего записывать в файл";
    private  static final String REGEX1 = "[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?";

    private static final Pattern PATTERN1 = Pattern.compile(REGEX1);

    /**
     * Метод проверяет корректность ввода вещественного числа
     * @param number число в строковом виде
     * @return число типа double
     */
    public static double checkDouble(String number){
        Matcher matcher = PATTERN1.matcher(number);
        if(!matcher.matches()){
            throw new Error("Некорректный формат.");
        }
        return Double.parseDouble(number);
    }

    /**
     * Проверяет, что очередь не пуста для поиска максимального элемента
     * @throws IllegalStateException если очередь пуста
     */
    public static void checkNotEmptyForMax(Queue<RealNumber> queue) {
        if (queue == null || queue.isEmpty()) {
            throw new IllegalStateException(EMPTY_QUEUE_MAX);
        }
    }

    /**
     * Проверяет, что очередь не пуста для циклического сдвига
     * @throws IllegalStateException если очередь пуста
     */
    public static void checkNotEmptyForShift(Queue<RealNumber> queue) {
        if (queue == null || queue.isEmpty()) {
            throw new IllegalStateException(EMPTY_QUEUE_SHIFT);
        }
    }

    /**
     * Проверяет, что очередь не пуста для вывода
     * @throws IllegalStateException если очередь пуста
     */
    public static void checkNotEmptyForPrint(Queue<RealNumber> queue) {
        if (queue == null || queue.isEmpty()) {
            throw new IllegalStateException(EMPTY_QUEUE_PRINT);
        }
    }

    /**
     * Проверяет, что очередь не пуста для записи в файл
     * @throws IllegalStateException если очередь пуста
     */
    public static void checkNotEmptyForFile(Queue<RealNumber> queue) {
        if (queue == null || queue.isEmpty()) {
            throw new IllegalStateException(EMPTY_QUEUE_FILE);
        }
    }

    /**
     * Создает RuntimeException для ошибки сохранения файла
     */
    public static RuntimeException createFileSaveException(String filename, Throwable cause) {
        return new RuntimeException("Ошибка сохранения в файл: " + filename, cause);
    }

}