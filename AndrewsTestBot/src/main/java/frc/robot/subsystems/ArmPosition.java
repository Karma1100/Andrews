package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;


public class ArmPosition extends SubsystemBase{
    
    private static SparkMax mArmSpark = new SparkMax(ArmConstants.armSparkID, ArmConstants.armMotorType);
    private static SparkMaxConfig armConfig;
    private static ArmPosition mArmPosition;
    

    public ArmPosition(){
        armConfig = new SparkMaxConfig();
        armConfig.inverted(ArmConstants.isInverted);
        mArmSpark.configure(armConfig, null, null);
    }

    public static ArmPosition getInstance(){
        if(mArmPosition == null){
            return mArmPosition = new ArmPosition();
        }
            return mArmPosition;
        

    }


    //3 poitions
    
}
