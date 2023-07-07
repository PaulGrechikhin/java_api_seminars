package S1;

 // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! 

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Эта программа находит сумму всех чисел от 1 до n. Введите целое число n: ");
        int i = iScanner.nextInt();
        int n = (i * (i + 1)) / 2;
        System.out.printf("Треугольное число: %d\n", n);
        iScanner.close();
    }
}