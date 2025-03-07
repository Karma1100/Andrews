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
    private static SparkMax mArmRotator = new SparkMax(ArmConstants.armRotationID, ArmConstants.armRotationMotorType);
    private static SparkMaxConfig armRotationConfig;
    

    //arm roller
    private static SparkFlex mArmRoller = new SparkFlex(ArmConstants.armRollerID, ArmConstants.armRollerMotorType);
    private static SparkFlexConfig mArmRollerConfig;


    private static Arm mArmPosition;
    

    public Arm(){


        armRotationConfig = new SparkMaxConfig();
        mArmRollerConfig = new SparkFlexConfig();

        //CONFIG FOR ROTATION

        //this is the PID loop for the arm. Make sure to change the PID  values in constants please
        armRotationConfig.
            closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .pid(ArmConstants.pVlaue, ArmConstants.iVlaue, ArmConstants.dVlaue);

        //please check to see if motor is inverted.
        armRotationConfig
            .inverted(ArmConstants.armRotatorInverted)
            .idleMode(ArmConstants.armRotatorIdleMode);
            
        mArmRotator
            .configure(armRotationConfig, null, null);


        //CONFIG FOR ROLLER
        mArmRollerConfig
            .inverted(ArmConstants.arnRollerInverted)
            .idleMode(ArmConstants.armRollerIdel);


        mArmRoller
            .configure(mArmRollerConfig, null, null);
    }
    

    public static Arm getInstance(){
        if(mArmPosition == null){
            return mArmPosition = new Arm();
        }
            return mArmPosition;
        

    }

    //Roller at the end of the Arm go bur
    public static void runArmRoller(){

    }


    //3 poitions
    public static void position1(){

    }
    
}
