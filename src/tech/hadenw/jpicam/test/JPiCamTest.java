package tech.hadenw.jpicam.test;

import tech.hadenw.jpicam.JPiCam;

/**
 * This is a simple script that tests the functions of this
 * tool.
 */
public class JPiCamTest {
	public static void main(String[] args) {
		System.out.println("== JPiCam Test ==");
		System.out.println("Developed by @Cynicalvoe\n");
		
		long start = System.currentTimeMillis();
		
		System.out.println("Starting!");
		JPiCam cam = new JPiCam();
		
		System.out.println("[1/2] Taking picture...");
		cam.TakeStill().saveImage("/home/regularpng.png");
		System.out.println("Done!");
		
		System.out.println("[2/2] Taking videos...");
		System.out.println("1 of 2");
		cam.TakeVideo("/home/regularvid5s.h264");
		
		System.out.println("2 of 2");
		cam.TakeVideo(10000, 24, 1200000, "/home/regularvid10s.h264");
		System.out.println("Done!\n");
		
		System.out.println("Total elapsed time: "+(System.currentTimeMillis()-start)/1000 + "s");
	}
}