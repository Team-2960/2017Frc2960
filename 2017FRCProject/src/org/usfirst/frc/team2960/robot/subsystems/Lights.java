package org.usfirst.frc.team2960.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lights extends Subsystem {
	   DigitalOutput I1;
	   DigitalOutput I2;
	   DigitalOutput I3;
		public Lights(){
			I1 = new DigitalOutput(3);
			I2 = new DigitalOutput(4);
			I3 = new DigitalOutput(5);
			
		}
		public void setLights(int input1, int input2, int input3){
			SmartDashboard.putString("The led code", input1 + " " + input2 + " " + input3);
			if(input1==1)
				I1.set(true);
			else
				I1.set(false);
			if(input2==1)
				I2.set(true);
			else
				I2.set(false);
			if(input3==1)
				I3.set(true);
			else
				I3.set(false);
			
			
		}
		
		public void update() {
			// TODO Auto-generated method stub
			
		}
		
		
		public void start() {
			// TODO Auto-generated method stub
			
		}


		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
	}
//indicate when aligned with gear, boiler, within distance of boiler
