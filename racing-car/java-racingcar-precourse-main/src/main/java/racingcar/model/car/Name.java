package racingcar.model.car;

public class Name { // 단순히 String Name을 쓰지 않고 원시 값을 포장해줍니다.
	
	private static final String BLANK = " "; // 상수는 대문자
	private static final int MINIMUM_LENGTH = 1;
	private static final int MAXIMUM_LENGTH = 5;
	
	private final String name;
	
	Name(final String name) { // 파라미터는 변경불가능한 상수
		validateBlank(name); // 공백 타당성 검사
		validateLength(name); // 문자열 길이 타당성 검사
		this.name = name;
	}

	private void validateLength(final String name) {
		if(name.contains(BLANK)) {
			throw new IllegalArgumentException(); // 예외처리
		}
		
	}

	private void validateBlank(final String name) {
		if(name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
			throw new IllegalArgumentException();
		}
	}
	
	public String toString() {  // 이거 getter에 대한 방어적 복사가 될지 모르겠음
		return name;
	}
}
