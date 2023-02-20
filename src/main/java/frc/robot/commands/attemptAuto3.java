// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.kSpeed;
import frc.robot.subsystems.attempt;

public class attemptAuto3 extends CommandBase {
  /** Creates a new attemptAuto3. */
  public attemptAuto3(attempt m_attempt) {
    addRequirements(m_attempt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.m_limit.getLimitSwitchState() == false && RobotContainer.m_limit.getLimitSwitchState2() == false){
      RobotContainer.m_attempt.setSpeed(kSpeed.kAttemptSpeed);
    }else if(RobotContainer.m_limit.getLimitSwitchState() == false){
      RobotContainer.m_attempt.setSpeedLeft(kSpeed.kAttemptSpeed);
    }else if(RobotContainer.m_limit.getLimitSwitchState2() == false){
      RobotContainer.m_attempt.setSpeedRight(kSpeed.kAttemptSpeed);
    }else{
      RobotContainer.m_attempt.setSpeed(kSpeed.kAttemptSpeed);
    }
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
