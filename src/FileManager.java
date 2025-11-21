import java.io.*;
import java.util.Queue;


/**
 * Класс работы с файлами
 */
public class FileManager {

    /**
     * Метод создаёт файл
     * @param name Название файла
     * @return Строка состояния
     * @throws IOException ошибка при создании файла
     */
    public static String createFile(String name) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = new File(name);
        if(file.createNewFile()){
            result.append("Файл <").append(name).append("> создан");
        } else{
            result.append("Файл c таким названеим уже существует");
        }
        return String.valueOf(result);
    }

    /**
     * Метод удаляет файл
     * @param name название файла
     * @return Строка состояния
     */
    public static String deleteFile(String name){
        StringBuilder result = new StringBuilder();

        File file = new File(name);
        if (!file.exists()) {
            result.append("Файл не существует: ").append(name);
    } else {
            boolean deleted = file.delete();
            if(deleted) {
                result.append("Файл <").append(name).append("> успешно удалён");
            } else {
                result.append("Не удалось удалить файл");
            }
        }
        return String.valueOf(result);
    }

    /**
     * Метод добавляет строку в файл
     * @param info строка
     * @param name название файла
     * @return Строка состояния
     * @throws IOException исключение сохранения
     */
    public static String addToFile(String info, String name) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = new File(name);
        if (!file.exists()) {
            result.append("Файл не существует: ").append(name);
    }   else if(!file.isFile()){
            result.append(name).append(" не является файлом");
        } else if(!file.canWrite()){
            result.append("Запись в файл недоступна: ").append(name);
        } else if(!file.canRead()){
            result.append("Чтение из файла недоступно: ").append(name);
        } else{
            FileWriter writer = new FileWriter(file, true);
            writer.write("\n"+ "=====Результат=====" + "\n");
            writer.write(info + "\n");
            writer.write("-------------------" + "\n");
            writer.flush();
            result.append("Запись завершена");
        }
    return String.valueOf(result);
    }
}