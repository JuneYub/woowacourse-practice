package racingcar.myutil;

import java.util.Random;

public class RandomUtils {
	
	private static final Random RANDOM = new Random();
	
	RandomUtils() {
	}
	
	public static int nextPositiveInt(final int startInclusive, final int endInclusive) {
		if(startInclusive > endInclusive) {
			throw new IllegalArgumentException();
		}
		
		if(startInclusive < 0) {
			throw new IllegalArgumentException();
		}
		
		if(startInclusive == endInclusive) {
			return startInclusive;
		}
		
		return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1); // 0에서 ~ 결과 사이의 값
	}
}
