// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.attempt;

public class attemptAuto2 extends CommandBase {
  /** Creates a new attemptAuto2. */
  PIDController pAdjustment = new PIDController(0.0000050, 0.000000025, 0.000000001);
  double distance = 25;
  double encoder = 2048;
  double targetDistance = distance * encoder;
  double currentPosition = 0;
  public attemptAuto2(attempt m_attempt) {
    addRequirements(m_attempt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.m_attempt.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    //currentPosition = RobotContainer.m_attempt.encoderValue();
    RobotContainer.m_attempt.setSpeed(pAdjustment.calculate(currentPosition, targetDistance));
    SmartDashboard.putNumber("SpeedTalon", pAdjustment.calculate(currentPosition, targetDistance));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_attempt.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(currentPosition >= targetDistance){
      return true;
    }else{
    return false;
    }
  }
}
