package frc.robot.commands.AutonomousCommand;

import frc.robot.Constants.RollerConstant;
import frc.robot.subsystems.Roller;

import edu.wpi.first.wpilibj2.command.Command;


public class AutoDump extends Command{

    private final Roller mRoller;

    public AutoDump(Roller subRoller){
        this.mRoller  = subRoller;
    }

    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        mRoller.setRollerSpeed(RollerConstant.rollerSpeedOut);
    }
    @Override 
    public boolean isFinished(){

        return false;
    }



}
