// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.arcadeDrive;
//import frc.robot.commands.armWristDown;
//import frc.robot.commands.armWristUp;
import frc.robot.commands.attemptAuto;
//import frc.robot.commands.attemptAuto2;
import frc.robot.commands.attemptAuto3;
import frc.robot.commands.indrop;
import frc.robot.commands.intake;
import frc.robot.commands.intakeDeneme;
import frc.robot.commands.intakeWithColor;
//import frc.robot.commands.attemptAuto2;
//import frc.robot.commands.attemptCMD2;
//import frc.robot.commands.attemptCmd;
//import frc.robot.commands.pneumaticCMD;
//import frc.robot.commands.indrop;
//import frc.robot.commands.intake;
//import frc.robot.commands.pneumaticCMD;
//import frc.robot.commands.autoMovement;
//import frc.robot.commands.attemptCmd;
//import frc.robot.commands.gyroCMD;
//import frc.robot.commands.pneumaticCMD;
//import frc.robot.commands.intakeWristCmd;
import frc.robot.subsystems.accelerometer;
import frc.robot.subsystems.analogGyro;
//import frc.robot.subsystems.armWrist;
import frc.robot.subsystems.attempt;
import frc.robot.subsystems.colorSensor;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.intakeMotor;
import frc.robot.subsystems.magneticLimitSwitch;
//import frc.robot.subsystems.elevator;
//import frc.robot.subsystems.intakeWrist;
import frc.robot.subsystems.navx;
import frc.robot.subsystems.pneumatic;
//import frc.robot.subsystems.shifter;
//import frc.robot.subsystems.telescopicArm;
//import frc.robot.subsystems.turret;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
  public static final intakeMotor m_intake = new intakeMotor();
  public static final magneticLimitSwitch m_limit = new magneticLimitSwitch();
  public static final colorSensor m_color = new colorSensor();
  //public static final shifter m_shifter = new shifter();
  //public static final armWrist m_armwrist = new armWrist();
  //public static final intakeWrist m_iwrist = new intakeWrist();
  //public static final turret m_turret = new turret();
  //public static final telescopicArm m_telescopic = new telescopicArm();
  //public static final elevator m_elevator = new elevator();
 
  //Commands
  public static final attemptAuto m_attemptauto = new attemptAuto(m_drive);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final XboxController driverController = new XboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_drive.setDefaultCommand(new arcadeDrive(m_drive));
    m_pneumatic.setDefaultCommand(new intakeWithColor(m_pneumatic));
    //m_iwrist.setDefaultCommand(new intakeWristCmd(m_iwrist));
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
    //new JoystickButton(driverController, 1).whileTrue(new attemptCmd(m_attempt));
    //new JoystickButton(driverController, 2).whileTrue(new attemptCMD2(m_attempt));
    //new JoystickButton(driverController, 3).whileTrue(new pneumaticCMD(m_pneumatic));
    new JoystickButton(driverController, 1).whileTrue(new intake(m_intake));
    new JoystickButton(driverController, 2).whileTrue(new indrop(m_intake));
    new JoystickButton(driverController, 4).whileTrue(new intakeDeneme(m_intake));

  


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
    /*return new SequentialCommandGroup(
      new autoMovement(m_drive),
      new attemptAuto(m_drive),
      new autoMovement(m_drive)
    );*/
    return new attemptAuto3(m_attempt);
  }

  public static XboxController getMainController(){
    return driverController;
  }
}
