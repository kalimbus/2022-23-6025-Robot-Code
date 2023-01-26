// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class telescopicArm extends SubsystemBase {
  /** Creates a new telescopicArm. */
  WPI_VictorSPX telescopicArm = new WPI_VictorSPX(04);
  Encoder telescopicEncoder = new Encoder(1, 2);
  public telescopicArm() {}

  public void setSpeed(double speed){
    telescopicArm.set(speed);
  }

  public double encoderValue(){
    return telescopicArm.get();
  }

  public void resetEncoder(){
    telescopicEncoder.reset();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Value", encoderValue());
    // This method will be called once per scheduler run
  }
}
