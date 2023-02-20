// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class autoShifter extends CommandBase {
  /** Creates a new autoShifter. */
  boolean forward = true;
  //int time = 5 * 50;
  //int fiveSecond = 0;
  public autoShifter(drivetrain m_drive) {
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //fiveSecond = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {/* 
    if(RobotContainer.driverController.getRawAxis(1) < 0){
      forward = true;
    }else if(RobotContainer.driverController.getRawAxis(1)>0){
      forward = false;
    }
    if(forward){
      if(RobotContainer.m_accelerometer.getX()<0){
        System.out.println("Torque");
        RobotContainer.m_shifter.pistonOpen();
        for (int b = fiveSecond; b<time; b++){
          if(b == time){
            System.out.println("RPM");
            RobotContainer.m_shifter.pistonClose();
            fiveSecond = 0;
            break;
          }
        }
      }
    }else if(!forward){
      if(RobotContainer.m_accelerometer.getX()>0){
        System.out.println("Torque");
        RobotContainer.m_shifter.pistonOpen();
        for (int b = fiveSecond; b<time; b++){
          if(b == time){
            System.out.println("RPM");
            RobotContainer.m_shifter.pistonClose();
            fiveSecond = 0;
            break;
          }
        }
      }
    }*/
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
