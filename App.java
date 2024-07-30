package calculator;

import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {



        int[] results = new int[10]; //results 라는 int배열 10을 생성한 변수를 가지고있게 만듬.
        LinkedList<Integer> resultlist = new LinkedList<Integer>(); // 10의 계산을 넘어가게 되면 무한으로 추가하거나 삭제할수있게  Linked List 자료구조 사용
        boolean usedLinkedList = false; // usedLinkedList란 말 그대로 사용할것이냐 했을때 일단은 거짓으로 선언해두고

        Scanner sc = new Scanner(System.in);


        int count = 0; //루프 내부에 선언되면 매번 0으로 초기화 되니, 무조건 루프 밖에다가 선언! 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수.
        while (true) { //안의 내용이 참일시에 조건을 순환 시켜라.
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num1 = sc.nextInt();



            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();



            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // operator는 원래 String 변수이지만 charAt(0);이라는 기본형 변수를 활용해서 char 변수로 변경


            int result = 0; //결과값은 0부터 시작해라.

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력 될 수 없습니다.");
                    } else {
                        result = num1 / num2;

                    }
                    break;

                default:
                    System.out.println("알수없는 연산입니다.");


            }

            if (!usedLinkedList) { // 결과의 값이 10개 미만의 배열의 저장이 되었을때 LinkedList를 사용하지 않도록 함.
                if (count < results.length) { // results배열의 수가 꽉찰때까지 작동하게 하는 방식 * results.length는 현재 문자열이나 문자가 없기때문에 배열의 길이를 뜻한다.
                    results[count] = result; // count 배열에 결과값이 저장될수있도록 하는 방식
                    count++;
                } else { //계산이 10번이 넘어갈때 배열은 자동으로 무한으로 추가된다.
                    usedLinkedList = true; //usedLinkedList가 참일시에
                    for (int i : results) { //results라는 배열을 담은 int i 의 변수를 계속 추가해라.
                        resultlist.add(i);
                    }
                    resultlist.add(result);
                }
            } else { // 11번째 이상 결과값이 나올시에 만약 사용자입력에서 remove를 입력을 하게되었을시 가장먼저 저장된 배열의 값이 삭제된다.

                if (resultlist.size() > 10) { // 결과 값이 저장된 배열의 사이즈가 10이상이 되었을시
                    System.out.println("가장먼저 저장된 연산결과를 삭제 하시겠습니까?(remove 입력시 삭제됨)");
                    String input = sc.next();
                    if (input.equals("remove")) {
                        resultlist.removeFirst(); // 사용자 입력에서 remove가 입력이 된다면 제일먼저 저장된 값을 지워라
                    }
                }
            }

            System.out.println("저장된 연산결과를 조회 하시겠습니까? (inquiry 입력시 조회)");
            String input = sc.next();
            if (input.equals("inquiry")) {
                if (!usedLinkedList) {
                    for (int i : results) {
                        if(i != 0) {
                            System.out.println(i);
                        }
                    }
                }else {
                    for (int i : resultlist)
                        System.out.println(i);
                }
            }



            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");

            String input1 = sc.next();
            if (input1.equals("exit")) {
                break;
            }


        }
        sc.close();
    }

}














