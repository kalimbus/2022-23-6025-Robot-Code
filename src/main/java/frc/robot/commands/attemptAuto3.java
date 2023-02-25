// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.attempt;
import frc.robot.subsystems.telescopicArm;

public class attemptAuto3 extends CommandBase {
  /** Creates a new attemptAuto3. */
  public attemptAuto3(telescopicArm m_attempt) {
    addRequirements(m_attempt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_telescopic.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double targetOffsetAngle_Vertical = RobotContainer.m_telescopic.gettY();
    double encoderValue = RobotContainer.m_telescopic.encoderValue();
    // 
    double limelightMountAngleDegrees = 0;
    
    //
    double limelightLensHeightInches = 0; //değişebilir
    
    // 
    double goalHeightInches = 0 ;
    
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
    SmartDashboard.putNumber("target with encoder", distanceWithEncoderValue);
    SmartDashboard.putNumber("Speed Limelight", pAdjustment);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_attempt.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
