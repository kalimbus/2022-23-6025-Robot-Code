// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.kSpeed;
import frc.robot.subsystems.drivetrain;

public class turboDrive extends CommandBase {
  /** Creates a new turboDrive. */
  public turboDrive(drivetrain m_drive) {
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  double maxSpeedTurbo = kSpeed.kTurboSpeed;
  double maxSpeed = kSpeed.kMaxSpeed;
  boolean situation1 = false;
  boolean situation2 = false;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(situation1 == false){
    RobotContainer.m_drive.setMaxSpeed(maxSpeedTurbo);
    situation2 = true;
    }else if(situation1 == true){
    RobotContainer.m_drive.setMaxSpeed(maxSpeed);
    situation2 = false;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_drive.drive(RobotContainer.getMainController());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(situation2 == false){
      situation1 = false;
    }else if(situation2 == true){
      situation1 = true;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
