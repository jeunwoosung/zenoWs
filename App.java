package calculator;

import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                double num1 = sc.nextDouble();



                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();


                System.out.println("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과 = " + result);

                calculator.inquiryResults();



                System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");

                String input1 = sc.next();
                if (input1.equals("exit")) {
                    sc.close();
                    break;
                }

            }
    }

}
