
import java.io.IOException;
import java.util.Scanner;
public class UI {
    /**
     * Объект класса Scanner для чтения ввода из консоли
     */
    Scanner in = new Scanner(System.in);

    /**
     * Метод запуска пользовательского интерфейса
     */
    public void run() {
        while (true) {
            System.out.println("========Меню========");
            System.out.println("Выберите команду:");
            System.out.println("1 -> Добавить в очередь числа");
            System.out.println("2 -> Вывести очередь");
            System.out.println("3 -> Выполнить сдвиг");
            System.out.println("4 -> Отчистить очередь");
            System.out.println("5 -> Создать файл");
            System.out.println("6 -> Сохранить очередь в файл");
            System.out.println("7 -> Вывести содержимое файла");
            System.out.println("8 -> Удалить файл");
            System.out.println("0 -> Завершить работу программы");
            System.out.print("Введите номер команды: ");

            String input = in.nextLine();
            System.out.println("------------------------------------");

            switch (input) {
                case "1" -> create();
                case "2" -> System.out.println(RealNumber.printQueue());
                case "3" -> CyclicShift();
                case "4" -> System.out.println(RealNumber.clear());
                case "5" -> System.out.println(createFile());
                case "6" -> System.out.println("6");
                case "7" -> System.out.println("7");
                case "8" -> System.out.println(deleteFile());
                case "0" -> {
                    System.out.println("Завершение");
                    return;
                }
                default -> System.out.println("Неверная команда. Повторите ввод");
            }
        }
    }

    /**
     * Метод записывает числа в очередь, пока два раза не введётся пустая строка
     */
    private void create() {
        try {
            System.out.println("Заполнение очереди....");
            int click = 0;
            while (true) {
                RealNumber.setCountNumber(1);
                System.out.print("Число " + RealNumber.getCountNumber() + ": ");
                String number = in.nextLine();
                if (number.isEmpty()) {
                    RealNumber.setCountNumber(-1);
                    click++;
                    if ((click == 1) && (RealNumber.isQueueEmpty())) {
                        System.out.println("Очередь не может быть пустой");
                        click = 0;
                        continue;
                    } else if (click == 2) {
                        System.out.println("Заполнение очереди завершено");
                        click = 0;
                        break;
                    }
                } else {
                    RealNumber.addToQueue(Checker.checkDouble(number));
                }
            }
        } catch (Error error) {
            System.out.println("Ошибка: " + error.getMessage());
        }
    }

    /**
     * Метод запускает интерфес для выбора типа цикличсекого сдвига
     */
    private void CyclicShift() {
        while (true) {
            System.out.println("=====Меню сдвига=====");
            System.out.println("1 -> Выполнить сдвиг вправо");
            System.out.println("2 -> Выполнить сдвиг влево");
            System.out.println("0 -> Выход в главное меню");
            String input = in.nextLine();
            System.out.println("------------------------------------");
            switch (input) {
                case "1" -> System.out.println(RealNumber.CyclicShiftRight());
                case "2" -> System.out.println(RealNumber.CyclicShiftLeft());
                case "0" -> {
                    System.out.println("Выход в главное меню...");
                    return;
                }
                default -> System.out.println("Неверная команда. Повторите ввод.");
            }
        }
    }

    /**
     * Метод запускает интерфейс для создания файла
     * @return Строка состояния
     */
    private String createFile() {
        while (true) {
            try {
                System.out.println("--Создание файла--");
                System.out.print("Название файла: ");
                String input = in.nextLine();
                return FileManager.createFile(Checker.checkNameFile(input));
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла: " + e.getMessage());
            } catch (Error error) {
                System.out.println("Ошибка: " + error.getMessage());
            }
        }
    }

    /**
     * Метод запускает интерфейс для удаления файла
     * @return Строка состояния
     */
    private String deleteFile() {
        while (true) {
            try {
                System.out.println("--Удаление файла--");
                System.out.print("Название файла: ");
                String input = in.nextLine();
                return FileManager.deleteFile(Checker.checkNameFile(input));
            } catch (Error error){
                System.out.println("Ошибка: " + error.getMessage());
            }
        }
    }
}