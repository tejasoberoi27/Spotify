package lab2;

import java.util.ArrayList;

public interface User {
	public int transaction();
	public void refresh();
	public void Stream(ArrayList<Song> songs,int num,int song_id,String option);
	public String Display();
}
