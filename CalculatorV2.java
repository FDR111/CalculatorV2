import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;
public class CalculatorV2 {
    static Integer number1, number2;
    static char operation = ' ';
    static Integer result;
    static char formatDigital = ' '; //Формат числа A- арабские цифры, R - римские
    static String g_userInput = " "; //То что ввел пользователь

    static char quit = ' '; //Метка выхода из программы

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        do {//Делает цикл до тех пор пока quit != 'Q' смотри "while"
        try {//try – определяет блок кода, в котором может произойти исключение
            //инициализая переменных
            number1 = 0;
            number2 = 0;
            result = 0;
            operation = ' ';
            formatDigital = ' ';
            g_userInput = " ";

            input_data( ); //Ввод данных

            if (quit != 'Q'){//Пока quit != 'Q'

            calc();//Вычисляем результат

            if (formatDigital == 'A') {//Если арабские...
                System.out.println(g_userInput + " = " + result.toString());
            } else {//Если римские
                System.out.println(g_userInput + " = " + convertNumToRoman(Integer.parseInt(result.toString())));
            }}
        } catch (Exception e ){//Отлавливаем и печатаем особые ситуации
            System.out.println(e.getMessage());
        }
        } while (quit != 'Q');//Выход из программы
    }


    private static void input_data() throws Exception {
        Scanner scanner = new Scanner(System.in);
        char[] under_char1 = new char[10];
        char[] under_char2 = new char[10];
        int j = 0;


        System.out.println("Введите выражение или два римских числа от I до X:[V+V] + Enter, Q = выход");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
        quit = userInput.charAt(0);
        if (quit == 'Q')
        return;
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {

            if (operation != ' '){
                under_char2[j] = userInput.charAt(i);
                j++;}
            if (userInput.charAt(i) == '+') {
                operation = '+';
            }
            if (userInput.charAt(i) == '-') {
                operation = '-';
            }
            if (userInput.charAt(i) == '*') {
                operation = '*';
            }
            if (userInput.charAt(i) == '/') {
                operation = '/';
            }
            if (operation == ' ')
                under_char1[i] = userInput.charAt(i);
        }

        if (operation == ' ') {
            // Выдать сообщение, что нет операнда( + - * /) и выйти из программы.
            throw new Exception("В выражении нет операнда( + , -, *, / ) : " + userInput);
        }
        String s_num1 = new String(under_char1).trim();
        String s_num2 = new String(under_char2).trim();
        char c1 = check_token_format(s_num1);
        char c2 = check_token_format(s_num2);
        if (c1 == 'E') {
            throw new Exception("Первая часть выражения не число  - " + s_num1);
        }

        if (c2 == 'E') {
            throw new Exception("Вторая часть выражения не число  - " + s_num2);
        }

        if (c1 != c2) {
            throw new Exception("Части выражения в разных числовых форматах  - " );
        }


        if (c1 == 'A') {
            number1 = Integer.valueOf(s_num1);
            number2 = Integer.valueOf(s_num2);

        } else {
            number1 = romanToNumber(s_num1);
            number2 = romanToNumber(s_num2);


        }
        formatDigital = c1;
        g_userInput = userInput;
    }

    public static char check_token_format(String snum) {

        char c1;   // A- арабские цифры, R - римские, Е- ошибка
        try {
            Integer n1 = Integer.valueOf(snum);
            c1 = 'A';
        } catch (NumberFormatException e) {
            c1 = check_token_format_roman(snum);
        }

        return c1;
    }
    public static char check_token_format_roman(String snum) {
        char z1;
        z1 = switch (snum) {
            case "I" -> 'R';
            case "II" -> 'R';
            case "III" -> 'R';
            case "IV" -> 'R';
            case "V" -> 'R';
            case "VI" -> 'R';
            case "VII" -> 'R';
            case "VIII" -> 'R';
            case "IX" -> 'R';
            case "X" -> 'R';

            default -> 'E';
        };
        return z1;
    }

    private static Integer romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static void calc() throws Exception {
        // TODO Auto-generated method stub
        if (number1 > 10) {
            // Выдать сообщение, что число больше 10 и выйти из программы.
           // System.out.println("Первая часть выражения "+s_num1+" больше 10");
            //return;
            throw new Exception("Первая часть выражения > 10  - " + number1.toString());
        }

        if (number2 > 10) {
            // Выдать сообщение, что число больше 10 и выйти из программы.
            throw new Exception("Вторая часть выражения > 10  - " + number2.toString());
        }

        result = switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> throw new IllegalArgumentException("Unexpected value: " + operation);
        };
    }
}