// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class accelerometer extends SubsystemBase {
  /** Creates a new accelerometer. */
  Accelerometer roborioAccelerometer = new BuiltInAccelerometer();
  public accelerometer() {}

  public double getX(){
    return roborioAccelerometer.getX();
  }

  public double getY(){
    return roborioAccelerometer.getY();
  }

  public double getZ(){
    return roborioAccelerometer.getZ();
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("BX", getX());
    SmartDashboard.putNumber("BY", getY());
    SmartDashboard.putNumber("BZ", getZ());
    // This method will be called once per scheduler run
  }
}
