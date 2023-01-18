// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.navx;

public class navxCMD extends CommandBase {
  /** Creates a new navxCMD. */
  public navxCMD(navx m_navx ) {
    addRequirements(m_navx);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_navx.navxreset();;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("X", RobotContainer.m_navx.navxgetx());
    SmartDashboard.putNumber("Y", RobotContainer.m_navx.navxgety());
    SmartDashboard.putNumber("Z", RobotContainer.m_navx.navxgetz());
    SmartDashboard.putNumber("XA", RobotContainer.m_navx.navxgetxa());
    SmartDashboard.putNumber("YA", RobotContainer.m_navx.navxgetya());
    SmartDashboard.putNumber("ZA", RobotContainer.m_navx.navxgetza());
    SmartDashboard.putNumber("YAW", RobotContainer.m_navx.navxgetyaw());
    SmartDashboard.putNumber("PITCH", RobotContainer.m_navx.navxgetpitch());
    SmartDashboard.putNumber("ROLL", RobotContainer.m_navx.navxgetroll());
    SmartDashboard.putNumber("Angle", RobotContainer.m_navx.getangle());
    SmartDashboard.putNumber("Rate", RobotContainer.m_navx.getrate());
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
