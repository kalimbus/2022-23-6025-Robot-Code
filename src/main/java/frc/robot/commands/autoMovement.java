// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class autoMovement extends CommandBase {
  /** Creates a new autoMovement. */
  public autoMovement(drivetrain m_drive) {
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  int encoderValue = 2048;
  int target = 150;
  double radiusWheel = 6 * 2.54/2;
  double wheelPerimeter = radiusWheel * 2 * Math.PI;
  double gearboxRatio = 72*50/14/22;
  double targetEncoderValue = ((target / wheelPerimeter)*gearboxRatio*encoderValue);
  double kP = 0.0000050;
  double kI = 0.000000025;
  double error = 0;
  double Error = 0;
  double curentPosition = RobotContainer.m_drive.encoderValueRight();
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Target Encoder Value", targetEncoderValue);
    SmartDashboard.putNumber("Encoder Before Reset", curentPosition);
    RobotContainer.m_drive.resetEncoders();
    SmartDashboard.putNumber("Encoder After Reset", curentPosition);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    curentPosition = RobotContainer.m_drive.encoderValueRight();
    error = targetEncoderValue - curentPosition;
    Error = Error + error;
    double pAdjusment = kP *error;
    double ıAdjustment = kI * Error;
    double speedPI = pAdjusment + ıAdjustment;
    RobotContainer.m_drive.setSpeed(speedPI);
    SmartDashboard.putNumber("Speed",speedPI);
    SmartDashboard.putNumber("Current Position", curentPosition);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (RobotContainer.m_drive.encoderValueRight() >  targetEncoderValue){
      return true;
    }else{
    return false;
    }
  }
}
