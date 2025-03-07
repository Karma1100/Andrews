package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstant;
import frc.robot.Constants.driveConstants;

public class Roller extends SubsystemBase{

    private static Roller roller;

    private static SparkMax rightRollerSpark = new SparkMax(RollerConstant.rightRollerID, MotorType.kBrushed);
    //private static SparkFlex leftRollerSpark = new SparkFlex(RollerConstant.leftRollerID, MotorType.kBrushless);

    private final SparkMaxConfig rightConfig;
    private final SparkFlexConfig leftConfig;
    

    public Roller(){
        rightConfig = new SparkMaxConfig();
        leftConfig = new SparkFlexConfig();

        rightConfig.inverted(RollerConstant.rightRollerInverted);
        leftConfig.inverted(RollerConstant.leftRollerInverted);


        leftConfig.follow(rightRollerSpark);

        rightRollerSpark.configure(rightConfig, null, null);
        //leftRollerSpark.configure(leftConfig, null, null);


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
        rightRollerSpark.set(speed);
    }
    public void RollerCommandStop() {
        setRollerSpeed(RollerConstant.rollerSpeedStop);
    }
    
}
