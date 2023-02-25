// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.limelight;

public class limelightType extends CommandBase {
  /** Creates a new limelightType. */
  public limelightType(limelight m_limelight) {
    addRequirements(m_limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  double situation1 = 1;
  double situation2 = 1;
  double situation3 = 2;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(situation1 == 1){
      situation2 = 2;
      RobotContainer.m_limelight.setPipeline1();
      SmartDashboard.putString("Pipeline Type", "AprilTag");
    }else if(situation1 == 2){
       situation2 = 1;
       RobotContainer.m_limelight.setPipeline0();
       SmartDashboard.putString("Pipeline Type", "Reflective");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    if(situation2 == 2){
      situation1 = 2;
    }else if(situation2 == 1){
      situation1 = 1;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
