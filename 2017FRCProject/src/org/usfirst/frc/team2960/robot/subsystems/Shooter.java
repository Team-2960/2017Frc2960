package org.usfirst.frc.team2960.robot.subsystems;

import org.usfirst.frc.team2960.robot.PeriodicUpdate;
import org.usfirst.frc.team2960.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements PeriodicUpdate{

	CANTalon shoot;
	double speed = .90;//should be .9
	boolean canMove = false;
	
	
	public Shooter(){
		shoot = new CANTalon(RobotMap.shooter);
		shoot.setP(RobotMap.p2);
		shoot.setI(RobotMap.i2);
		shoot.setD(RobotMap.d2);
		shoot.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shoot.setPIDSourceType(PIDSourceType.kRate);
	}
	
	
	public void startPID(){
		shoot.enable();
		setSetpoint(5);
	}
	
	public void stopPID(){
		shoot.disable();
	}
	
	
	public void setSetpoint(double setpoint){
		shoot.setSetpoint(setpoint);
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
	
	
	@Override
	public void update() {
		runShooter();
		SmartDashboard.putNumber("Speed of shooter", speed);
		SmartDashboard.putNumber("Shooter Encoder Position", shoot.getPosition());
		SmartDashboard.putNumber("Shooter Encoder Velocity", shoot.getEncVelocity());
		
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		shoot.setPosition(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
