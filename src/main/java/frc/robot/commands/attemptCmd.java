// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.attempt;

public class attemptCmd extends CommandBase {
  /** Creates a new atteptCmd. */
  double situtation = 1;
  double situtation1 = 1;
  public attemptCmd(attempt m_attempt) {
    addRequirements(m_attempt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(situtation == 1){
      situtation1 = 1;
      situtation = 2;
      System.out.println("calis");
    }else if(situtation == 2){
      situtation1 = 2;
      situtation = 1;
      System.out.println("kapa");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(situtation1 == 1){
      RobotContainer.m_attempt.setSpeed(1);
    }else if(situtation1 == 2){
      RobotContainer.m_attempt.setSpeed(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
