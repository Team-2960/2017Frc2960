package org.usfirst.frc.team2960.robot;

public class AutonomousCommand {
	public int stage = 0;
	protected int finalStage = 0;
	
	public void updateloop(){
		if(isFinished()){
			Autonomous.stopAuton();
		}
	}
	
	public double getSecondsDone(){
		return Autonomous.timerValue/100;
	}
	public void finish(){
		stage = finalStage + 1;
	}
	public void finishStage(){
		stage += 1;
	}
	public boolean isFinished() {
		
		return stage > finalStage;
	}
}
