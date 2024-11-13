public class UpdateStatistics extends WeatherUpdater {
	float lastTemp;
	float lastHumidity;
	float lastPressure;

	public UpdateStatistics(WeatherData subject) {
		super(subject);
	}

	@Override
	public void show() {
		System.out.println("Estatísticas:");
		System.out.printf(
				"Variação de temperatura: %.1f\nVariação de umidade: %.1f\nVariação de pressão: %.1f\n\n",
				weather.getTemp() - lastTemp, weather.getHumidity() - lastHumidity,
				weather.getPressure() - lastPressure);
		this.lastTemp = weather.getTemp();
		this.lastHumidity = weather.getHumidity();
		this.lastPressure = weather.getPressure();
	}

}
