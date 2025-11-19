
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
            System.out.println("4 -> Создать файл");
            System.out.println("5 -> Сохранить очередь в файл");
            System.out.println("6 -> Вывести содержимое файла");
            System.out.println("7 -> Удалить файл");
            System.out.println("0 -> Завершить работу программы");
            System.out.print("Введите номер команды: ");

            String input = in.nextLine();
            System.out.println("------------------------------------");

            switch (input) {
                case "1" -> create();
                case "2" -> System.out.println(RealNumber.printQueue());
                case "3" -> System.out.println("3");
                case "4" -> System.out.println("4");
                case "5" -> System.out.println("5");
                case "6" -> System.out.println("6");
                case "7" -> System.out.println("7");
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
    private void create(){
        try{
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
        } catch (Error error){
            System.out.println("Ошибка: " + error.getMessage());
        }
    }
}