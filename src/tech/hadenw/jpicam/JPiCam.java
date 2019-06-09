package tech.hadenw.jpicam;

/**
 * Provides an interface for capturing video and image data from the Camera module on a Raspberry Pi.
 * This wrapper calls the native "raspistill" and "raspivid" commands and returns their response
 * in a Java-friendly format.
 * 
 * @author Cynicalvoe
 */
public class JPiCam {
	private boolean _hFlip;
	private boolean _vFlip;
	private int _width;
	private int _height;
	
	/**
	 * Creates a new instance with a default camera resolution of 640x480.
	 */
	public JPiCam() {
		this(640, 480);
	}
	
	/**
	 * Creates a new instance.
	 * @param w The camera width.
	 * @param h The camera height.
	 */
	public JPiCam(int w, int h) {
		_hFlip = false;
		_vFlip = false;
		_width = w;
		_height = h;
	}
	
	/**
	 * Gets the current setting for the camera width.
	 * @return Current width.
	 */
	public int getWidth() {
		return _width;
	}
	
	/**
	 * Sets the current setting for the camera width.
	 * @param w The new width.
	 */
	public void setWidth(int w) {
		_width = w;
	}
	
	/**
	 * Gets the current setting for the camera height.
	 * @return Current height.
	 */
	public int getHeight() {
		return _height;
	}
	
	/**
	 * Sets the current setting for the camera height.
	 * @param h The new height.
	 */
	public void getHeight(int h) {
		_height = h;
	}
	
	/**
	 * Sets whether the camera is flipped horizontally.
	 * @param isFlipped
	 */
	public void setHorFlip(boolean isFlipped) {
		_hFlip = isFlipped;
	}
	
	/**
	 * Gets whether the camera is flipped horizontally.
	 * @return If it is flipped.
	 */
	public boolean getHorFlip() {
		return _hFlip;
	}
	
	/**
	 * Sets whether the camera is flipped vertically.
	 * @param isFlipped
	 */
	public void setVerFlip(boolean isFlipped) {
		_vFlip = isFlipped;
	}
	
	/**
	 * Gets whether the camera is flipped vertically.
	 * @return If it is flipped.
	 */
	public boolean getVerFlip() {
		return _vFlip;
	}
	
	/**
	 * Takes a still image using the current camera settings.
	 * @return A JPiStill object containing the image data.
	 */
	public JPiStill TakeStill() {
		return new JPiStill(this);
	}
	
	/**
	 * Takes a 5-second video and saves it to disk.
	 * @param path The location of the video file to save.
	 * @return The JPiVideo object containing video data.
	 */
	public JPiVideo TakeVideo(String path) {
		return new JPiVideo(this, path);
	}
	
	/**
	 * Takes a video and saves it to disk.
	 * @param ms The length (in ms) of the video.
	 * @param fps The Frames Per Second of the video.
	 * @param bitRate The Bitrate of the video to use.
	 * @param path The location of the video file to save.
	 * @return The JPiVideo object containing video data.
	 */
	public JPiVideo TakeVideo(int ms, int fps, int bitRate, String path) {
		return new JPiVideo(this, ms, fps, bitRate, path);
	}
}
