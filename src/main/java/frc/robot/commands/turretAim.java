// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.turret;

public class turretAim extends CommandBase {
  /** Creates a new turretAim. */
  public turretAim(turret m_turret) {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  double tx;
  double error = 0;
  double pAdjustment = 0;
  double currenttx;
  double targettx = 0;
  double minSpeed;
  double kP = 0.000000010;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pAdjustment = 0;
    error = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {/* 

    tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

    currenttx = tx;
    error = targettx -currenttx;
    pAdjustment = error* kP;
    
    RobotContainer.m_turret.setSpeed((minSpeed + -pAdjustment));
    RobotContainer.m_turret.setSpeed(-(minSpeed + -pAdjustment));

    SmartDashboard.putNumber("pTurret", pAdjustment);

    if(tx >= 0){
      minSpeed = 0.1;
    }else if(tx < 0){
      minSpeed = -0.1;
    }
*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //RobotContainer.m_turret.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
