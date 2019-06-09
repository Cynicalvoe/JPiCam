package tech.hadenw.jpicam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JPiStill {
	private BufferedImage _img;
	private JPiCam _cam;
	
	public JPiStill(JPiCam c) {
		_cam = c;
		
		// Take the image
		try {
			String command = "raspistill";
			
			if(_cam.getVerFlip())
				command += " -vf";
			
			if(_cam.getHorFlip())
				command += " -hf";
			
			command += " -w "+_cam.getWidth();
			command += " -h "+_cam.getHeight();
			command += " -o -";
			
			Process p = Runtime.getRuntime().exec(command);
			
			_img = ImageIO.read(p.getInputStream());
			
			p.getInputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the in-memory image data.
	 * @return The image.
	 */
	public BufferedImage getImage() {
		return _img;
	}
	
	/**
	 * Saves the image to disk in the Portable Network Graphics (.png) format.
	 * @param path The path of the file to save to.
	 * @return The image File, if created. Otherwise, returns null.
	 */
	public File saveImage(String path) {
		try {
			File f = new File(path);
			
			ImageIO.write(_img, "png", f);
			
			_img.flush();
			
			return f;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
