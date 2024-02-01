package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Joysticks_subsystem;
    
    public class Joysticks extends CommandBase {
      private final Joysticks_subsystem m_subsystem;
    
      /**
       * Creates a new ExampleCommand.
       *
       * @param subsystem The subsystem used by this command.
       */
      public Joysticks(Joysticks_subsystem subsystem) {
        m_subsystem = subsystem;
        
        addRequirements(subsystem);
      }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {
        
      }
    
      // Called every time the scheduler runs while the command is scheduled.
  
      public void execute(double d) {
        if (d>0.1)
         m_subsystem.interval(d);
    
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return false;
      }
    }
     


