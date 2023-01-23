// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class armWrist extends SubsystemBase {
  /** Creates a new arm. */
  WPI_TalonFX armWristMotor = new WPI_TalonFX(26);
  public armWrist() {}

  public void setSpeed(double speed){
    armWristMotor.set(speed);
  }

  public double encoderValue(){
    return armWristMotor.getSelectedSensorPosition();
  }

  public void resetEnc(){
    armWristMotor.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder", encoderValue());
    // This method will be called once per scheduler run
  }
}
