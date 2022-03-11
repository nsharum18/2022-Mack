package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

public class ScorePosition extends ParallelCommandGroup {


    public ScorePosition(ArmSubsystem m_arm, WristSubsystem m_wrist) {
        addCommands(

        //arm up
        new ArmUp(m_arm),

        //wrist up
        new WristUp(m_wrist)

        );
      }
    
}
