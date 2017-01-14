package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;
import org.opencv.*;
import edu.wpi.first.wpilibj.vision.VisionRunner;
public class Camera extends Subsystem implements PeriodicUpdate{
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	
	private final Object imgLock = new Object();
	
	private UsbCamera camera;
	public Camera(){
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		startThread();
		
	}
	
	private void startThread(){
		visionThread = new VisionThread(camera, new Pipeline(), pipeline -> {
			
		});
	}
	
	
	@Override
	public void update() {
		
		
	}

	@Override
	public void start() {
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
