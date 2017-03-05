package org.usfirst.frc.team2960.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {
	   boolean inputA;
	   boolean inputB;
	   boolean inputC;
	   DigitalOutput I1;
	   DigitalOutput I2;
	   DigitalOutput I3;
		public Lights(){
			I1 = new DigitalOutput(3);
			I2 = new DigitalOutput(4);
			I3 = new DigitalOutput(5);
			
		}
		public void setLights(int input1, int input2, int input3){
			if(input1==1)
				inputA = true;
			else
				inputA = false;
			if(input2==1)
				inputB = true;
			else
				inputB = false;
			if(input3==1)
				inputC = true;
			else
				inputC = false;
			
			
		}
		
		public void update() {
			I1.set(inputA);
			I2.set(inputB);
			I3.set(inputC);
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
