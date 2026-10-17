package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class DriveTrain {
    private DcMotor fl, fr, bl, br;
    GoBildaPinpointDriver pinpoint;

    static double x,y;


    public DriveTrain(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "frontLeft");
        fr = hardwareMap.get(DcMotor.class, "frontRight");
        bl = hardwareMap.get(DcMotor.class, "backLeft");
        br = hardwareMap.get(DcMotor.class, "backRight");
        pinpoint=hardwareMap.get(GoBildaPinpointDriver.class,"pinpoint");

        fl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.FORWARD);



    }

    public void drive(double forward, double strafe, double rotate) {
        double flp = forward + strafe + rotate;
        double frp = forward - strafe - rotate;
        double blp = forward - strafe + rotate;
        double brp = forward + strafe - rotate;

        double max = Math.max(Math.max(Math.abs(flp), Math.abs(frp)),
                Math.max(Math.abs(blp), Math.abs(brp)));

        if (max > 1.0) {
            flp /= max; frp /= max; blp /= max; brp /= max;
        }

        fl.setPower(flp);
        fr.setPower(frp);
        bl.setPower(blp);
        br.setPower(brp);
    }


}
