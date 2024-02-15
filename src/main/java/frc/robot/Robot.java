package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveTrain;

// Limelight
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Robot extends TimedRobot {

  private final XboxController controller = new XboxController(0);
  private final DriveTrain swerve = DriveTrain.getInstance();
  private final double DEADBAND = 0;
  private boolean FieldRelativeTeleop = true;
  private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  @Override
  public void robotInit() {
    SmartDashboard.putBoolean("FieldRelativeTeleop", FieldRelativeTeleop);
  }

  @Override
  public void robotPeriodic() {
    swerve.periodic();
  }

  @Override
  public void teleopPeriodic() {
    boolean FRT = SmartDashboard.getBoolean("FieldRelativeTeleop", true);
    if (FRT != FieldRelativeTeleop) {
      FieldRelativeTeleop = FRT;
    }
    driveWithController(FieldRelativeTeleop);

    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    // read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    // post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
  }

  private void driveWithController(boolean fieldRelative) {
    var xSpeed = MathUtil.applyDeadband(controller.getLeftX(), DEADBAND);
    var ySpeed = -MathUtil.applyDeadband(controller.getLeftY(), DEADBAND);
    var rot = -MathUtil.applyDeadband(controller.getRightX(), DEADBAND);
    swerve.drive(xSpeed, ySpeed, rot, fieldRelative);
  }
}
