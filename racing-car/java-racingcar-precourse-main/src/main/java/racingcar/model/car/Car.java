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
    
    static Car enrollWithName(final String name) {
    	return new Car(name);
    }
    
    public void forward() {
    	if(gasTank.isEnoughGas()) {
    		position.forward();
    	}
    }
    
    public String getName() {
    	return name.toString();
    }
    
    public String getPosition() {
    	return position.toString();
    }

}
