package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class PinPoint {
    GoBildaPinpointDriver pinpoint;
    static double x,y;
    public PinPoint(HardwareMap hardwareMap){
        pinpoint=hardwareMap.get(GoBildaPinpointDriver.class, "Pinpoint");

        pinpoint.setOffsets(0.0,-80.0, DistanceUnit.MM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pinpoint.resetPosAndIMU();
        x= pinpoint.getPosX(DistanceUnit.MM);
        y= pinpoint.getPosY(DistanceUnit.MM);
    }
}
