package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class resetDriveEnc extends CommandBase {
    
    private final DriveSubsystem drive;
    private final ArmSubsystem arm;
    private final WristSubsystem wrist;

    public resetDriveEnc(DriveSubsystem m_drive, ArmSubsystem m_arm, WristSubsystem m_wrist) {
        drive = m_drive;
        arm = m_arm;
        wrist = m_wrist;

        addRequirements(m_drive);
    }

    public void initialize() {
        drive.resetEncoders();
        arm.resetArmEnc();
        wrist.resetWristEnc();
        
    }

    public void execute() {
        drive.resetEncoders();
        arm.resetArmEnc();
        wrist.resetWristEnc();

    }

    public void end(boolean inturrupted) {
    }

    public boolean isFinished() {
        return drive.getLMasterEncoder() == 0;
    }
}
