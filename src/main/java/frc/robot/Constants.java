package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class Constants {
  public static class SwerveConstants{
    public static final double WheelDiameter = 0.0965;
    public static final double DriveMaxSpeed = 2.0;
    public static final double DriveMaxAcc = 0.2;
    public static final double TurningMaxAcc = 0.15;
    public static final double TurningGearRatio = 13.714;
    public static final double DriveGearRatio = 8.311;
    public static final String CANbus = "rio";
    private static final double WheelToWheelDistance = 0.48895;
    public final static SwerveDriveKinematics m_kinematics = 
    new SwerveDriveKinematics(
        new Translation2d(-WheelToWheelDistance/2,-WheelToWheelDistance/2), //Rear Left Module
        new Translation2d(-WheelToWheelDistance/2,WheelToWheelDistance/2), //Front left Module
        new Translation2d(WheelToWheelDistance/2,WheelToWheelDistance/2), //Front Right Module
        new Translation2d(WheelToWheelDistance/2,-WheelToWheelDistance/2)); //Rear Right Module
}
}
