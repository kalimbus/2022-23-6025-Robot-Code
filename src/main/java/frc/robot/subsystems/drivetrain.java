// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  WPI_TalonFX motorLeft = new WPI_TalonFX(23);
  WPI_TalonFX motorRight = new WPI_TalonFX(21);
  WPI_TalonFX slaveLeft = new WPI_TalonFX(24);
  WPI_TalonFX slaveRight = new WPI_TalonFX(22);

  public DifferentialDrive robot = new DifferentialDrive(motorLeft, motorRight);

  //Motor Configruation
  public drivetrain() {
    motorLeft.configFactoryDefault();
    motorRight.configFactoryDefault();
    slaveLeft.configFactoryDefault();
    slaveRight.configFactoryDefault();

    motorLeft.setNeutralMode(NeutralMode.Brake);
    motorRight.setNeutralMode(NeutralMode.Brake);
    slaveLeft.setNeutralMode(NeutralMode.Brake);
    slaveRight.setNeutralMode(NeutralMode.Brake);

    slaveLeft.follow(motorLeft);
    slaveRight.follow(motorRight);

    motorLeft.setInverted(false);
    motorRight.setInverted(false);
    slaveLeft.setInverted(InvertType.FollowMaster);
    slaveRight.setInverted(InvertType.FollowMaster);

  }
  //Arcade Drive
  public void setMaxSpeed(double MaxSpeed){
    robot.setMaxOutput(MaxSpeed);
  }
  
  public void drive(double forward, double turn){
    robot.arcadeDrive(forward, turn);
  }

  public void drive(XboxController xBox){
    drive(-xBox.getRawAxis(4),-xBox.getRawAxis(1));
  }

  public void driveL(double Lmotor){
    motorLeft.set(Lmotor);
  }

  public void driveR(double Rmotor){
    motorRight.set(Rmotor);
  }
  public void stop(){
    motorLeft.set(0);
    motorRight.set(0);
  }

  //Enocoder Values
  public double encoderValueLeft(){
    return motorLeft.getSelectedSensorPosition();
  }

  public double encoderValueRight(){
    return motorRight.getSelectedSensorPosition();
  }

  public void resetEncoders(){
    motorLeft.setSelectedSensorPosition(0);
    motorRight.setSelectedSensorPosition(0);
    slaveLeft.setSelectedSensorPosition(0);
    slaveRight.setSelectedSensorPosition(0);
  }
  
  //Speed Selection
  public void setSpeed(double speed){
    motorLeft.set(-speed);
    motorRight.set(speed);
  }

  public void setSpeedLeft(double speed){
    motorLeft.set(speed);
    motorRight.set(speed);
  }

  public void setSpeedRight(double speed){
    motorLeft.set(-speed);
    motorRight.set(-speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Motor Encoder", encoderValueLeft());
    SmartDashboard.putNumber("Right Motor Encoder", encoderValueRight());
    // This method will be called once per scheduler run
  }
}
