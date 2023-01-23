// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.accelerometerCMD;
import frc.robot.commands.arcadeDrive;
import frc.robot.commands.armdown;
import frc.robot.commands.armup;
import frc.robot.commands.attemptAuto;
import frc.robot.commands.autoMovement;
//import frc.robot.commands.attemptCmd;
import frc.robot.commands.gyroCMD;
import frc.robot.commands.wristArm;
import frc.robot.subsystems.accelerometer;
import frc.robot.subsystems.analogGyro;
import frc.robot.subsystems.arm;
import frc.robot.subsystems.attempt;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.intakeWrist;
import frc.robot.subsystems.navx;
import frc.robot.subsystems.pneumatic;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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
  
  //Subsystems
  public static final attempt m_attempt = new attempt();
  public static final pneumatic m_pneumatic = new pneumatic();
  public static final navx m_navx = new navx();
  public static final drivetrain m_drive = new drivetrain();
  public static final analogGyro m_gyro = new analogGyro();
  public static final accelerometer m_accelerometer = new accelerometer();
  public static final arm m_arm = new arm();
  public static final intakeWrist m_iwrist = new intakeWrist();

  //Commands
  public static final attemptAuto m_attemptauto = new attemptAuto(m_drive);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final XboxController driver = new XboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_drive.setDefaultCommand(new arcadeDrive(m_drive));
    m_iwrist.setDefaultCommand(new wristArm(m_iwrist));
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
    new JoystickButton(driver, 1).whileTrue(new gyroCMD(m_gyro));
    
    new JoystickButton(driver, 2).whileTrue(new accelerometerCMD(m_accelerometer));

    new JoystickButton(driver, 3).whileTrue(new armup(m_arm));

    new JoystickButton(driver, 4).whileTrue(new armdown(m_arm));

    //new JoystickButton(driver, 3).whileTrue(new navxCMD(m_navx));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return m_attemptauto;
    return new SequentialCommandGroup(
      new autoMovement(m_drive),
      new attemptAuto(m_drive),
      new autoMovement(m_drive)
    );
  }

  public static XboxController getMainController(){
    return driver;
  }
}
