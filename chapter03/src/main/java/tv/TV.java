package tv;

public class TV {
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power;

	public TV(int i, int j, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public void power(boolean on) {
		power = on;
	}

	public void channel(boolean up) {
	}

	public void channel(int channel) {
		this.channel = channel;
	}

	public void volume(boolean up) {
	}

	public void volume(int volume) {
		this.volume = volume;
	}

	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + ", channel=" + channel + ", volume=" + volume + "]");
	}
}