package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class LeftTwoBallAuto extends SequentialCommandGroup {


    public LeftTwoBallAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake, LClimbSubsystem l_climb, RClimbSubsystem r_climb, NavXSubsystem m_navx) {
        addCommands(
          
        //sets start config
        new setStartConfig(m_arm, m_drive, m_intake, m_wrist, l_climb, r_climb, m_navx),

        //score position
        new AutoWristDown(m_wrist),

        //scores
        new AutoScore(m_intake),

        //turn to the left
        new TurnCommand(true, Constants.LeftAuto.AUTO_LTURN, Constants.AUTO_SPEED, m_drive, m_navx),

        //intake position
        new IntakePosition(m_arm, m_wrist),

        //drive forward with intake running
        new DriveIntakeCommand(true, Constants.LeftAuto.AUTO_FORWARD1, Constants.AUTO_SPEED * -1, m_drive, m_intake),

        //score position
        new ScorePosition(m_arm, m_wrist),

        //turn to the right
        new TurnCommand(false, Constants.LeftAuto.AUTO_RTURN, Constants.AUTO_SPEED * -1, m_drive, m_navx),

        //drives forward
        new DriveCommand(true, Constants.LeftAuto.AUTO_FORWARD2, Constants.AUTO_SPEED * -1, m_drive),

        //scores
        new AutoScore(m_intake)


        );
      }
    
}
