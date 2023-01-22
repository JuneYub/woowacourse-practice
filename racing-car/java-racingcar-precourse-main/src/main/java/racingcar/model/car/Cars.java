package racingcar.model.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private static final String COMMA = ",";
	
	private final List<Car> cars;
	
	private Cars(final String inputNames) {
		validateNull(inputNames);
		validateBothEnds(inputNames);
		this.cars = validateDuplicate(inputNames);
	}
	
	public static Cars enrollCarsWithNames(final String inputNames) {
		return new Cars(inputNames);
	}
	
	private void validateNull(String inputNames) {
		if(inputNames == null) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}

	private void validateBothEnds(String inputNames) {
		if(inputNames.startsWith(COMMA) || inputNames.endsWith(COMMA)) {
			throw new IllegalArgumentException("잘못된 입렵입니다.");
		}
	}

	private List<Car> validateDuplicate(String inputNames) {
		List<String> namesList = new ArrayList<>(Arrays.asList(inputNames.split(COMMA)));
		Set<String> namesSet = new HashSet<>(namesList);
		
		if(namesList.size() != namesSet.size()) {
			throw new IllegalArgumentException("이름이 중복됩니다.");
		}
		return convertToCars(namesList);
	}

	private List<Car> convertToCars(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for(String name : names) {
			cars.add(Car.enrollWithName(name));
		}
		return cars;
	}
}
