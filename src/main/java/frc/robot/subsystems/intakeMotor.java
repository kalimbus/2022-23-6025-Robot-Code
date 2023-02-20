// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeMotor extends SubsystemBase {
  /** Creates a new intakeMotor. */
  WPI_VictorSPX intakeMotorLeft = new WPI_VictorSPX(05);
  WPI_VictorSPX intakeMotorRight = new WPI_VictorSPX(06);

  public intakeMotor() {
    intakeMotorLeft.configFactoryDefault();
    intakeMotorRight.configFactoryDefault();

    intakeMotorLeft.setNeutralMode(NeutralMode.Brake);
    intakeMotorRight.setNeutralMode(NeutralMode.Brake);
  }

  public void setSpeed(double speed){
    intakeMotorLeft.set(speed);
    intakeMotorRight.set(-speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
