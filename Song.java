package lab2;

public class Song {
	Artist artist;
	private String name;
	private final int id;
	private static int song_id = 0;
	private int plays;
	private int downs;
	public Song(Artist artist,String name) {
		this.artist = artist;
		this.name = name;
		this.id= song_id;
		song_id++;
	}
	
	public void Reset()
	{
		this.plays=0;
		this.downs=0;
	}
	public int getPlays() {
		return plays;
	}

	public void setPlays(int plays) {
		this.plays = plays;
	}

	public int getDowns() {
		return downs;
	}

	public void setDowns(int downs) {
		this.downs = downs;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public int getId() {
		return id;
	}
	public static int getSong_id() {
		return song_id;
	}
	public static void setSong_id(int song_id) {
		Song.song_id = song_id;
	}
	
	
	
}
