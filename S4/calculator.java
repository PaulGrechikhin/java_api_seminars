package S4;
// Реализовать простой калькулятор

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class calculator {

    // метод получения числа
    public static double inputNumber(Scanner scanner) {
        System.out.println("Введите число");
        double number = 0.0;
        try {
            number = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Вы ввели не число. Попробуйте еще раз");
            scanner.nextLine();
            inputNumber(scanner);
        }
        return number;
    }

    // метод получения числа операции
    static String scanOperations() {
        Scanner scan = new Scanner(System.in);
        String operations = scan.nextLine();
        scan.close();
        return operations;

    }

    // метод получения результата
    static double getResult(String opr, double num1, double num2) {
        double result = 0.0;
        switch (opr) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;

            default:
                System.out.println("Введите оператор: -, +, *, /");
                break;
        }
        return result;

    }

     // Метод отмены последнего действия
     public static void reset(Deque<Double> list) {
        if (!list.isEmpty()) {
            list.removeLast();
            System.out.println("Операция отменена");
            if (list.isEmpty()) {
                list.addLast(0.0);
            }
            System.out.println("Работаем с результатом " + list.getLast());
        }
    }

    // Метод добавления элементов в очередь
    public static void addElement(Deque<Double> list, double element) {
        list.addLast(element);
    }

    // Метот ввода оператора действия
    public static String input(Scanner scanner) {
        System.out.println("Введите оператор действия (+, -, *, /) или 'backspace'");
        String oper = scanner.next().toLowerCase();
        if ((!oper.equals("+")) & (!oper.equals("-")) & (!oper.equals("*")) & (!oper
                    .equals("/")) & (!oper.equals("backspace"))) {
                System.out.println("Неправильная операция. Попробуйте снова!");
                oper = input(scanner);
                scanner.nextLine();
        }
        return oper;
    }

    public static void main(String[] args) {
        System.out.println("Если ввести команду 'backspace', то можно отменить последнее действие и вернуть предыдущий результат");
        Scanner scan = new Scanner(System.in, "cp866");
        Deque<Double> number_list = new LinkedList<>();

        boolean first_input = true;
        boolean calc = true;
        double number1 = 0.0;
        String operation;

        while (calc) {
            if (first_input) {
                number1 = inputNumber(scan);
                first_input = false;
            }
            operation = input(scan);
            if (operation.equals("backspace")) {
                if (!number_list.isEmpty()) {
                    reset(number_list);
                    number1 = number_list.getLast();
                } else {
                    System.out.println("Текущий результат отсутствует. Давайте начнем сначала!");
                    number1 = inputNumber(scan);
                }
                operation = input(scan);
            }
            double number2 = inputNumber(scan);
            double result = getResult(operation, number1, number2 );
            number1 = result;
            addElement(number_list, result);
            System.out.println("Результат = " + result);
        }
    }
}