package org.usfirst.frc.team4041.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;

import org.usfirst.frc.team4041.robot.RobotMap;

public class Waterfall extends Subsystem {

	static final VictorSP waterfallVictor = new VictorSP(RobotMap.waterfallVictor);
	private static Waterfall instance;
	
	private Waterfall(){
		
		initialize();
	}
	
    public static Waterfall getInstance() {
    	
        if (instance == null) {
            instance = new Waterfall();
        }
        return instance;
    }
    
    public void initialize() {
    	
    }
    
    public void startWaterfall(double speed){
    	
    	waterfallVictor.set(speed);
    }
    
    public void stopWaterfall(){
    	
    	waterfallVictor.set(RobotMap.STOP);
    }
   
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}