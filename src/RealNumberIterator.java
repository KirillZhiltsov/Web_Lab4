import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RealNumberIterator implements Iterator<RealNumber> {

    /**
     * Коллекция RealNumber
     */
    private final ArrayList<RealNumber> numbers;

    /**
     * Индекс элемента, на который указывает итератор
     */
    private int currentPosition;

    /**
     * Конструктор по умолчанию
     */
    public RealNumberIterator(){
        this.numbers = new ArrayList<>();
        this.currentPosition = 0;
    }

    /**
     * Конструктор по умолчанию
     * @param numbers Коллекция
     */
    public RealNumberIterator(ArrayList<RealNumber> numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
        return currentPosition < numbers.size();
    }

    @Override
    public RealNumber next() {
        if(!hasNext()){
            throw new NoSuchElementException("Элементов в очереди больше нет!");
        }
        return numbers.get(currentPosition++);
    }
}