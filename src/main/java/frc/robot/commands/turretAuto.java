// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.turret;


public class turretAuto extends CommandBase {
  /** Creates a new turretAuto. */
  double gearboxRatio = 1.0/75.0;
  double currentEncoder = RobotContainer.m_turret.encoderValue();
  double encoderValue = 2048;
  double kP = 0.0000008;
  double kI = 0.000000010;
  double Error = 0;
  double error = 0;
  double targetEncoder = 0;
  public turretAuto(turret m_turret, double degree) {
   targetEncoder = (encoderValue / gearboxRatio * degree)/ 360;

    addRequirements(m_turret);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_turret.resetEncoder();
    System.out.println(targetEncoder);
    Timer.delay(3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Turret", targetEncoder);
    currentEncoder = RobotContainer.m_turret.encoderValue();
    error = targetEncoder - currentEncoder;
    Error = error+Error;
    double pAdjustment = error *kP;
    double iAdjustment = Error * kI;
    double piAdjustment = pAdjustment + iAdjustment;
    RobotContainer.m_turret.setSpeed(piAdjustment);
    SmartDashboard.putNumber("TurretSpeed", piAdjustment);
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