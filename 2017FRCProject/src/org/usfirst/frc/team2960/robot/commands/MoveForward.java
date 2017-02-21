package org.usfirst.frc.team2960.robot.commands;



import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveForward extends Command {

	double distance;
	boolean done;
	public MoveForward(double distance){
		super("MoveForward");
		//this.distance = distance;
		requires(Robot.drivetrain);
		done = false;
	}
	
	protected void initialize(){
		Robot.drivetrain.setDistance(distance);
	}
	
	protected void execute(){
		Robot.drivetrain.shift(false);
		Robot.drivetrain.ringLightOn();
		Robot.drivetrain.startEncPID();
		Robot.drivetrain.setEncSetpoint(-400);
		if(Robot.drivetrain.isAutonOnGear){
			Robot.drivetrain.setEncSetpoint(0);
			done = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(done){
			Robot.drivetrain.ringLightOff();
			return true;
		}else{
			return false;
		}
	}
	
	protected void end(){
	}
	
	protected void interupted(){
	}

}
