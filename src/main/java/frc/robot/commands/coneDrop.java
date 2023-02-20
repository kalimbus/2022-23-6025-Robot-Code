// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;

public class coneDrop extends CommandBase {
  /** Creates a new coneDrop. */
  public coneDrop() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {/* 
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry ty = table.getEntry("ty");
  double targetOffsetAngle_Vertical = ty.getDouble(0.0);
  double encoderValue = RobotContainer.m_telescopic.encoderValue();
  // 
  double limelightMountAngleDegrees = 0;
  
  //
  double limelightLensHeightInches = 20.0; //değişebilir
  
  // 
  double goalHeightInches = 22.05 ;
  
  double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
  double angleToGoalRadians = angleToGoalDegrees * (Math.PI / 180.0);
  
  //
  double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians);

  double distanceFromMeter = distanceFromLimelightToGoalInches * 2.54;

  double distanceWithEncoderValue = distanceFromMeter * 2048;

  double error = distanceWithEncoderValue - encoderValue;
  double kP = 0.000000010;

  double pAdjustment = kP * error;
  RobotContainer.m_telescopic.setSpeed(pAdjustment);
  if(encoderValue > distanceWithEncoderValue){
    RobotContainer.m_telescopic.setSpeed(0);
  }*/
}


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
