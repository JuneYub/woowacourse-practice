package racingcar.model.car;

public class Position { // 자동차의 위치에 대한 원시값을 포장한 클래스
	
	private static final String UNIT_OF_POSITION = "-"; // 바퀴 수 상수로 표현
	
	private final StringBuilder position;
	
	Position() {		//	방어적 복사 원리에 따른 새로운 StringBuilder 생성
		this.position = new StringBuilder();
	}
	
	void forward() {			// 바퀴 수 추가
		position.append(UNIT_OF_POSITION);
	}
	
	public String toString() {			// 마찬가지로 getter에 대한 방어적 복사되는지 안되는지 모르겠음
		return position.toString();
	}
}
