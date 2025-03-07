// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

  }
  public static class driveConstants {
    
    public static final int rightFrontDrive = 10;
    public static final int rightBackDrive = 11;
    public static final int leftFrontDrive = 12; 
    public static final int leftBackDrive = 13;

    public static final int rollerController = 20;

  }
  public static class ControllerConstants{

    public static final int leftControlPort = 0;
    public static final int rightControlPort = 1;
  }
  public static class RollerConstant{

    public static final double rollerSpeedIn = .8;
    public static final double rollerSpeedOut = -.8;
    public static final double rollerSpeedStop = 0; 

    public static final int leftRollerID = 0;  //change
    public static final int rightRollerID = 0; //change

    public static final boolean leftRollerInverted = false; //chnage
    public static final boolean rightRollerInverted = false; //chnage



  }
  public static class ArmConstants{

      public static final int armRotationID = 0;  //change


      /**
       * 
       * All of the things for the Arm rotating
       */
      public static final MotorType armRotationMotorType = MotorType.kBrushless;
      //numbers for PID. CHANGE!!!
      public static double pVlaue = 0.0;
      public static double iVlaue = 0.0;
      public static double dVlaue = 0.0;

      public static boolean armRotatorInverted = false; //change
      public static IdleMode armRotatorIdleMode = IdleMode.kBrake;


      
      public static final double ratio = 1/48;

      public static final int armRollerID = 0; //change
      public static final MotorType armRollerMotorType = MotorType.kBrushless;





  }
}
