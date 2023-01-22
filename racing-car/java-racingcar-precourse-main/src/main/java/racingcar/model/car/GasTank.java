package racingcar.model.car;

import racingcar.myutil.RandomUtils;

public class GasTank {							// 기름을 얻고 이를 통해 주행을 할 수 있는 곳
	private static final int MINIMUM_GAS = 0;	// 상수는 대문자 0~9의 기름을 주입한다.
	private static final int MAXIMUM_GAS = 9;
	private static final int ENOUGH_GAS = 4;	// 랜덤값이 4 이상일때 기름이 충분하다고 판단
	
	GasTank() {
	}
	
	boolean isEnoughGas() { 				// 가스탱크가 아는 것 정지 출발의 기준
		return RandomUtils.nextPositiveInt(MINIMUM_GAS, MAXIMUM_GAS) >= ENOUGH_GAS;
	}
}
