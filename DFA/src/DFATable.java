import java.util.ArrayList;
import java.util.List;

public class DFATable {
    private List<State> stateList = new ArrayList<>(); //테이블이 가지는 상태리스트
    private int maxEquivalence = 0; //현재 테이블이 가지는 상태의 최대 동치류 분류숫자

    public void addStateList(State state){
        stateList.add(state);
    }

    public boolean modifyEquivalence(){
        boolean result = false;
        for(State state : stateList){ //최대 동치류 분류 숫자 갱신
            maxEquivalence = Math.max(maxEquivalence, state.getEquivalence());
        }
        for(int i = 0 ; i < stateList.size() ; i++){ //각 상태에 대해 동치류 분류
            boolean isMaxUpper = false;
            int a = stateList.get(i).availableStates.get('a').getEquivalence();
            int b = stateList.get(i).availableStates.get('b').getEquivalence();
            int currentEquiv = stateList.get(i).getEquivalence();
            for(int j = 0 ; j < stateList.size() ; j++){
                if(i == j) continue;
                if(stateList.get(j).getEquivalence() == currentEquiv
                        && stateList.get(j).availableStates.get('a').getEquivalence() == a
                        && stateList.get(j).availableStates.get('b').getEquivalence() == b){
                    //같은 동치류에서 같은 결과
                    System.out.println("[o]--"+stateList.get(i).getStateName() + "과(와) " + stateList.get(j).getStateName() + "은(는) 같은 동치류에서 같은 결과");

                }
                else if(stateList.get(j).getEquivalence() == currentEquiv
                        && (stateList.get(j).availableStates.get('a').getEquivalence() != a
                        || stateList.get(j).availableStates.get('b').getEquivalence() != b)){
                    //같은 동치류에서 다른 결과
                    System.out.println("[x]--"+stateList.get(i).getStateName() + "과(와) " + stateList.get(j).getStateName() + "은(는) 같은 동치류에서 다른 결과");

                    stateList.get(j).setEquivalence(maxEquivalence+1);
                    isMaxUpper = true;
                    result = true;

                }
            }
            if(isMaxUpper) maxEquivalence++;
        }
        return result;
    }

    public void printTable() {
        for(State state : stateList){
            System.out.println("상 태: " + state.stateName
                    + "\n동치류: " + state.equivalence
                    + "\na to: " + state.availableStates.get('a').equivalence
                    + "\nb to: " + state.availableStates.get('b').equivalence
                    + "\n+-----------------+");
        }
    }
}
