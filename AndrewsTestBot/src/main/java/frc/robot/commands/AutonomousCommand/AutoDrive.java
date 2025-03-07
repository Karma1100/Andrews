package frc.robot.commands.AutonomousCommand;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends Command{

    private final Drivetrain m_drive;
    private double DriveLength;

    public AutoDrive(Drivetrain drive, double length){
        m_drive = drive;
        this.DriveLength = length;
        addRequirements(m_drive);
        

    }
    
    @Override
    public void initialize(){
        
    }
    @Override
    public void execute(){
        m_drive.DriveForwardEncoder(DriveLength);
        
    }
    @Override
    public boolean isFinished(){
        return false;
    }

    
}
