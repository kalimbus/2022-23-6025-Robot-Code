// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class arcadeDrive extends CommandBase {
  /** Creates a new arcadeDrive. */
  public arcadeDrive(drivetrain m_drive) {
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  private double maxSpeed = 0.1;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_drive.setMaxSpeed(maxSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_drive.drive(RobotContainer.getMainController());
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
