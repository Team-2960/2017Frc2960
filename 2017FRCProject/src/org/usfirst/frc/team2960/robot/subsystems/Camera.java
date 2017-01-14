package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Camera extends Subsystem implements PeriodicUpdate{
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	private double centerX2 = 0.0;
	
	private final Object imgLock = new Object();
	
	private UsbCamera camera;
	public Camera(){
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		camera.setBrightness(0);
		startThread();
		
	}
	
	private void startThread(){
		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
			if(!pipeline.filterContoursOutput().isEmpty()){
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
				synchronized (imgLock){
					centerX = r.x + (r.width / 2);
					centerX2 = r2.x + (r2.width / 2);
				}
			}
		});
		visionThread.start();
	}
	
	
	@Override
	public void update() {
		double test;
		double test2;
		double center;
		synchronized(imgLock){
			test = this.centerX;
			test2 = this.centerX2;
		}
		if(test > test2){
			center = test - test2;
		}
		else{
			center = test2 - test;
		}
		SmartDashboard.putNumber("center", center);
	}

	@Override
	public void start() {
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
