import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для работы с файлами (сохранение результатов)
 */
public class FileManager {

    /**
     * Сохраняет очередь из итератора в файл
     * @throws Exception если произошла ошибка при сохранении
     */
    public void saveQueueToFile(RealNumberIterator iterator, String filename) throws Exception {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Результат циклического сдвига очереди:\n");
            iterator.writeQueueToFile(writer);
        } catch (IOException e) {
            throw QueueException.createFileSaveException(filename, e);
        }
    }
}