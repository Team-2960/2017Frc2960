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
	private VisionThread visionThreadBoiler;
	private double centerX = 0.0;
	private double centerX2 = 0.0;
	private double centerY = 0.0;
	private double centerY2 = 0.0;
	private int howManyBoxes = 0;
	
	private final Object imgLock = new Object();
	private final Object imgLock2 = new Object();
	
	private UsbCamera camera;
	public Camera(){   
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		camera.setBrightness(0);
		startThread();
		startThreadBoiler();
	}
	
	private void startThread(){
	
		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
			if(pipeline.filterContoursOutput().size() >= 2){
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
				
				synchronized (imgLock){
					centerX = r.x + (r.width / 2);
					howManyBoxes = pipeline.filterContoursOutput().size();
					centerX2 = r2.x + (r2.width / 2);
				}
			}
		});
		visionThread.start();
	}
	
	
	private void startThreadBoiler(){
		
		visionThreadBoiler = new VisionThread(camera, new GripPipeline(), pipeline ->{
			if(pipeline.filterContoursOutput().size() >= 2){
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
			
			
				synchronized (imgLock2){
					centerY = r.x + (r.width / 2);
					centerY2 = r2.y + (r2.height / 2);
				}
			}
		});
		visionThreadBoiler.start();
	}
	
	@Override
	public void update() {
		double testX;
		double testX2;
		double testY;
		double testY2;
		double center;
		double height;
		int amount;
		synchronized(imgLock){
			testX = this.centerX;
			amount = this.howManyBoxes;
			testX2 = this.centerX2;
		}
		synchronized(imgLock2){
			testY = this.centerY;
			testY2 = this.centerY2;
		}
		if(testX > testX2){
			center = (testX - testX2) + testX;
		}
		else{
			center = (testX2 - testX) + testX2;
		}
		if(testY > testY2){
			height = (testY - testY2) + testY;
		}
		else{
			height = (testY2 - testY) + testY2;
		}
		
		SmartDashboard.putNumber("testX", testX);
		SmartDashboard.putNumber("how many boxes", amount);
		SmartDashboard.putNumber("TestX2", testX2);
		SmartDashboard.putNumber("center", center);
		SmartDashboard.putNumber("height", height);
		SmartDashboard.putNumber("TestY2", testY2);
		SmartDashboard.putNumber("testY", testY);
	}

	@Override
	public void start() {
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
