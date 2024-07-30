package calculator;

import java.util.LinkedList;


public class Calculator {
    private LinkedList<Double> linkedlist = new LinkedList<>(); //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성



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

