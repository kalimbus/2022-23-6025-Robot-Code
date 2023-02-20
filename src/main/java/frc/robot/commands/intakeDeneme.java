// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.kSpeed;
import frc.robot.subsystems.intakeMotor;

public class intakeDeneme extends CommandBase {
  /** Creates a new intakeDeneme. */
  public intakeDeneme(intakeMotor m_intake) {
    addRequirements(m_intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  boolean situtation = false;
  boolean situtation1 = false;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(situtation == false){
      RobotContainer.m_intake.setSpeed(kSpeed.kIntakeSpeed);
      situtation1 = true;
    }else if(situtation == true){
      RobotContainer.m_intake.setSpeed(-kSpeed.kIntakeSpeed);
      situtation1 = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_intake.setSpeed(kSpeed.kStop);
    if(situtation1 == true){
      situtation = true;
    }else if(situtation1 == false){
      situtation = false;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
