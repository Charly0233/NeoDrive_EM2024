import edu.wpi.first.wpilibj.XboxController;

public class Joysticks {
    //public class Joysticks extends commandBase {
    
    //public class ExampleSubsystem extends package frc.robot.commands;
    
    import frc.robot.subsystems.ExampleSubsystem;
    import edu.wpi.first.wpilibj2.command.CommandBase;
    
    public class Joysticks extends CommandBase {
      private final ExampleSubsystem m_subsystem;
      private final XboxController m_controller;
      public static final XboxController.Button kA

    
      /**
       * Creates a new ExampleCommand.
       *
       * @param subsystem The subsystem used by this command.
       */
      public Joysticks(ExampleSubsystem subsystem, XboxController controller) {
        m_subsystem = subsystem;
        m_controller = controller;

        System.out.println(m_controller);
        
        addRequirements(subsystem);
      }

      
      public Start(bool a) {
        if(a) {
          swerve.move()
        }

        kA = m_controller.getAButton(A);
      }


    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {
        
      }
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute(double s) {
        
        if (d>0.1)
         subsystem.move(s); 
        
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
     

}
