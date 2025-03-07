package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;


public class Drive extends Command {
    private final Drivetrain m_drivetrain;
    private Joystick leftJoy, rightJoy;
    //private double leftSpeed, rightSpeed;

    /**
     * 
     * @param drivetrain this is the drivetrain instance
     */
    public Drive(Drivetrain subDrivetrain, Joystick left, Joystick right){
        m_drivetrain = subDrivetrain;
        this.leftJoy = left;
        this.rightJoy = right;
        addRequirements(subDrivetrain);
    }
    @Override
    public void initialize(){
    
    }
    @Override
    public void execute(){
        m_drivetrain.tankDrive(leftJoy.getRawAxis(1), rightJoy.getRawAxis(1));
    }
    @Override
    public boolean isFinished(){
        return false;
    }

}
