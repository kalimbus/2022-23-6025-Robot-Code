// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class analogGyro extends SubsystemBase {
  /** Creates a new analogGyro. */
  ADXRS450_Gyro gyroAD = new ADXRS450_Gyro();

  public analogGyro() {}

  public double getgyro(){
    return gyroAD.getAngle();
  }

  public void gyroCalibrate(){
    gyroAD.calibrate();
  }

  public boolean isConnected(){
    return gyroAD.isConnected();
  }


  @Override
  public void periodic() {
    SmartDashboard.putBoolean("is Connected gyro", isConnected());
    SmartDashboard.putNumber("gyro value", getgyro());
    // This method will be called once per scheduler run
  }
}
