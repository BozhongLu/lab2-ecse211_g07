package ca.mcgill.ecse211.project;

import static ca.mcgill.ecse211.project.Resources.*;

/**
 * This class is used to drive the robot on the demo floor.
 */
public class SquareDriver {

  /**
   * Drives the robot in a square of the given length. It is to be run in parallel
   * with the odometer to allow testing its functionality.
   *
   * @param length the length of the square in feet (tile sizes)
   */
  public static void driveInASquare(double length) {
    setAcceleration(ACCELERATION);
    for (int i = 0; i < 4; i++) {
      moveStraightFor(length);
      //System.out.println(i+"  ");
      turnBy(90.0); // degrees clockwise
    }
    stopMotors();
  }
  
  /**
   * Moves the robot straight for the given distance.
   *
   * @param distance in feet (tile sizes), may be negative
   */
  public static void moveStraightFor(double distance) {
    // TODO Set motor speeds and rotate them by the given distance.
    // This method should not return until the robot has finished moving.
    double WRotationAngle = distance*TILE_SIZE*(57.3/WHEEL_RAD);
    leftMotor.setSpeed(FORWARD_SPEED);
    rightMotor.setSpeed(FORWARD_SPEED);
    leftMotor.rotate((int) WRotationAngle,true); // not blocked to let other wheel rotate same time
    rightMotor.rotate((int) WRotationAngle,false); // block to let motion carry out

  }
  
  /**
   * Turns the robot by a specified angle. Note that this method is different from
   * {@code Navigation.turnTo()}. For example, if the robot is facing 90 degrees, calling
   * {@code turnBy(90)} will make the robot turn to 180 degrees, but calling
   * {@code Navigation.turnTo(90)} should do nothing (since the robot is already at 90 degrees).
   *
   * @param angle the angle by which to turn, in degrees
   */
  public static void turnBy(double angle) {
    // TODO Hint: similar to moveStraightFor(), but use a minus sign
    double CRotationAngle;
    CRotationAngle = angle*(BASE_WIDTH/(2*WHEEL_RAD));
    leftMotor.setSpeed(ROTATE_SPEED);
    rightMotor.setSpeed(ROTATE_SPEED);
    leftMotor.rotate((int) CRotationAngle,true); // not blocked to let other wheel rotate same time
    rightMotor.rotate((int) (-1*CRotationAngle),false); // block to let motion carr

  }
  
  /**
   * Converts input distance to the total rotation of each wheel needed to cover that distance.
   *
   * @param distance the input distance in meters
   * @return the wheel rotations necessary to cover the distance in degrees
   */
  public static int convertDistance(double distance) {
    // TODO Compute and return the correct value.
    return 0;
  }

  /**
   * Converts input angle to the total rotation of each wheel needed to rotate the robot by that
   * angle.
   *
   * @param angle the input angle in degrees
   * @return the wheel rotations necessary to rotate the robot by the angle in degrees
   */
  public static int convertAngle(double angle) {
    // TODO Compute and return the correct value. Hint: you can reuse convertDistance()
    return 0;
  }
  
  /**
   * Stops both motors.
   */
  public static void stopMotors() {
    leftMotor.stop();
    rightMotor.stop();
  }
  
  /**
   * Sets the speed of both motors to the same values.
   *
   * @param speed the speed in degrees per second
   */
  public static void setSpeed(int speed) {
    // TODO Implement this by reusing an existing method (1 line)
  }
  
  /**
   * Sets the speed of both motors to different values.
   *
   * @param leftSpeed the speed of the left motor in degrees per second
   * @param rightSpeed the speed of the right motor in degrees per second
   */
  public static void setSpeeds(int leftSpeed, int rightSpeed) {
    // TODO
  }
  
  /**
   * Sets the acceleration of both motors.
   *
   * @param acceleration the acceleration in degrees per second squared
   */
  public static void setAcceleration(int acceleration) {
    // TODO
    rightMotor.setAcceleration(ACCELERATION);
  }

}
