package racingcar.view;

import java.util.List;

public class OutPutView {
	
	public static void printStartRace() {
		System.out.println(System.lineSeparator() + "실행결과");
	}
	
	public static void printCarInfo(String name, String position) {
		System.out.println(name + " : " + position);
	}
	
	public static void printPassOneLap() {
		System.out.println();
	}
	
	public static void printWinners(List<String> winnerName) {
		System.out.println(String.join(",", winnerName) + "가 최종 우승했습니다.");
	}
}
