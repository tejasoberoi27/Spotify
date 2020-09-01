package lab2;

import java.util.ArrayList;

class Artist implements User
{
	private ArrayList<Song> songs = new ArrayList<Song>();
	private static int artist_id =   20;
	private final int id;
	private String name;	
	private static int royalty;

	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	public static int getRoyalty() {
		return royalty;
	}
	public static void setRoyalty(int royalty) {
		Artist.royalty = royalty;
	}
	public Artist(String name) {
		this.id = artist_id;
		artist_id+=2;
		this.name = name;
	}
	public static int getArtist_id() {
		return artist_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void add_song(Song s)
	{
		songs.add(s);
	}

	private int calcRoyalty() {
		int due=0;
		for(int i=0;i<songs.size();i++)
		{
			Song cur =songs.get(i);
			due+= cur.getDowns()*20 + cur.getPlays()*5;
			cur.Reset();
		}
		return due;
	}
	/*Common*/
	@Override
	public int transaction()
	{
		int due = calcRoyalty();
		return due;
	}

	@Override
	public void refresh()
	{
		this.royalty=0;
	}

	@Override
	public void Stream(ArrayList<Song> songs,int num,int song_id,String option)
	{
		//small d or capital D
		int nullify=0;
		Song cur = songs.get(song_id);
		if(cur.artist==this)
		{
			nullify =1;
		}
		if(option.equalsIgnoreCase("D"))
		{
			if(nullify==0)
				cur.setDowns(cur.getDowns()+1);
		}
		else if(option.equalsIgnoreCase("P"))
		{
			if(nullify==0)
				cur.setPlays(cur.getPlays()+1);
		}
		else
		{
			System.err.println("invalid option - Type D or P");
		}
	}

	@Override
	public String Display() {
		String s = this.name+" "+this.id+": ";
		for(int i =0;i<songs.size();i++)
		{
			s+=(songs.get(i).getName()+", ");
		}
		return s;
	}

}

