package frc.robot.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class BackupOneBall extends SequentialCommandGroup {

    public BackupOneBall(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb) {


        addCommands(

            new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb),

            new AutoWristDown(m_wrist),

            new WaitCommand(.5),

            new AutoScore(m_intake),

            new DriveCommand(false, Constants.BACK_DISTANCE, -Constants.AUTO_SPEED, m_drive)
        );
      }
}
