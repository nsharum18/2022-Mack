package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class SimpleAuto extends SequentialCommandGroup {


    public SimpleAuto(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist, IntakeSubsystem m_intake) {
        addCommands(

        //drive to a forward set number, at a certain speed
        new DriveCommand(Constants.FORWARD_DRIVE, Constants.AUTO_SPEED, m_drive),

        //arm up
        new ArmUp(m_arm),

        //wrist up
        new WristUp(m_wrist),

        //intake scoring
        new Score(m_intake)


        );
      }
    
}