package org.usfirst.frc.team4041.robot.commandGroups.auto;

import org.usfirst.frc.team4041.robot.commands.auto.Auto_ClawExtendToScaleShoot;
import org.usfirst.frc.team4041.robot.commands.auto.Auto_ClawExtendToVertical;
import org.usfirst.frc.team4041.robot.commands.auto.Auto_ClawIntakeShoot;
import org.usfirst.frc.team4041.robot.commands.auto.Auto_DriveStraight;
import org.usfirst.frc.team4041.robot.commands.auto.Auto_ElevatorToScale;
import org.usfirst.frc.team4041.robot.commands.auto.Auto_TurnToAngle;
import org.usfirst.frc.team4041.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftLeftScale extends CommandGroup {

    public AutonomousLeftLeftScale() {

    	System.out.println("run auto left left scale");
    	
    	DriveTrain driveTrain  = DriveTrain.getInstance();
    	double speed = 0.45;
    	double angle = 90;
    	double default_timeout = 7;
    	double short_timeout = 2;
    	
    	driveTrain.resetGyro();
    	driveTrain.resetLeftEncoder();
    	driveTrain.resetRightEncoder();

    	//step0
    	addSequential(new Auto_ClawExtendToVertical(),1);
    	//Step 1
    	addSequential(new Auto_DriveStraight(265, speed), default_timeout);
    	//Step 2
    	addSequential(new Auto_TurnToAngle(angle), default_timeout);
    	//Step 3
    	addSequential(new Auto_ClawExtendToScaleShoot(),short_timeout);
    	//Step 4
    	addSequential(new Auto_ElevatorToScale(), default_timeout);
    	//Step 5
    	addSequential(new Auto_DriveStraight(16, speed), default_timeout);
    	//Step 6
    	addSequential(new Auto_ClawIntakeShoot(),short_timeout);

    }
}
