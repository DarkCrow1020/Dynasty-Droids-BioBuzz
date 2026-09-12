package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modules.DriveTrain;



@TeleOp(name = "ddTeleOp1P", group = "TeleOp")
public class DynastyTeleOp extends OpMode {
    private DriveTrain drive;

    @Override
    public void init() {
        drive = new DriveTrain(hardwareMap);
    }

    @Override
    public void loop() {
        drive.drive(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );
    }
}
