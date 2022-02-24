// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final ClimberSubsystem m_climber = new ClimberSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final WristSubsystem m_wrist = new WristSubsystem();

  //autos
  private final Command ActualAuto = new ActualAuto(m_drive, m_arm, m_wrist, m_intake);
  private final Command SimpleAuto = new SimpleAuto(m_drive, m_arm, m_wrist, m_intake);

  //sendable chooser
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  //setting controllers
  XboxController Driver1 = new XboxController(Constants.DRIVER1_STICKS);
  XboxController Driver2 = new XboxController(Constants.DRIVER2_STICKS);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drive.setDefaultCommand( 
      
      new RunCommand(
        () ->
          m_drive.arcadeDrive(Driver1.getY(GenericHID.Hand.kLeft), 
                              Driver1.getX(GenericHID.Hand.kRight)),
          m_drive));
    
    //sendable chooser would go here
    m_chooser.setDefaultOption("Simple Auto", SimpleAuto);
    m_chooser.addOption("ActualAuto", ActualAuto);

    //put chooser to shuffleboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Driver1 a button score position
    new JoystickButton(Driver1, Button.kA.value)
        .whenPressed(new ScorePosition(m_arm, m_wrist));

    //Driver1 b button intake position
    new JoystickButton(Driver1, Button.kB.value)
        .whenPressed(new IntakePosition(m_arm, m_wrist));

    //Driver1 lbumper button intake position
    new JoystickButton(Driver1, Button.kBumperLeft.value)
        .whenPressed(new Intake(m_intake))
        .whenReleased(new IntakeStop(m_intake));

    //Driver1 RBumper button intake position
    new JoystickButton(Driver1, Button.kBumperLeft.value)
        .whenPressed(new Score(m_intake))
        .whenReleased(new IntakeStop(m_intake));

    //Driver1 X button intake position
    new JoystickButton(Driver1, Button.kX.value)
        .whenPressed(new LClimberExtend(m_climber))
        .whenPressed(new RClimberExtend(m_climber));

    //Driver1 Y button intake position
    new JoystickButton(Driver1, Button.kY.value)
        .whenPressed(new LClimberRetract(m_climber))
        .whenPressed(new RClimberRetract(m_climber));
  }

  

public Command getAutonomousCommand() {
  //returns auto choice from shuffleboard (this is called in robot.java)
	return m_chooser.getSelected();
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 /* public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return
  }*/
}
