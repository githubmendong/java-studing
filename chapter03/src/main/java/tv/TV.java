package tv;

public class TV {
	private int channel; // 1 ~ 255
	private int volume; // 0 ~ 100
	private boolean power;

	public TV(int i, int j, boolean b) {
		// TODO Auto-generated constructor stub
		this.channel = 7;
		this.volume = 20;
		this.power = false;
	}

	// Getter 메소드
	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	// 메소드 구현
	public void power(boolean on) {
		this.power = on;
	}

	public void channel(int channel) {
		if (channel >= 1 && channel <= 255) {
			this.channel = channel;
		}
	}

	public void channel(boolean up) {
		if (up && channel < 255) {
			channel++;
		} else if (!up && channel > 1) {
			channel--;
		}
	}

	public void volume(int volume) {
		if (volume >= 0 && volume <= 100) {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		if (up && volume < 100) {
			volume++;
		} else if (!up && volume > 0) {
			volume--;
		}
	}

	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
}