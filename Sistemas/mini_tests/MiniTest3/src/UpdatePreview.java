public class UpdatePreview extends WeatherUpdater {

	public UpdatePreview(WeatherData subject) {
		super(subject);
	}

	@Override
	public void show() {
		System.out.println("Previsão do tempo:");

		if (this.weather.getHumidity() < 40)
			System.out.println("O tempo hoje será seco!");
		else if (this.weather.getPressure() > 1013)
			System.out.println("Hoje irá chover!");
		else
			System.out.println("O tempo hoje será úmido!");

		System.out.println();
	}

}
