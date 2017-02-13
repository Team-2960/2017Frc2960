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
	
	private static final double TARGET_HEIGHT = 10;
	private static final double THETA_Y = 36.305;
	
	private VisionThread visionThread;
	private VisionThread visionThreadBoiler;
	private double centerX = 0.0;
	private double X = 0.0;
	private double xWidth = 0.0;
	private double pixelsFromEdge = 0.0;
	private double pixelsFromEdgeBoiler = 0.0;
	private double centerX2 = 0.0;
	private double centerY = 0.0;
	private double centerY2 = 0.0;
	private double yHeightTotal = 0.0;
	private double boilerDist = 0.0;
	private int howManyBoxes = 0;
	private int frontAngleOfCamera = 55;
	private int backAngleOfCamera = 10;
	double testX;
	double testX2;
	double center;
	double height;
	double x;
	double width1;
	int amount;
	
	
	private final Object imgLock = new Object();
	private final Object imgLock2 = new Object();
	
	private UsbCamera camera;
	public Camera(int cameraPort){   
		//camera = new UsbCamera(name, "/dev/video0");
		camera = CameraServer.getInstance().startAutomaticCapture(cameraPort);
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		camera.setBrightness(0);
		startThread();
	}
	
	private void startThread(){
	
		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
			if(pipeline.filterContoursOutput().size() >= 1){
				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
				synchronized (imgLock){
					X = r.x;
					xWidth = r.width;
					centerX = r.x + (r.width / 2);
					howManyBoxes = pipeline.filterContoursOutput().size();
					if(pipeline.filterContoursOutput().size() >= 2){
						Rect r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));	
						centerX2 = r2.x + (r2.width / 2);
					}
					else
						centerX2 = 0;
					
				}
			}
			
			
		});
		visionThread.start();
	}
	
	
	
	
	@Override
	public void update() {
		
		//SmartDashboard.putString("camrea path", camera.getPath());
		
	
		synchronized(imgLock){
			x = this.X;
			width1 = this.xWidth;
			testX = this.centerX;
			amount = this.howManyBoxes;
			testX2 = this.centerX2;
		}
		
		pixelsFromEdge = (testX2 + testX) / 2;
		pixelsFromEdgeBoiler = centerX;
	
		boilerDist = TARGET_HEIGHT * IMG_HEIGHT / (yHeightTotal * Math.tan(Math.toRadians(THETA_Y)));
	}
	
	public double GetPixelsFromEdge(){
		return pixelsFromEdge;
	}
	public double GetPixelsFromEdgeBoiler(){
		return pixelsFromEdgeBoiler;
	}
	public double getBoilerDist(){
		return boilerDist;
	}
	public int getHowManyBoxes(){
		return amount;
	}
	public double getYheightTotal(){
		return yHeightTotal;
	}
	public double getPixelsFromEdge(){
		return pixelsFromEdge;
	}
	
	@Override
	public void start() {
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
