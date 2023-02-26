// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
  /** Creates a new intake. */
  //Motors
  WPI_TalonSRX intakeWrist = new WPI_TalonSRX(02);
  WPI_VictorSPX intakeMotor1 = new WPI_VictorSPX(05);
  WPI_VictorSPX intakeMotor2 = new WPI_VictorSPX(06);
  //Pistons
  DoubleSolenoid intakePiston1 = new DoubleSolenoid(04,PneumaticsModuleType.CTREPCM, 0, 1);
  DoubleSolenoid intakePiston2 = new DoubleSolenoid(04,PneumaticsModuleType.CTREPCM, 2, 3);
  
  public intake() {
    intakeWrist.configFactoryDefault();
    intakeMotor1.configFactoryDefault();
    intakeMotor2.configFactoryDefault();

    intakeWrist.setNeutralMode(NeutralMode.Brake);
    intakeMotor1.setNeutralMode(NeutralMode.Brake);
    intakeMotor2.setNeutralMode(NeutralMode.Brake);

    intakeWrist.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0 , 10);

  }

  public void setSpeedIntake(double speed){
    intakeMotor1.set(speed);
    intakeMotor2.set(speed); 
   }

  public void setSpeedWrist(double speed){
    intakeWrist.set(speed);
  }

  public void intakeOpen(){
    intakePiston1.set(Value.kForward);
    intakePiston2.set(Value.kForward);
  }

  public void intakeClose(){
    intakePiston1.set(Value.kReverse);
    intakePiston2.set(Value.kReverse);
  }

  public void resetEncoderValueWrist(){
    intakeWrist.setSelectedSensorPosition(0);
  }

  public double getEncoderValueWrist(){
    return intakeWrist.getSelectedSensorPosition();
  }

 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
