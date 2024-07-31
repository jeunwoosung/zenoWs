package calculator;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.사칙연산 2.원의 넓이 계산 3.종료 중에 선택해서 숫자를 입력해 주세요 : ");
            int select = sc.nextInt();

            if (select == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                double num1 = sc.nextDouble();


                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();


                System.out.println("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과 = " + result);

                calculator.inquiryResults();// 기본생성자 선언으로 컬렉션타입필드 변경으로 인해 inquiry 로직 변경


            }


            if (select == 2) {

                System.out.println("반지름을 입력하세요 : ");
                double radius = sc.nextDouble(); //반지름의 값을 스캐너로 입력받음

                Calculator.CircleArea circleArea = new Calculator.CircleArea(radius); // CircleArea 객체를 생성함

                double area = circleArea.getArea(); // 넓이 계산

                System.out.println("반지름 : " + circleArea);
                System.out.println("넓이 : " + area);
                calculator.addCircleArea(area);


                calculator.inquiryCircle();// 원의 넓이 결과 조회

            }

                if (select == 3) {

                    System.out.println("프로그램을 종료합니다.");
                    break;

                }




                System.out.println("더 계산하시겠습니까?(아무키를 누르면 선택메뉴로 돌아갑니다) (exit 입력 시 종료)");

                String input1 = sc.next();
                if (input1.equals("exit")) {
                    sc.close();
                    break;
                }



        }
    }
}