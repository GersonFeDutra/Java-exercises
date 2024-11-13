public class UpdateActualConditions extends WeatherUpdater {

	public UpdateActualConditions(WeatherData subject) {
		super(subject);
	}

	@Override
	public void show() {
		System.out.printf("Temperatura: %.1f\nUmidade: %.1f\nPressão: %.1f\n\n",
				this.weather.getTemp(), this.weather.getHumidity(), this.weather.getPressure());
	}

}
