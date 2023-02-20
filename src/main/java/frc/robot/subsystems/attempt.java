// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class attempt extends SubsystemBase {
  /** Creates a new attept. */
  //WPI_VictorSPX motor = new WPI_VictorSPX(04);
  WPI_VictorSPX motor2 = new WPI_VictorSPX(05);
  WPI_VictorSPX motor3 = new WPI_VictorSPX(06);
  //WPI_VictorSPX motor4 = new WPI_VictorSPX(07);
  public attempt() {
    //motor.configFactoryDefault();
    motor2.configFactoryDefault();
    motor3.configFactoryDefault();
    //motor4.configFactoryDefault();

    //motor.setNeutralMode(NeutralMode.Coast);
    motor2.setNeutralMode(NeutralMode.Coast);
    motor3.setNeutralMode(NeutralMode.Coast);
    //motor4.setNeutralMode(NeutralMode.Coast);

    //motor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  public void setSpeed(double speed){
    //motor.set(speed);
    motor2.set(speed);
    motor3.set(speed);
    //motor4.set(speed);
  }

  public void setSpeedLeft(double speed){
    motor2.set(speed);
  }
  public void setSpeedRight(double speed){
    motor3.set(speed);
  }
/* 
  public double encoderValue(){
    return motor.getSelectedSensorPosition();
  }

  public void resetEncoder(){
    motor.setSelectedSensorPosition(0);
  }*/
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Robotun ozel isi", 31);
    // This method will be called once per scheduler run
  }
}
