// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class armWristAuto extends CommandBase {
  /** Creates a new armWristAuto. */
  public armWristAuto() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {/*
    double currentPosition = RobotContainer.m_armwrist.encoderValue();
    double targetPosition = (-RobotContainer.m_elevator.encoderValue());
    double error = targetPosition - currentPosition;
    double kP = 0.0000000010;
    double pAdjustment = kP*error;
    RobotContainer.m_armwrist.setSpeed(pAdjustment);*/
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
