// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
//import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class attemptAuto extends CommandBase {
  /** Creates a new attemptAuto. */
  boolean terminator = false;
  public attemptAuto(drivetrain m_attempt) {
    addRequirements(m_attempt);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.m_drive.resetEncoders();
    RobotContainer.m_gyro.gyroCalibrate();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //PIDController pAdjustment = new PIDController(0.0050, 0, 0);
    //motor.set(pAdjustment.calculate(RobotContainer.m_gyro.getgyro(), 90));
    //double kP = 0.0050;
    //double currentAngle = RobotContainer.m_gyro.getgyro();
    //double targetAngle = 90;
    //double error = targetAngle - currentAngle;
    /*double gearboxRatio = 72*50/14/22;
    double target = (((70*2*Math.PI)/4)/(6*2.54*2*Math.PI))*gearboxRatio*2048;
    double currentDistance = RobotContainer.m_drive.encoderValueRight();
    double error = target - currentDistance;
    double speedP = kP *error;
    SmartDashboard.putNumber("target", target);
    SmartDashboard.putNumber("Current Distance", currentDistance);
    SmartDashboard.putNumber("Speed", speedP);*/
    SmartDashboard.putNumber("gyro after reset", RobotContainer.m_gyro.getgyro());
    if(RobotContainer.m_gyro.getgyro() < 90){
      //RobotContainer.m_drive.setSpeedRight(pAdjustment);
      SmartDashboard.putBoolean("result", terminator);
      //SmartDashboard.putNumber("Speed", pAdjustment);
    }else{
      RobotContainer.m_drive.setSpeedRight(0);
      terminator = true;
    }
    SmartDashboard.putBoolean("value", terminator);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Timer.delay(2);
    RobotContainer.m_drive.setSpeedRight(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(RobotContainer.m_gyro.getgyro() < 88){
      return false;
    }else{
      return true;
    }
  }
}
