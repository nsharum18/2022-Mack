package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RightThreeBallAuto extends SequentialCommandGroup {


    public RightThreeBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb, NavXSubsystem m_navx) {
        addCommands(
          
        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb, m_navx),

        //score position
        new AutoWristDown(m_wrist),

        //scores
        new AutoScore(m_intake),

        //turn to the right
        new TurnCommand(false, Constants.RightThreeBallAuto.AUTO_RTURN1, Constants.AUTO_SPEED * -1, m_drive, m_navx),

        //intake position
        new IntakePosition(m_arm, m_wrist),

        //zeros drive encoders
        new resetDriveEnc(m_drive),

        //drive forward with intake running
        new DriveIntakeCommand(true, Constants.RightThreeBallAuto.AUTO_FORWARD1, Constants.AUTO_SPEED * -1, m_drive, m_intake),

        //turn to the right
        new TurnCommand(false, Constants.RightThreeBallAuto.AUTO_RTURN2, Constants.AUTO_SPEED * -1, m_drive, m_navx),

        //zeros drive encoders
        new resetDriveEnc(m_drive),

        //drive forward with intake running
        new DriveIntakeCommand(true, Constants.RightThreeBallAuto.AUTO_FORWARD2, Constants.AUTO_SPEED * -1, m_drive, m_intake),

        //sets score position
        new ScorePosition(m_arm, m_wrist),

        //turn to right
        new TurnCommand(false, Constants.RightThreeBallAuto.AUTO_RTURN3, Constants.AUTO_SPEED * -1, m_drive, m_navx),

        //zeros drive encoders
        new resetDriveEnc(m_drive),

        //drives forward
        new DriveCommand(true, Constants.RightThreeBallAuto.AUTO_FORWARD3, Constants.AUTO_SPEED * -1, m_drive),

        //scores
        new AutoScore(m_intake)


        );
      }
    
}
