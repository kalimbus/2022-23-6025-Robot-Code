// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class attempt extends SubsystemBase {
  /** Creates a new attept. */
  WPI_VictorSPX motor = new WPI_VictorSPX(02);
  public attempt() {
    motor.configFactoryDefault();

    motor.setNeutralMode(NeutralMode.Coast);
  }

  public void setSpeed(double speed){
    motor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
