// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.pneumatic;

public class pneumaticCMD extends CommandBase {
  double situation = 2;
  int situation1 = 0;
  boolean terminator = false;
  
  /** Creates a new pneumaticCMD. */
  public pneumaticCMD(pneumatic m_pneumatic) {
    addRequirements(m_pneumatic);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(situation == 1){
      RobotContainer.m_pneumatic.pistonOpen();
      situation1 = 1;
      System.out.println("Actim");
    }
    else if (situation  == 2){
      RobotContainer.m_pneumatic.pistonClose();
      situation1 = 2;
      System.out.println("Kapadim");
    }
  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(situation1 == 1){
      situation = 2;
    }
    else if( situation1 == 2){
      situation = 1;
    }
  } 

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
