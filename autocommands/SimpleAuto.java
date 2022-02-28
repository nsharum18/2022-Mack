package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class SimpleAuto extends SequentialCommandGroup {


    public SimpleAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, ClimberSubsystem m_climb) {
        addCommands(

        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, m_climb),

        //drive to a forward set number, at a certain speed
        new DriveCommand(true, Constants.FORWARD_DRIVE, Constants.AUTO_SPEED, m_drive),

        //score position
        new ScorePosition(m_arm, m_wrist),

        //intake scoring
        new Score(m_intake)


        );
      }
    
}
