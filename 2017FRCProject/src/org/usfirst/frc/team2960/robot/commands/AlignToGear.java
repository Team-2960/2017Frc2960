package org.usfirst.frc.team2960.robot.commands;

import org.usfirst.frc.team2960.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlignToGear extends Command {
	boolean done;
	public AlignToGear(){
		super("AlignToGear");
		requires(Robot.drivetrain);
		done = false;
	}
	
	protected void initialize(){
		Robot.drivetrain.ringLightOn();
		Robot.drivetrain.isGearCam = true;
		Robot.drivetrain.isTurnOnly = false;
		Robot.drivetrain.autonTurnDone = false;
	}
	
	protected void execute(){
		Robot.drivetrain.setTurnToTarget(true);;
		if(Robot.drivetrain.autonTurnDone){
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
		Robot.drivetrain.setTurnToTarget(false);
		Robot.drivetrain.ringLightOff();
		Robot.drivetrain.stopPID();
	}
}