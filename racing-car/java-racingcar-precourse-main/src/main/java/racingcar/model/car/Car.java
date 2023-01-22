package racingcar.model.car;

public class Car {				
    private final Name name;
    private final Position position;
    private final GasTank gasTank;
    
    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
        this.gasTank = new GasTank();
    }
    
    static Car enrollWithName(final String name) { // 유저입력에 따른 Car 이름 설정
    												// 유저 입력 예외처리는 Name 클래스가 처리
    	return new Car(name);
    }
    
    public void forward() {				// Car가 하는 것 - 포지션 이동
    	if(gasTank.isEnoughGas()) {
    		position.forward();
    	}
    }
    
    public String getName() {			// Car가 아는 것 자신의 이름
    	return name.toString();
    }
    
    public String getPosition() {		// Car가 아는 것 자신의 위치
    	return position.toString();
    }

}
