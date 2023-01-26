// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class gyroArc extends CommandBase {
  /** Creates a new gyroArc. */
  public gyroArc(drivetrain m_drive) {
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  double kP = 0.0000050;
  double kI = 0.000000025;
  double error = 0;
  double Error = 0;
  double currentAngle;
  double targetAngle;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_gyro.gyroCalibrate();
    RobotContainer.m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentAngle = RobotContainer.m_gyro.getgyro();

    error = targetAngle - currentAngle;
    //double pAdjustment = kP * error;
    //Finishing after it
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
