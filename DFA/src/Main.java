

public class Main {

    public static void main(String[] args) {
        DFATable table = new DFATable();
        //각 state 정의
        State A = new State('A');
        State B = new State('B');
        State C = new State('C');
        State D = new State('D');
        State E = new State('E');
        //각 state의 입력 기호에 따른 상태변화 설정
        A.addAvailableStates('a', B);
        A.addAvailableStates('b', C);
        B.addAvailableStates('a', B);
        B.addAvailableStates('b', D);
        C.addAvailableStates('a', B);
        C.addAvailableStates('b', C);
        D.addAvailableStates('a', B);
        D.addAvailableStates('b', E);
        E.addAvailableStates('a', B);
        E.addAvailableStates('b', C);
        //종결상태 E와 그 외 상태의 동치류 설정
        A.setEquivalence(1);
        B.setEquivalence(1);
        C.setEquivalence(1);
        D.setEquivalence(1);
        E.setEquivalence(2);
        //table에 삽입
        table.addStateList(A);
        table.addStateList(B);
        table.addStateList(C);
        table.addStateList(D);
        table.addStateList(E);
        //로직 시작
        table.printTable();
        do{
            table.printTable();
        }while(table.modifyEquivalence());
    }
}
