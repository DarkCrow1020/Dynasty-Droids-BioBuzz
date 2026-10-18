package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modules.DriveTrain;
import org.firstinspires.ftc.teamcode.Modules.Intake;
import org.firstinspires.ftc.teamcode.Modules.PinPoint;


@TeleOp(name = "DynastyTeleOpRed", group = "TeleOp")
public class DynastyTeleOpRed extends OpMode {
    private DriveTrain drive;
    private Intake intake;
    private PinPoint pinPoint;
    boolean Rt=false;
    @Override
    public void init() {
        drive = new DriveTrain(hardwareMap);
        intake= new Intake(hardwareMap);
        pinPoint=new PinPoint(hardwareMap);
    }

    @Override
    public void loop() {
        drive.drive(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );
        Rt= gamepad1.right_trigger<0.1;
        if(gamepad1.right_trigger>0.7 && !Rt){
            intake.IntakeStart();
        }else{intake.IntakeStop();}
        if(gamepad1.rightBumperWasPressed()){
            drive.aimBasket(90);
        }
        pinPoint.Update();
        pinPoint.GetHeading();
        pinPoint.GetX();
        pinPoint.GetY();

    }
}

