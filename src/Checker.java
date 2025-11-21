import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Checker {

    private Checker() {}

    /**
     * Регулярное выражение для вещественного числа
     */
    private  static final String REGEX1 = "[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?";
    /**
     * Регулярное выражение для названия файла
     */
    private static final String  REGEX2 = "^[^\\\\/:*?\"\"<>|]+$";
    /**
     * Скомпелированное REGEX1
     */
    private static final Pattern PATTERN1 = Pattern.compile(REGEX1);
    /**
     * Скомпелированное REGEX2
     */
    private static final Pattern PATTERN2 = Pattern.compile(REGEX2);

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
     * Метод проверяет корректность ввода имя для файла
     * @param name Имя файла
     * @return имя типа String
     */
    public static String checkNameFile(String name){
        Matcher matcher = PATTERN2.matcher(name);
        if(!matcher.matches()){
            throw new Error("Недопустимые символы в имени файла");
        }
        return name;
    }

}