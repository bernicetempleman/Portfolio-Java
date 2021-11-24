/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyballs;

public class CollisionResponse {
   // Quantities that involve in further operations are declared as
   // double; otherwise float. 
   
   /** Detected collision time, reset to Float.MAX_VALUE */
   public float t;
   // Time threshold to be subtracted from collision time
   // to prevent moving over the bound. Assume that t <= 1.
   private static final float T_EPSILON = 0.005f;
   
   /** Computed speed in x-direction after collision */
   public float newSpeedX;
   /** Computed speed in y-direction after collision */
   public float newSpeedY;
   
   /** Constructor which resets the collision time to infinity. */
   public CollisionResponse() {
      reset();  // Reset detected collision time to infinity
   }
   
   /** Reset the detected collision time to infinity. */
   public void reset() {
      this.t = Float.MAX_VALUE;
   }
   
   /**
    * Copy this instance to another, used to find the earliest collision.
    *    
    * @param another : instance to be copied to.
    */
   public void copy(CollisionResponse another) {
      this.t = another.t;
      this.newSpeedX = another.newSpeedX;
      this.newSpeedY = another.newSpeedY;
   }

   /**
    * Return the x-position after impact.
    * 
    * @param currentX : the current x-position.
    * @param speedX : the current x-speed.
    * @return x-position after impact.
    */
   public float getNewX(float currentX, float speedX) {
      // Subtract by a small thread to make sure that it does not cross the bound.
      if (t > T_EPSILON) {
         return (float)(currentX + speedX * (t - T_EPSILON));
      } else {
         return currentX;
      }
   }
   
   /**
    * Return the y-position after impact.
    * 
    * @param currentY : the current x-position.
    * @param speedY : the current x-speed.
    * @return y-position after impact.
    */
   public float getNewY(float currentY, float speedY) {
      // Subtract by a small thread to make sure that it does not cross the bound.
      if (t > T_EPSILON) {
         return (float)(currentY + speedY * (t - T_EPSILON));
      } else {
         return currentY;
      }
   }

   /**
    * Return the precise x-position of the point of impact.
    * Needed in some collision detection operations.
    * 
    * @param currentX : the current x-position.
    * @param speedX : the current x-speed.
    * @return x-position of the point of impact.
    */
   public double getImpactX(float currentX, float speedX) {
      return currentX + speedX * t;
   }
   
   /**
    * Return the precise y-position of the point of impact.
    * Needed in some collision detection operations.
    * 
    * @param currentY : the current x-position.
    * @param speedY : the current x-speed.
    * @return y-position of the point of impact.
    */
   public double getImpactY(float currentY, float speedY) {
      return currentY + speedY * t;
   }

}
