// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class colorSensor extends SubsystemBase {
  /** Creates a new colorSensor. */
  public final I2C.Port ic2Port = I2C.Port.kOnboard;
  public final ColorSensorV3 m_colorsensor = new ColorSensorV3(ic2Port);
  public ColorMatch colormatcher = new ColorMatch();

  public final Color blue = new Color(0, 0.181, 0.236);
  public  final Color green = new Color(0.197, 0.561, 0.240);
  public final Color red = new Color(0.561, 0.232, 0.114);
  public final Color yellow = new Color(0.361, 0.524, 0.113);
  public final Color purple = new Color(0.131,0.111,0.255);


  public colorSensor() {
    colormatcher.addColorMatch(blue);
    colormatcher.addColorMatch(green);
    colormatcher.addColorMatch(red);
    colormatcher.addColorMatch(yellow);
    colormatcher.addColorMatch(purple);
  }
  public Color detectedColor = m_colorsensor.getColor();
  public ColorMatchResult match = colormatcher.matchClosestColor(detectedColor);
  public boolean terminator = false;
  public boolean terminator2 = false;

  @Override
  public void periodic() {
        // This method will be called once per scheduler run
       Color detectedColor = m_colorsensor.getColor();

        String colorString;
        ColorMatchResult match = colormatcher.matchClosestColor(detectedColor);
    
        if(match.color == blue){
          colorString = "Blue";
          terminator = false;
        }else if (match.color == green){
          colorString = "Green";
          terminator= false;
        }else if(match.color == red){
          colorString = "Red";
          terminator= false;
        }else if(match.color == yellow){
          colorString = "Yellow";
          terminator= true;
          terminator2 = false;
        }else if(match.color == purple){
          colorString = "Purple";
          terminator2 = true;
          terminator = false;
        }
        else{
          colorString = "Unknown";
          terminator= false;
        }
    
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
    // This method will be called once per scheduler run
  }
}
