public class Music implements Component {

	private String name;
	private String artist;
	private double speed = 1d;

	public Music(String name, String singer) {
		this.name = name;
		this.artist = singer;
	}

	@Override
	public void play() {
		System.out.printf("Reproduzindo a música: %s.\n", name);
	}

	@Override
	public void setSpeed(double velocity) {
		this.speed = velocity;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return this.artist;
	}

	public void setSinger(String singer) {
		this.artist = singer;
	}

	public double getSpeed() {
		return this.speed;
	}

}
