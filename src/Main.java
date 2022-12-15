import java.util.Scanner;

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
    public static void main(String[] args) {
        System.out.println(WELCOME);
        String input = keyboard.next();
        while (true) {
            if ("0".equals(input)) demo();
            if ("1".equals(input)) work();
            if (".".equals(input)) break;
            System.out.println(WELCOME);
            input = keyboard.next();
        }
        System.out.println("Работа программы демонстрации завершена.");
    }

    private static void work() {
    }

    private static void demo() {
        System.out.println("Последовательность команд из задания https://github.com/netology-code/algo-homeworks/blob/master/tasks/Lists.md\n");
        стог.напечатать();
        
        System.out.println("Добавим 0");
        стог.положить(0);
        стог.напечатать();
        
        System.out.println("Добавим 1");
        стог.положить(1);
        стог.напечатать();
        
        System.out.println("Добавим 2");
        стог.положить(2);
        стог.напечатать();
        
        System.out.println("Добавим 3");
        стог.положить(3);
        стог.напечатать();
        
        System.out.println("Добавим 4");
        стог.положить(4);
        стог.напечатать();
        
        System.out.println("Добавим 5");
        стог.положить(5);
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
        
        System.out.println("Ревёрс!");
        стог = стог.перевернуть();
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
        
        System.out.println("Ревёрс!");
        стог = стог.перевернуть();
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
        
        System.out.println("Снимем со стека");
        System.out.println(стог.взять());
        стог.напечатать();
    }
}
