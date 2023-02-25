// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pneumatic extends SubsystemBase {
  /** Creates a new pneumatic. */ 
  DoubleSolenoid piston = new DoubleSolenoid(04,PneumaticsModuleType.CTREPCM, 0, 1);
  DoubleSolenoid piston2 = new DoubleSolenoid(04,PneumaticsModuleType.CTREPCM, 2, 3);

  public pneumatic() {}

  public void pistonOpen(){
  piston.set(Value.kForward);
  piston2.set(Value.kForward);
  }
  public void pistonClose(){
    piston.set(Value.kReverse);
    piston2.set(Value.kReverse);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
