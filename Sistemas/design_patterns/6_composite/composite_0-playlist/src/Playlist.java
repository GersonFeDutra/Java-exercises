import java.util.ArrayList;

/**
 * Playlist
 */
public class Playlist implements Component {

	private String name;
	private ArrayList<Component> playlists;

	public Playlist(String name) {
		playlists = new ArrayList<Component>();
		this.name = name;
	}

	@Override
	public void play() {
		for (Component playlist : playlists)
			playlist.play();
	}

	@Override
	public void setSpeed(double velocity) {

		for (Component playlist : playlists)
			playlist.setSpeed(velocity);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public ArrayList<Component> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Component> playlists) {
		this.playlists = playlists;
	}

	public void add(Component component) {
		playlists.add(component);
	}

	public boolean remove(Component component) {
		return playlists.remove(component);
	}

}
