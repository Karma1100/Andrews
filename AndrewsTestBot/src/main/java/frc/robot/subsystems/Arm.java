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
    /**
     * This function is just in case you need to set the speed directly for some reason.
     * 
     * @param speed value between 0-1
     */
    public static void setRollerSpeed(double speed){
        mArmRoller.set(speed);
    }
    //for Read ability and for commands
    public static void runArmRoller(){
        setRollerSpeed(ArmConstants.rollerSpeed);
    }
    public static void stopArmRoller(){
        setRollerSpeed(0);
    }


    public static void rotateArmByRadian(double angle){
        //Gear Ratio motor : output 48:1
        //number of counts per revolution : 42
        //angle per encoder count = 360 / (48*42) == 360 / 2016 = .1784828953891918691125433812593
        //rotations wanted = angle / .1784828953891918691125433812593

        

    }

    
    //3 poitions
    public static void position1(){
        //mArmRotator.getEncoder().getPosition()
    }
    
}
