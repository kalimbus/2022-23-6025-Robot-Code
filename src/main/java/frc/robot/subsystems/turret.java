// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class turret extends SubsystemBase {
  /** Creates a new turret. */
  WPI_TalonFX turretMotor = new WPI_TalonFX(25);

  public turret() {}

  public void setSpeed(double speed){
    turretMotor.set(speed);
  }
  public double encoderValue(){
    return turretMotor.getSelectedSensorPosition();
  }
  public void resetEncoder(){
    turretMotor.setSelectedSensorPosition(0);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder value turret", encoderValue());
    // This method will be called once per scheduler run
  }
}
