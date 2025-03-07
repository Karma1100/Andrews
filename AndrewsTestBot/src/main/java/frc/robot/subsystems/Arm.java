package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;


public class Arm extends SubsystemBase{
    

    //Arm Swing
    private static SparkMax mArmSpark = new SparkMax(ArmConstants.armRotationID, ArmConstants.armRotationMotorType);
    private static SparkMaxConfig armConfig;
    

    //arm roller
    private static SparkFlex mArmRoller = new SparkFlex(ArmConstants.armRollerID, ArmConstants.armRollerMotorType);
    private static SparkFlexConfig mArmRollerConfig;


    private static Arm mArmPosition;
    

    public Arm(){
        armConfig = new SparkMaxConfig();
        mArmRollerConfig = new SparkFlexConfig();


        armConfig.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(ArmConstants.pVlaue, ArmConstants.iVlaue, ArmConstants.dVlaue);

        armConfig.inverted(ArmConstants.armRotatorInverted).idleMode(ArmConstants.armRotatorIdleMode);
        mArmSpark.configure(armConfig, null, null);




        mArmRoller.configure(mArmRollerConfig, null, null);
    }
    

    public static Arm getInstance(){
        if(mArmPosition == null){
            return mArmPosition = new Arm();
        }
            return mArmPosition;
        

    }


    //3 poitions
    public static void position1(){

    }
    
}
