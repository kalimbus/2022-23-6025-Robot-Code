// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeWrist extends SubsystemBase {
  /** Creates a new intakeWrist. */
  WPI_VictorSPX wristMotor = new WPI_VictorSPX(01);
  Encoder wristEncoder = new Encoder(0, 1);
  public intakeWrist() {
  }
  public void setSpeed(double speed){
    wristMotor.set(speed);
  }

  public void resetEnc(){
    wristEncoder.reset();
  }

  public double encoderValue(){
    return wristEncoder.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder", encoderValue());
    // This method will be called once per scheduler run
  }
}
