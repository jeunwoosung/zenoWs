package calculator;

import java.util.LinkedList;
import java.util.Scanner;


public class Calculator {
    private LinkedList<Double> linkedlist; //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성

        public Calculator(){ // 기본생성자를 선언하고
            linkedlist = new LinkedList<>(); //새로운 인스턴스를 생성할때마다 생성자를 통해서 연산결과를 linkedlist가 초기화 됨.
        }

    public double calculate(double num1, double num2, char operator) { // App의 Main메소드에서 num1,num2,operator를 사용자 입력값을 받은뒤 연산에 적용하기위한 매개변수.

        double result = 0; //결과값은 0부터 시작해라.

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


        addlikedlist(result); // 오래된 결과가 삭제된 결과값을 추가한다.
        return result; //리턴값은 결과값이 되게 만듬


    }

    public void inquiryResults(){
        Scanner sc = new Scanner(System.in);
        System.out.println("저장된 연산결과를 조회 하시겠습니까? (inquiry 입력시 조회)");
        String input = sc.next();
        if (input.equals("inquiry")) {// 사용자 입력창에 inquiry를 입력하였을시에
            LinkedList<Double> linkedlist = getLinkedlist(); // getLinkedlist를 호출하는 담은 객체 likedlist를 선언하고.
            for (double results : linkedlist) { //향상된for문을 사용해서 double타입의 results으로 선언한 변수 내부의 내용들을
                System.out.println(results); //출력한다.
            }
        }
    }

    private void addlikedlist(double result) {
        linkedlist.add(result);  //linkedlist변수에 결과값을 추가하게 만드는것
        if (linkedlist.size() > 10) { //만약에 likedlist 배열 안에 저장된 값이 10보다 커지면
            linkedlist.removeFirst(); // 가장 오래된 결과 삭제
        }
    }


    public LinkedList<Double> getLinkedlist() { // LinkedList<double> 타입의 getLinkedlist라는 메서드를 생성하고
        return new LinkedList<>(linkedlist); // 새로운 LinkedList타입의 linkedlist를 생성하고 복사해서 내보낸다.
    }

    public void setLinkedlist(LinkedList<Double> linkedlist) {//LinkedList<Double>타입의 linkedlist의 매개변수를 정해서
        this.linkedlist = linkedlist; // private접근제어자 필드에 Stter메서드를 통해 값을 저장하거나 수정할수 있다.
    }
}

