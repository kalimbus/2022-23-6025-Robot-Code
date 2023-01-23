// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arm extends SubsystemBase {
  /** Creates a new arm. */
  WPI_TalonFX kaanunkolu = new WPI_TalonFX(26);
  public arm() {}

  public void setSpeed(double speed){
    kaanunkolu.set(speed);
  }

  public double encoderValue(){
    return kaanunkolu.getSelectedSensorPosition();
  }

  public void resetEnc(){
    kaanunkolu.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder", encoderValue());
    // This method will be called once per scheduler run
  }
}
