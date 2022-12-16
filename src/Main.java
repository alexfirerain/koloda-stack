import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static Колода<Integer> стог = new Колода<>();
    static Scanner keyboard = new Scanner(System.in);
    static String WELCOME = """
             
             * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
            * Добро пожаловать в демонстрацию структуры данных "Колода"! *
            *    0 = запустить демонстрацию                              *
            *    1 = интерактивный режим                                 *
            *    . = завершение                                          *
            * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *""";
    static String PROMPT = """
                   Интерактивная работа с Колодой целочисленных значений.
                   Используйте следующие команды:
                       "положить х"  = добавить число х сверху колоды
                       "взять"       = снять и показать число, лежавшее наверху колоды
                       "перевернуть" = обратить порядок чисел в колоде
                       "показать"    = отразить текущее состояние колоды
                       "опустошить"  = обнулить содержимое колоды
                       "хватит"      = завершение интерактивного режима
                    
                """;
    public static void main(String[] args) {
        while (true) {
            System.out.println(WELCOME);
            String input = keyboard.next();
            if ("0".equals(input)) demo();
            if ("1".equals(input)) work();
            if (".".equals(input)) break;
        }
        System.out.println("Работа программы демонстрации завершена.");
    }

    private static void work() {
        System.out.println(PROMPT);
        boolean exit = false;
        String command;
        while (!exit) {
            command = keyboard.next();

            if (command.startsWith("положить ")) {
                int enteredValue;
                try {
                    enteredValue = Integer.parseInt(
                            command.substring(command.indexOf(" ") + 1));
                    стог.положить(enteredValue);
                } catch (NumberFormatException t) {
                    System.out.println("не удалось распознать число");
                }
                continue;
            }

            switch (command) {
                case "взять" -> System.out.println("взято с колоды: " + стог.взять());
                case "перевернуть" -> стог = стог.перевернуть();
                case "показать" -> стог.напечатать();
                case "опустошить" -> стог = new Колода<>();
                case "хватит" -> exit = true;
                default -> System.out.println(PROMPT);

            }
        }
        System.out.println("Выход из интерактивнго режима.");
    }

    private static void demo() {
        System.out.println("Последовательность команд из задания https://github.com/netology-code/algo-homeworks/blob/master/tasks/Lists.md\n");

        стог.напечатать();

        IntStream.range(0, 6).forEach(Main::put_and_print);

        take_and_print();
        take_and_print();

        reverse_and_print();

        take_and_print();
        take_and_print();

        reverse_and_print();

        take_and_print();
        take_and_print();
    }

    private static void put_and_print(int put) {
        System.out.println("Добавим " + put);
        стог.положить(put);
        стог.напечатать();
    }

    private static void take_and_print() {
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
    }

    private static void reverse_and_print() {
        System.out.println("Ревёрс!");
        стог = стог.перевернуть();
        стог.напечатать();
    }

}
