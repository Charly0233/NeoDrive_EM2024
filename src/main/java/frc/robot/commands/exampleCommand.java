package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.exampleSubsistem;

public class exampleCommand extends CommandBase{
    private final exampleSubsistem subsystem;

    public exampleCommand (exampleSubsistem _Subsistem){
        subsystem=_Subsistem;
    }

    @Override
    public void initialize(){}


    public void launch(double d) {
        if (d>0.1)
            subsystem.move(d);
    }

    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
