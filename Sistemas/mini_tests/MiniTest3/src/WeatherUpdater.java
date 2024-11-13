public abstract class WeatherUpdater implements Observer, DisplayElement {
	protected WeatherData weather;

	public WeatherUpdater(WeatherData subject) {
		this.weather = subject;
		weather.addObserver(this);
	}

	@Override
	public void update() {
		this.show();
	}
}
