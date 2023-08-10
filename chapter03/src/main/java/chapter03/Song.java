package chapter03;

public class Song {

	private String title;
	private String album;
	private String composer;
	private String artist;
	private int track;
	private int year;

	public Song() {

	}

	public Song(String title, String album, String composer, String artist, int track, int year) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.artist = artist;
		this.track = track;
		this.year = year;

		System.out.println("code1");
		System.out.println("code1");
		System.out.println("code1");
	}

	public Song(String title, String artist) {
		// TODO Auto-generated constructor stub
//		this.title = title;
//		this.artist = artist;
//		
//
//		System.out.println("code1");
//		System.out.println("code1");
//		System.out.println("code1");

		this(title, null, null, artist, 0, 0);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void show() {
		System.out.println(
				artist + " " + title + "(" + album + "," + year + "," + track + "번 track, " + composer + "작곡)");
	}
}
