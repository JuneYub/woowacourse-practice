package racingcar.model;

public class Lap {
	private static final int INIT_LAP = 0;
	private static final int MINIMUM_LAP = 1;
	private static final int UNIT_OF_ONE_LAP = 1;
	
	private final int goalLap; // Lap 객체가 아는 것 최종 랩과 현재 랩
	private int currentLap;
	
	private Lap(final String inputLap) {
		this.goalLap = validatePositiveNumber(inputLap);
		this.currentLap = INIT_LAP;
	}
	
	public static Lap initGoalLap(final String inputLap) {
		return new Lap(inputLap);
	}
	
	private int validatePositiveNumber(final String inputLap) {  // 최종 랩을 입력받는 메소드
		try {
			return validatePositive(Integer.parseInt(inputLap));
		}
		catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
		}
	}
	
	private int validatePositive(final int numberLap) {			// 최종 랩 타당성 검사
		if(numberLap < MINIMUM_LAP) {
			throw new IllegalArgumentException("1 미만의 입력입니다.");
		}
		return numberLap;
	}
	
	public void passOneLap() {			//	Lap이 하는 것 현재랩에 한바퀴 추가
		currentLap += UNIT_OF_ONE_LAP;
	}
	
	public boolean isFinish() {			// Lap이 하는 것 최종랩과 현재랩의 비교
		return currentLap == goalLap;
	}
}
