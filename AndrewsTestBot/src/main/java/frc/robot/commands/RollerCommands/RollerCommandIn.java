package frc.robot.commands.RollerCommands;

import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Roller;

import frc.robot.Constants.RollerConstant;

public class RollerCommandIn extends Command{
    private final Roller m_roller;

    /**
     * 
     * @param 
     */

    public RollerCommandIn(){
        m_roller = Roller.getInstance();
        addRequirements(m_roller);
    }
    @Override
    public void initialize(){


    }
    @Override
    public void execute(){
        m_roller.setRollerSpeed(RollerConstant.rollerSpeedIn);
    }
    @Override
    public void end(boolean interrupted){
        m_roller.RollerCommandStop();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
    
}
