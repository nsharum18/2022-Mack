// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.autocommands.*;
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
  private final LClimbSubsystem l_climb = new LClimbSubsystem();
  private final RClimbSubsystem r_climb = new RClimbSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final WristSubsystem m_wrist = new WristSubsystem();
  private final AirSubsystem m_air = new AirSubsystem();

  //autos
  private final Command LeftTwoBallAuto = new LeftTwoBallAuto(m_drive, m_arm, m_wrist, m_intake, l_climb, r_climb);
  private final Command RightTwoBallAuto = new RightTwoBallAuto(m_drive, m_arm, m_wrist, m_intake, l_climb, r_climb);
  private final Command RightThreeBallAuto = new RightThreeBallAuto(m_drive, m_arm, m_wrist, m_intake, l_climb, r_climb);
  private final Command TrajectoryTest = new TrajectoryTest(m_drive, m_arm, m_wrist, m_intake, l_climb, r_climb);
  



  //sendable chooser
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  //setting controllers
  XboxController Driver1 = new XboxController(XboxConstants.DRIVER1_STICKS);
  XboxController Driver2 = new XboxController(XboxConstants.DRIVER2_STICKS);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //sets teleop drive as the default drive command
    m_drive.setDefaultCommand( 
      
      new RunCommand(
        () ->
          m_drive.arcadeDrive(-Driver1.getLeftY(), Driver1.getRightX()), m_drive));

    //compressor on
    new CompressorON(m_air);

    //put chooser to shuffleboard
    SmartDashboard.putData("Autonomous", m_chooser);

    //sendable chooser options
    m_chooser.setDefaultOption("Left Two Ball", LeftTwoBallAuto);
    m_chooser.addOption("Right Two Ball", RightTwoBallAuto);
    m_chooser.addOption("Right Three Ball", RightThreeBallAuto);
    m_chooser.addOption("Trajectory Test", TrajectoryTest);

      
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    /****************** DRIVER1 CONTROLS ******************/

    //Driver1 lbumper button intake
    new JoystickButton(Driver1, XboxConstants.XBOX_LBUMPER)
        .whileHeld(new Intake(m_intake));

    //Driver1 RBumper button score
    new JoystickButton(Driver1, XboxConstants.XBOX_RBUMPER)
        .whileHeld(new Score(m_intake));

    //Driver1 Back button resets drive encoders
    new JoystickButton(Driver1, XboxConstants.BACK)
        .whenPressed(new resetDriveEnc(m_drive, m_arm, m_wrist));

    //Driver1 Select Button sets encoders to start config
    new JoystickButton(Driver1, XboxConstants.START)
        .whenPressed(new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb));

    /****************** DRIVER2 CONTROLS ******************/

    //Driver2 a button score position
    new JoystickButton(Driver2, XboxConstants.XBOX_A)
        .whenPressed(new ScorePosition(m_arm, m_wrist));

    //Driver2 b button intake position
    new JoystickButton(Driver2, XboxConstants.XBOX_B)
        .whenPressed(new IntakePosition(m_arm, m_wrist));

    //Driver2 x button takes arm to start config
    new JoystickButton(Driver2, XboxConstants.XBOX_X)
        .whileHeld(new lowShift(m_air));

    //Driver2 y button takes arm to start config
    new JoystickButton(Driver2, XboxConstants.XBOX_Y)
        .whileHeld(new ArmStart(m_arm));

    //Driver2 LBumper button Arm Up
    new JoystickButton(Driver2, XboxConstants.XBOX_LBUMPER)
        .whenPressed( new ClimbersExtend(l_climb, r_climb));

    //Driver2 RBumper intake position
    new JoystickButton(Driver2, XboxConstants.XBOX_RBUMPER)
         .whenPressed(new ClimbersRetract(l_climb, r_climb));

    new JoystickButton(Driver2, XboxConstants.BACK)
         .whileHeld(new WristManualDown(m_wrist));

    new JoystickButton(Driver2, XboxConstants.START)
         .whileHeld(new WristManualUp(m_wrist));
    
  }

  public void setStartConfig() {

   new RunCommand(

    () -> setStartConfig()

    );
  }

  public void configureSmartDashboard() {
    SmartDashboard.putNumber("Arm Encoder", m_arm.getArmEnc());
    SmartDashboard.putNumber("Left Encoder", m_drive.getLMasterEncoder());
    SmartDashboard.putNumber("Right Encoder", m_drive.getRMasterEncoder());
    SmartDashboard.putNumber("Wrist Encoder", m_wrist.getWristEnc());
    SmartDashboard.putNumber("Intake Encoder", m_intake.getIntakeEnc());
    SmartDashboard.putNumber("Left Climb", l_climb.getlClimberEnc());
    SmartDashboard.putNumber("Right Climb", r_climb.getrClimberEnc());
    SmartDashboard.putNumber("Heading", m_drive.getHeading());

  }

  

public Command getAutonomousCommand() {
  //returns auto choice from smartdashboard (this is called in robot.java)
  	return m_chooser.getSelected();
   
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
