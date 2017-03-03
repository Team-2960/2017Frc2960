package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Delay extends Command {

	double seconds;
	Timer timeToDelay;
	
	public Delay(double seconds){
		super("Delay");
		this.seconds = seconds / 1000;
		requires(Robot.drivetrain);
		timeToDelay = new Timer();
	}
	
	protected void initialize(){
		Robot.drivetrain.resetEncoder();
		timeToDelay.start();
	}
	
	protected void execute(){
		//SmartDashboard.putNumber("The timer value", timeToDelay.get());
	}
	
	
	
	@Override
	protected boolean isFinished() {
		if(timeToDelay.get() >= seconds){
			return true;
		}else{
			return false;
		}
	}

	
	protected void end(){
		timeToDelay.stop();
		timeToDelay.reset();
	}
	protected void interupted(){
		
	}
	
}
