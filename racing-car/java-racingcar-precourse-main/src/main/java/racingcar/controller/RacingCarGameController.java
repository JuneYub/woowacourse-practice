package racingcar.controller;

import racingcar.model.Lap;
import racingcar.model.Winners;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarGameController {
	public void playGame() {
		Cars cars = cars.enrollCarsWithNames(InputView.inputCarNames());
		Lap lap = Lap.initGoalLap(InputView.inputLap());
		
		OutPutView.printStartRace();
		racing(cars, lap);
		OutPutView.printWinners(Winners.toList(cars.getCars()));
		
	}
	
	private void racing(Cars cars, Lap lap) {
		while(!lap.isFinish()) {
			passOneLap(cars, lap);
		}
	}
	
	private void passOneLap(Cars cars, Lap lap) {
		for(Car car : cars.getCars()) {
			car.forward();
			OutPutView.printCarInfo(car.getName(), car.getPosition());
		}
		
		lap.passOneLap();
		OutPutView.printPassOneLap();
	}
	
	
}
