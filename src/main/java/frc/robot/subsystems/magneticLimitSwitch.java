// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class magneticLimitSwitch extends SubsystemBase {
  /** Creates a new magneticLimitSwitch. */
  DigitalInput limitSwitch = new DigitalInput(0);
  DigitalInput limitSwitch2 = new DigitalInput(1);
  public magneticLimitSwitch() {}

  public boolean getLimitSwitchState(){
    return limitSwitch.get();
  }
  public boolean getLimitSwitchState2(){
    return limitSwitch2.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("statusoflimit", getLimitSwitchState());
    SmartDashboard.putBoolean("statusoflimi2", getLimitSwitchState2());
    // This method will be called once per scheduler run
  }
}
