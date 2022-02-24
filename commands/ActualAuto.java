package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class ActualAuto extends SequentialCommandGroup {


    public ActualAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake) {
        addCommands(

        //score position
        new ScorePosition(m_arm, m_wrist),

        //intake scoring
        new Score(m_intake),

        //stops intake
        new IntakeStop(m_intake),

         //drive to a backward set number, at a certain speed
        new DriveCommand(-Constants.BACKUP_DRIVE, -Constants.AUTO_SPEED, m_drive)


        );
      }
    
}
