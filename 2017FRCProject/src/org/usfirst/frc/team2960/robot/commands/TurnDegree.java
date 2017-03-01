package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnDegree extends Command{

	boolean done;
	double seconds;
	double rate;
	Timer lengthOfTurn;
	
	public TurnDegree(double seconds, double rate){
		super("TurnDegree");
		requires(Robot.drivetrain);
		this.seconds = seconds;
		this.rate = rate;
		lengthOfTurn = new Timer();
		Robot.drivetrain.isTurnOnly = false;
		done = false;
	}
	
	protected void initialize(){
	lengthOfTurn.start();
	Robot.drivetrain.setSetpoint(rate);
	Robot.drivetrain.autonTurn = true;
	Robot.drivetrain.startPID();
	
	}
	
	protected void execute(){
		
	}
	
	
	@Override
	protected boolean isFinished() {
		if(lengthOfTurn.get() >= seconds){
			return true;
		}else{
			return false;
		}
	}
	
	protected void end(){
		Robot.drivetrain.stopPID();
		lengthOfTurn.stop();
		lengthOfTurn.reset();
		Robot.drivetrain.autonTurn = false;
		
	}
}
