package racingcar.myutil;

import java.util.Random;

public class RandomUtils {				// 여러 클래스에서 자주 사용되는 메소드 모음
	
	private static final Random RANDOM = new Random();
	
	private RandomUtils() {		// 인스턴스화가 필요없는 유틸리티 클래스는 private 생성자를 사용하자
	}
	
	public static int nextPositiveInt(final int startInclusive, final int endInclusive) {
		if(startInclusive > endInclusive) {   // 시작값이 마지막값보다 크면 예외처리
			throw new IllegalArgumentException();
		}
		
		if(startInclusive < 0) {				// 시작값이 음수면 예외처리
			throw new IllegalArgumentException();		
		}
		
		if(startInclusive == endInclusive) {		// 시작값과 마지막값이 같다면 그냥 시작값 반환
			return startInclusive;
		}
		
		return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1); // 0에서 ~ 결과 사이의 값
	}
}
