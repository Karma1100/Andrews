package frc.robot.subsystems;

import frc.robot.Constants.driveConstants;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.DriverStation;


public class Drivetrain extends SubsystemBase{
    
    private static Drivetrain drivetrain; 
    private static DifferentialDrive mDrive;
    private static SparkMaxConfig leftFrontConfig;
    private static SparkMaxConfig rightFrontConfig;
    private static SparkMaxConfig leftBackConfig;
    private static SparkMaxConfig rightBackConfig;
    //lowercase drivetrain can be like literally any name
    /** had to import the specific classes above because they're like files, 
     * you have to get real specific so the program knows the stuff pretty much
     * here we are just declaring the sparkmax's and associating them with the ID given
     * to them in constants.java
     * 
     * 
     * 
     * 
     */
    private final SparkMax rightFront = new SparkMax(driveConstants.rightFrontDrive, MotorType.kBrushless);
    private final SparkMax rightBack = new SparkMax(driveConstants.rightBackDrive, MotorType.kBrushless);
    private final SparkMax leftFront = new SparkMax(driveConstants.leftFrontDrive, MotorType.kBrushless);
    private final SparkMax leftBack = new SparkMax(driveConstants.leftBackDrive, MotorType.kBrushless);
    // private static CANSparkJNI = new CANSparkJNI ()

    // diff groups for both sides of thingy
    
    public Drivetrain(){
    //motor conditions 
        rightFrontConfig = new SparkMaxConfig();
        rightBackConfig = new SparkMaxConfig();
        leftFrontConfig = new SparkMaxConfig();
        leftBackConfig = new SparkMaxConfig();
    //declaring them and what not 
        rightFrontConfig.smartCurrentLimit(60);
        rightFrontConfig.idleMode(IdleMode.kCoast);

        rightFrontConfig.apply(rightFrontConfig);
        rightBackConfig.apply(rightFrontConfig);
        leftBackConfig.apply(rightFrontConfig);
        leftFrontConfig.apply(rightFrontConfig);
    //initializing i think
        rightBackConfig.follow(rightFront);
        leftBackConfig.follow(leftFront);

        rightFrontConfig.inverted(false);
        leftFrontConfig.inverted(true);

        
        rightFront.configure(rightFrontConfig, null, null);
        rightBack.configure(rightBackConfig, null, null);
        leftFront.configure(leftFrontConfig, null, null);
        leftBack.configure(leftBackConfig, null, null);

        mDrive = new DifferentialDrive(leftFront, rightFront);
    }

       

    public static Drivetrain getInstance(){
        if(drivetrain == null){
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("encoder right", rightFront.getEncoder().getPosition());
    }

    
    public void tankDrive(double left, double right){
        mDrive.tankDrive(left, right);
    }


    public void DriveForwardDeadReckon(double speed, double time){
        double startTime = DriverStation.getMatchTime();
        while(startTime < DriverStation.getMatchTime() + time){
            mDrive.tankDrive(speed, speed);
        }
        mDrive.tankDrive(0, 0);


    }
    public void DriveForwardEncoder(double distanceInMeters){
        double start = rightFront.getEncoder().getPosition();
        while(start < -(distanceInMeters)){
            mDrive.tankDrive(-.2, -.2);
        }
        mDrive.tankDrive(0, 0);

    }
}