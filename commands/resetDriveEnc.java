package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;


public class resetDriveEnc extends CommandBase {
    
    private final DriveSubsystem drive;

    public resetDriveEnc(DriveSubsystem m_drive) {
        drive = m_drive;

        addRequirements(m_drive);
    }

    public void initialize() {
        drive.resetEncoders();
        
    }

    public void execute() {
        drive.resetEncoders();

    }

    public void end(boolean inturrupted) {
    }

    public boolean isFinished() {
        return drive.getLMasterEnc() == 0;
    }
}
