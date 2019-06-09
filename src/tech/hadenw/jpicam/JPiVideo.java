package tech.hadenw.jpicam;

import java.io.File;
import java.io.IOException;

public class JPiVideo {
	private File _vid;
	
	public JPiVideo(JPiCam c, String path) {
		this(c, 5000, 24, 1200000, path);
	}
	
	public JPiVideo(JPiCam c, int ms, int fps, int bitRate, String path) {
		// Take the image
		try {
			String command = "raspivid";
			
			if(c.getVerFlip())
				command += " -vf";
			
			if(c.getHorFlip())
				command += " -hf";
			
			command += " -w "+c.getWidth();
			command += " -h "+c.getHeight();
			command += " -t "+ms;
			command += " -fps "+fps;
			command += " -b "+bitRate;
			command += " -o "+path;
			
			Process p = Runtime.getRuntime().exec(command);
			
			p.waitFor();
			
			_vid = new File(path);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the video File, if it exists.
	 * @return The video File.
	 */
	public File getVideo() {
		return _vid;
	}
}
