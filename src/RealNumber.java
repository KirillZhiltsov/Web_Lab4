import java.util.*;

/**
 * Класс для работы с вещественными числами
 */
public class RealNumber implements Iterable<RealNumber>{
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
     * Функция находит максимальное число в очереди
     * @return Максимальное число в очереди
     */
    private static double getMax(){
        double Max = Double.MIN_VALUE;
        Iterator<RealNumber> iterator = numbers.iterator();
        while (iterator.hasNext()){
            RealNumber num = iterator.next();
            if(num.value > Max){
                Max = num.value;
            }
        }
        return Max;
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
            while(numbers.peek().value != getMax()){
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
            while (numbers.peek().value != getMax()){
                Iterator<RealNumber> iterator = numbers.iterator();
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


    // В классе RealNumber меняем реализацию метода iterator()
    @Override
    public Iterator<RealNumber> iterator() {
        return new QueueRealNumberIterator(numbers);
    }
}