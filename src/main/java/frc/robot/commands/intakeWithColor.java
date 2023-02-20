// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.pneumatic;

public class intakeWithColor extends CommandBase {
  /** Creates a new intakeWithColor. */
  public intakeWithColor(pneumatic m_pneumatic) {
    addRequirements(m_pneumatic);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.m_color.terminator == true){
      RobotContainer.m_pneumatic.pistonClose();
      SmartDashboard.putString("Mevcut Parca", "Koni");
    }else if(RobotContainer.m_color.terminator2 == true){
      RobotContainer.m_pneumatic.pistonOpen();
      SmartDashboard.putString("Mevcut Parca", "Küp");
    }else if(RobotContainer.driverController.getRawButton(3)){
      RobotContainer.m_pneumatic.pistonOpen();
      System.out.println("actim");
    }
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
