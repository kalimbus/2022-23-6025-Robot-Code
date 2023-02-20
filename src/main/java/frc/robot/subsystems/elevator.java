// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;




import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
  /** Creates a new elevator. */
  WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(05);
  

  public elevator() {

  }

  public void setSpeed(double speed){
    elevatorMotor.set(speed);
  }

  public double encoderValue(){
    return elevatorMotor.getSelectedSensorPosition();
  }

  public void resetEncoder(){
    elevatorMotor.setSelectedSensorPosition(0);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Encoder", encoderValue());
    // This method will be called once per scheduler run
  }
}
