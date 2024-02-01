package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveTrain;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  
  private final XboxController controller = new XboxController(0);
  private final DriveTrain swerve = DriveTrain.getInstance();
  
  
  private final double DEADBAND = 0;
  private boolean FieldRelativeTeleop = true;

  @Override
  public void robotInit() {
    SmartDashboard.putBoolean("FieldRelativeTeleop", FieldRelativeTeleop);
  } 

  @Override
  public void robotPeriodic(){

    swerve.periodic();
  } 

  @Override
  public void teleopPeriodic() {
    boolean FRT = SmartDashboard.getBoolean("FieldRelativeTeleop", true);
    if(FRT != FieldRelativeTeleop){ FieldRelativeTeleop = FRT;}
    driveWithController(FieldRelativeTeleop);
  }

  private void driveWithController(boolean fieldRelative){
    var xSpeed = MathUtil.applyDeadband(controller.getLeftX(), DEADBAND);
    var ySpeed = -MathUtil.applyDeadband(controller.getLeftY(), DEADBAND);
    var rot = -MathUtil.applyDeadband(controller.getRightX(), DEADBAND);
    swerve.drive(xSpeed, ySpeed, rot, fieldRelative);
  }
}

