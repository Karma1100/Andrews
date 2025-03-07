// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

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

      public static final int armSparkID = 0;  //change
      public static final MotorType armMotorType = MotorType.kBrushless;

      public static final boolean isInverted = true; //change

      public static final double ratio = 1/48;

  }
}
