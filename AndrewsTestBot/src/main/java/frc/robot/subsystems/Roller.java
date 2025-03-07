package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstant;
import frc.robot.Constants.driveConstants;

public class Roller extends SubsystemBase{

    private static Roller roller;

    private static SparkMax rollerSpark = new SparkMax(driveConstants.rollerController, MotorType.kBrushed);
    public Roller(){
        


    }
    public static Roller getInstance(){
        if(roller == null){
            roller = new Roller();

        }
        return roller;


    }
    @Override
    public void periodic(){

    }
    public void setRollerSpeed(double speed){
        rollerSpark.set(speed);
    }
    public void RollerCommandStop() {
        setRollerSpeed(RollerConstant.rollerSpeedStop);
    }
    
}
