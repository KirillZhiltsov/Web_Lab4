import java.util.*;

/**
 * Класс для работы с вещественными числами
 */
public class RealNumber {
    /** Значение вещественного числа */
    private double value;

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
    }

    public static boolean checkIsEmpty(){
        return numbers.isEmpty();
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
            Iterator<RealNumber> iterator = new QueueRealNumberIterator(numbers);
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
     * Метод выполняет циклическийц сдвиг влево
     * @return Строка о результате работы
     */
    public static String CyclicShiftLeft(){
        StringBuilder result = new StringBuilder();
        if(numbers.isEmpty()){
            result.append("Сдвиг невозможен. Очередь пустая");
        } else {
            while(numbers.peek().value != QueueRealNumberIterator.maxElement(numbers).value){
                numbers.add(numbers.poll());
            }
            result.append("Сдвиг влево завершён");
        }
        return String.valueOf(result);
    }

    /**
     * Метод выполняет циклическийц сдвиг вправо
     * @return Строка о результате работы
     */
    public static String CyclicShiftRight(){
        StringBuilder result = new StringBuilder();
        if(numbers.isEmpty()){
            result.append("Сдвиг невозможен. Очередь пустая");
        } else {
            while (numbers.peek().value != QueueRealNumberIterator.maxElement(numbers).value){
                Iterator<RealNumber> iterator = new QueueRealNumberIterator(numbers);
                ArrayList<RealNumber> temp =  new ArrayList<>();
                while(iterator.hasNext()){
                    RealNumber num = iterator.next();
                    temp.add(num);
                }
                numbers.clear();
                numbers.add(temp.get(temp.size()-1));
                for(int i = 0; i < temp.size()-1; ++i){
                    numbers.add(temp.get(i));
                }
            }
            result.append("Сдвиг выполнен");
        }
        return String.valueOf(result);
    }

    /**
     * Метод отчищает очередь
     */
    public static String clear(){
        if(numbers.isEmpty()){
            return "Очередь пустая";
        } else{
            numbers.clear();
            return "Очередь отчищена";
        }
    }

    /**
     * Метод возвращает длину очереди
     * @return длина очереди
     */
    public static int getLength(){
        return QueueRealNumberIterator.getSize();
    }


    /**
     * Метод выделяет память под итератор
     */
    public static void createIter(){
        Iterator<RealNumber> iterator = new QueueRealNumberIterator(numbers);
    }
}