// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class limelight extends SubsystemBase {
  /** Creates a new limelight. */
  NetworkTable ll_table = NetworkTableInstance.getDefault().getTable("limelight");

  NetworkTableEntry tx = ll_table.getEntry("tx");
  NetworkTableEntry ty = ll_table.getEntry("ty");
  NetworkTableEntry ta = ll_table.getEntry("ta");

  public limelight() {}


  public void setPipeline0(){
    ll_table.getEntry("pipeline").setNumber(0);
  }
  public void setPipeline1() {
    ll_table.getEntry("pipeline").setNumber(1);
  }
  public double gettY(){
    return ll_table.getEntry("ty").getDouble(0);
  }

  @Override
  public void periodic() {
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    SmartDashboard.putNumber("Limelight X", x);
    SmartDashboard.putNumber("Limelight Y", y);
    SmartDashboard.putNumber("Limelight Area", area);
    
    // This method will be called once per scheduler run
  }
}
