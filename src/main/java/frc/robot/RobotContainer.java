// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.attemptCmd;
import frc.robot.commands.navxCMD;
import frc.robot.commands.pneumaticCMD;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.attempt;
import frc.robot.subsystems.navx;
import frc.robot.subsystems.pneumatic;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final attempt m_attempt = new attempt();
  public static final pneumatic m_pneumatic = new pneumatic();
  public static final navx m_navx = new navx();


  boolean toggle = false;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  XboxController driver = new XboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    new JoystickButton(driver, 1).whileTrue(new attemptCmd(m_attempt));

    new JoystickButton(driver, 2).whileTrue(new pneumaticCMD(m_pneumatic));

    new JoystickButton(driver, 3).whileTrue(new navxCMD(m_navx));


    //new JoystickButton(driver, 3).whileTrue(new navxCMD(m_navx));


    /*if (driver.getRawButtonPressed(2)) {
       if (toggle) {
          // Current state is true so turn off
          System.out.println("arablar2");
          toggle = false;
       } else {
          // Current state is false so turn on
          System.out.println("arablar1");
          toggle = true;
       }
    }*/
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
