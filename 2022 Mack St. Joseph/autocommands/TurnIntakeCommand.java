package frc.robot.autocommands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.commands.*;


public class TurnIntakeCommand extends ParallelCommandGroup {


    public TurnIntakeCommand(Boolean left, Double angle, Double speed, DriveSubsystem subsystem, ArmSubsystem m_arm, WristSubsystem m_wrist, NavXSubsystem navx) {
        addCommands(

        //sets intake postiion

        new IntakePosition(m_arm, m_wrist),

        //turns
        new TurnCommand(left, angle, speed, subsystem, navx)

        );
      }
    
}
