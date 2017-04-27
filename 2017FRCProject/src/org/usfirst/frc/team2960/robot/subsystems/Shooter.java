package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements PeriodicUpdate{

	public CANTalon shoot;
	double speed = 1;//should be .9
	boolean canMove = false;
	//DigitalInput shooterPhotoeye;
	Timer photoeyeTripped;
	double photoeyeTime = .3;
	PIDController shootPID;
	ShooterPIDInput shootPidInput;
	ShooterPIDOutput shootPidOutput;
	public boolean autoMode = false;
	DriveTrain drive;
	
	public Shooter(DriveTrain drive){
		shoot = new CANTalon(RobotMap.shooter);
		shootPidInput = new ShooterPIDInput(this);
		shootPidOutput = new ShooterPIDOutput(this);
		shoot.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shootPidInput.setPIDSourceType(PIDSourceType.kRate);
		shoot.reverseSensor(true);
		shootPID = new PIDController(RobotMap.p2,RobotMap.i2,RobotMap.d2,shootPidInput,shootPidOutput);
		//shooterPhotoeye = new DigitalInput(RobotMap.ShooterPhotoeye);
		photoeyeTripped =new Timer();
		this.drive = drive;
	}
	
	
	public void startPID(){
		shootPID.enable();
	}
	
	public void stopPID(){
		shootPID.disable();
	}
	
	
	public void setSetpoint(double setpoint){
		shootPID.setSetpoint(setpoint);
	}
	
	public void turnONOFF(boolean onOff){
		canMove = onOff;
		
	}
	public void runShooter(){
		if(canMove)
			shoot.set(speed);
		else
			shoot.set(0);
	}
	public void pulseShooter(){
		//if(shooterPhotoeye.get()){
			speed = 1;
			photoeyeTripped.start();
		//}
		//else if(photoeyeTripped.get() > photoeyeTime){
			photoeyeTripped.stop();
			photoeyeTripped.reset();
			speed = .9;
		}
	//}
	
	
	@Override
	public void update() {
		//runShooter();
		//pulseShooter();
		//SmartDashboard.putNumber("Speed of shooter", speed);
		//SmartDashboard.putNumber("Shooter Encoder Position", shoot.getPosition());
		SmartDashboard.putNumber("Shooter Encoder Velocity", shoot.getEncVelocity());
		//SmartDashboard.putBoolean("Shooter Photoeye", shooterPhotoeye.get());
		//SmartDashboard.putBoolean("Shooter PId Enabled", shootPID.isEnabled());
		SmartDashboard.putNumber("Shooter setpoint", shootPID.getSetpoint());
		if(autoMode){
			autoShoot();
		}
	}
	public void autoShoot(){
		double yTotal = drive.getBoilerCam().getYTotal();
		double[] yDist = {134,157,196};
		double[] speed = {23750,22300,21600};
		for(int x =0; x < yDist.length; x++){
			if(yDist[x] > yTotal){
				setSetpoint(speed[x]);
				return;
			}
		}
		
	}
	@Override
	public void start() {
		shootPID.disable();
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
