package counter;

public class Counter {

	private int value;
	private int maxValue = 100_000;
	private String model = "N-COUNTER";
	
	
	public Counter() {
		
	}
	
	public Counter(int maxValue) {
		this(maxValue,"N-COUNTER");
	}
	
	public Counter(int maxValue, String model) {
		this.maxValue = maxValue;
		this.model = model;
	}
	
	public Counter(Counter contador) {
		this.value = contador.value;
		this.maxValue = contador.maxValue;
		this.model = contador.model;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getMaxValue() {
		return maxValue;
	}

	public String getModel() {
		return model;
	}

	public boolean increment() {
		if(value + 1 <= maxValue ) {
			value++;
			return true;
		}
		return false;
	}
	
	public boolean increment(int n) {
		if(n <= 0) throw new IllegalArgumentException("El valor introducido debe ser mayor que 0");
		if(value + n <= maxValue) {		
			value += n;
			return true;
		}
		value = maxValue;
		throw new IllegalArgumentException("Número demasiado grande, fijado valor en el máximo posible");
	}

	
	public boolean reset() {
		if(value == maxValue) {
			value = 0;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Contador modelo : %s \n"
				+ "Valor actual: %d \n"
				+ "Valor máximo: %d \n", model,value,maxValue);
	}
	
	
	
	
}
