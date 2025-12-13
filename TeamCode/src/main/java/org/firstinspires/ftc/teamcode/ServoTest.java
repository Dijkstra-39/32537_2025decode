package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoTest extends LinearOpMode {
    private Servo standLeft;
    private Servo standRight;


    @Override
    public void runOpMode() throws InterruptedException {
        // initialize
        standLeft = hardwareMap.get(Servo.class, "standLeft");
        standRight = hardwareMap.get(Servo.class,"standRight");



        waitForStart();
        while (opModeIsActive()) {
/*            if (gamepad1.a) {
                standLeft.setPosition(Constant.standLeftUpPower);
                standRight.setPosition(Constant.standRightUpPower);
            }*/

           if (gamepad1.x) {
               standLeft.setPosition(Constant.standLeftDownPower);
               standRight.setPosition(Constant.standRightDownPower);
            }
        }
        //finish
    }
}
