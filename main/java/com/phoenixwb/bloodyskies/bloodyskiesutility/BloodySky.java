package com.phoenixwb.bloodyskies.bloodyskiesutility;

import java.util.Random;

public class BloodySky {
	public static final String[] options = { "The sky runs red with blood...", "Your world overflows with crimson...",
			"Sanguine essence fills your realm..." };
	
	static int red = 246;
	static int green = 82;
	static int blue = 70;
	
	public static int getRed()
	{
		return red;
	}
	
	public static int getGreen()
	{
		return green;
	}
	
	public static int getBlue()
	{
		return blue;
	}

	public static String bloodySkyInform() {
		String information;
		Random rand = new Random();
		information = options[rand.nextInt(4) - 1];
		return information;
	}
}
