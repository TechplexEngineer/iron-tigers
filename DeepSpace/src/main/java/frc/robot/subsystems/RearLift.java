/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import frc.robot.RearLiftPositions;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class RearLift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static TalonSRX rearLiftSRX = new TalonSRX(RobotMap.SRXRearLift);

  private static RearLift instance;

  private RearLift(){
    init();
  }

  public static RearLift getInstance(){
    if (instance == null){
      instance = new RearLift();
    }

    return instance;
  }


  //this is where we do all our intilization
  private void init(){

    rearLiftSRX.set(ControlMode.PercentOutput,0);
    rearLiftSRX.configFactoryDefault();
    rearLiftSRX.setNeutralMode(NeutralMode.Brake);

    //this is a very important line of code in order to make foward on motor line up with foward on encoder
    rearLiftSRX.setSensorPhase(true);

    rearLiftSRX.configForwardSoftLimitEnable(true);
    rearLiftSRX.configReverseSoftLimitEnable(true);

    rearLiftSRX.configForwardSoftLimitThreshold(RearLiftPositions.getHighestPosition());
    rearLiftSRX.configReverseSoftLimitThreshold(RearLiftPositions.getHomePosition());

    rearLiftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    
    rearLiftSRX.configNominalOutputForward(0,30);
    rearLiftSRX.configNominalOutputReverse(0,30);
    rearLiftSRX.configPeakOutputForward(1, 30);
    rearLiftSRX.configPeakOutputReverse(-1, 30);

    rearLiftSRX.configPeakCurrentLimit(3, 30);
    rearLiftSRX.configPeakCurrentDuration(5, 30);
    rearLiftSRX.configContinuousCurrentLimit(1, 30);
    rearLiftSRX.enableCurrentLimit(false); // Honor initial setting
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
