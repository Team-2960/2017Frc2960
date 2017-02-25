package org.usfirst.frc.team2960.robot.commands;
import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveForward extends Command {

	double distance;
	boolean done;
	public MoveForward(double distance){
		super("MoveForward");
		this.distance = distance;
		requires(Robot.drivetrain);
		done = false;
	}
	
	protected void initialize(){
		Robot.drivetrain.setDistance(distance);
		Robot.drivetrain.isTurnOnly = false;
	}
	protected void execute(){
		Robot.drivetrain.shift(false);
		if(Robot.drivetrain.gotToDistance()){
			done = true;
		}
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
