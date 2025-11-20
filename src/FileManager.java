import java.io.*;


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
}