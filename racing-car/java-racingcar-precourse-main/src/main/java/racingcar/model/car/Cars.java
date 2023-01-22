package racingcar.model.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {								// Car의 일급컬렉션을 통해 상태와 행위를 처리
	private static final String COMMA = ",";
	
	private final List<Car> cars;      // Car 객체의 리스트를 유일한 멤버변수로 가진다.
	
	private Cars(final String inputNames) {	// Cars의 생성자는 이름이 적힌 문자열을 인자로 받는다.
		validateNull(inputNames);			// 공백 타당성 검사
		validateBothEnds(inputNames);		// ',' 타당성 검사
		this.cars = validateDuplicate(inputNames);	// 중복된 이름 타당성 검사
	}
	
	public static Cars enrollCarsWithNames(final String inputNames) {	// 문자열을 입력받아 Car 리스트를 생성하는 시작 메소드 
		return new Cars(inputNames);
	}
	
	private void validateNull(String inputNames) {		// 공백 타당성 검사
		if(inputNames == null) {						
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}

	private void validateBothEnds(String inputNames) {		// 입력받은 문자열의 시작과 끝이 ,이면 예외처리
		if(inputNames.startsWith(COMMA) || inputNames.endsWith(COMMA)) {
			throw new IllegalArgumentException("잘못된 입렵입니다.");
		}
	}

	private List<Car> validateDuplicate(String inputNames) {	// 입렵받은 문자열 이름 중복 검사
		List<String> namesList = new ArrayList<>(Arrays.asList(inputNames.split(COMMA)));
		Set<String> namesSet = new HashSet<>(namesList); // 생성된 이름 리스트의 중복을 검사하기 위해 set 활용
		
		if(namesList.size() != namesSet.size()) {
			throw new IllegalArgumentException("이름이 중복됩니다.");
		}
		return convertToCars(namesList);
	}

	private List<Car> convertToCars(List<String> names) { // 이름 리스트를 Car 리스트로 전환
		List<Car> cars = new ArrayList<>();				// 방어적 복사를 위해 새로운 메모리에 할당할 예정
		for(String name : names) {
			cars.add(Car.enrollWithName(name));			// 이름을 받으면 Car 객체를 반환
		}
		return cars;
	}
	
	public List<Car> getCars() {
		return cars;						// 이렇게 반환하면 getter 방어적 복사가 아님
		// return new ArrayList<>(cars); -> 방어적 복사 예시
	}
}
