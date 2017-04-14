package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveForwardUltra extends Command {
	double distance;
	double speed;
	boolean done;
	public MoveForwardUltra(double distance, double speed){
		super("MoveForwardUltra");
		this.distance = distance;
		this.speed = speed;
		requires(Robot.drivetrain);
		done = false;
	}
	
	protected void initialize(){
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		done = Robot.drivetrain.moveForwardUltra(distance, speed);
		
		
	}
	
	@Override
	protected boolean isFinished() {
		if(done){
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
