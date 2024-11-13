public class Test {
	public static void main(String[] args) throws Exception {
		WeatherData data1 = new WeatherData();
		UpdateActualConditions c1 = new UpdateActualConditions(data1);
		UpdateStatistics e1 = new UpdateStatistics(data1);
		UpdatePreview p1 = new UpdatePreview(data1);
		data1.setupMeasurements(23, 59, 1013);
		System.out.println();
		data1.setupMeasurements(34, 26, 1011);
		System.out.println();
		data1.setupMeasurements(28, 40, 1015);
	}
}
