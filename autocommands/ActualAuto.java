package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class ActualAuto extends SequentialCommandGroup {


    public ActualAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake) {
        addCommands(

        //score position
        new ScorePosition(m_arm, m_wrist),

        //intake scoring
        new Score(m_intake),

         //drive to a backward set number, at a certain speed
        new DriveCommand(false, Constants.BACKUP_DRIVE, Constants.AUTO_SPEED * -1, m_drive)


        );
      }
    
}
