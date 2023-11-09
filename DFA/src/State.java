import java.util.HashMap;
import java.util.Map;

public class State {
    char stateName; //상태 이름
    int equivalence; //동치류 분류숫자
    Map<Character, State> availableStates = new HashMap<>(); //key: 입력기호(a,b), value: 입력기호에 따른 다음 상태

    public State(char stateName) {
        this.stateName = stateName;
    } //생성자

    public void addAvailableStates(char input, State state) {
        availableStates.put(input, state);
    } //입력기호에 따른 다음 상태 추가

    public char getStateName() {
        return stateName;
    }

    public int getEquivalence() {
        return equivalence;
    }

    public void setEquivalence(int equivalence) {
        this.equivalence = equivalence;
    }
}
