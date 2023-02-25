// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class telescopicArm extends SubsystemBase {
  /** Creates a new telescopicArm. */
  WPI_TalonSRX telescopicArm = new WPI_TalonSRX(11);
  
  public telescopicArm() {
    telescopicArm.configFactoryDefault();

    telescopicArm.setNeutralMode(NeutralMode.Coast);

    telescopicArm.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  public void setSpeed(double speed){
    telescopicArm.set(speed);
  }

  public double encoderValue(){
    return telescopicArm.getSelectedSensorPosition();
  }

  public void resetEncoder(){
    telescopicArm.setSelectedSensorPosition(0);
  }

  public double gettY(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Value", encoderValue());
    // This method will be called once per scheduler run
  }
}
