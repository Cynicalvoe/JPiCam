# JPiCam
A Java tool for capturing images and video on the Raspberry Pi

## Description
JPiCam is a basic Java wrapper for the `raspistill` and `raspivid` commands on the Raspberry Pi. These commands enable the Camera Module to take a photo or video, and this library connects these commands to the rest of your Java application.

## Usage
Usage is very straightforward! To take a photo, simply import this library into your project and paste this code:

```
JPiCam cam = new JPiCam();
JPiStill image = cam.TakeStill();
image.saveImage("/home/myImage.png");
```

Still images are kept as `BufferedImage`s until manually saved.

Videos are equally as easy to record. Using the same `JPiCam` object, you can then use the following to record a 10-second video:

```
cam.TakeVideo(10000, 24, 1200000, "/home/regularvid10s.h264");
```

This tool saves the video to disk immediately in the native `h264` format. You can later use a tool such as FFMPEG to convert this file into a more friendly `.mp4`. 

Finally, this tool includes methods for common Raspberry Pi Camera needs, such as Horizontal and Vertical flipping.

## Contributing
This was primarily written for personal use, and I acknowledge that not all features of the Pi Camera are present. If you have a need that this tool does not address, you are invited to submit a Pull Request with your changes!