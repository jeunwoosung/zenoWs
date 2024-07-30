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



                System.out.println("저장된 연산결과를 조회 하시겠습니까? (inquiry 입력시 조회)");
                String input = sc.next();
                if (input.equals("inquiry")) {// 사용자 입력창에 inquiry를 입력하였을시에
                   LinkedList<Double> linkedlist = calculator.getLinkedlist(); // getLinkedlist를 호출하는 담은 객체 likedlist를 선언하고.
                   for (double results : linkedlist) { //향상된for문을 사용해서 double타입의 results으로 선언한 변수 내부의 내용들을
                       System.out.println(results); //출력한다.
                   }

                }

                System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");

                String input1 = sc.next();
                if (input1.equals("exit")) {
                    sc.close();
                    break;
                }
            }

    }

}
