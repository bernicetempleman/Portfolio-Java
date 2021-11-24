/*
https://www3.ntu.edu.sg/home/ehchua/programming/java/J8a_GameIntro-BouncingBalls.html
 */
package manyballs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * The control logic and main display panel for game.
 * 
 * @author Hock-Chuan Chua
 * @version October 2010
 */
public class BallWorld extends JPanel {
   private static final int UPDATE_RATE = 30;    // Frames per second (fps)
   private static final float EPSILON_TIME = 1e-2f;  // Threshold for zero time
   
   // Balls
   private static final int MAX_BALLS = 20; // Max number allowed 
   private int currentNumBalls;             // Number currently active
   private Ball[] balls = new Ball[MAX_BALLS];

   private ContainerBox box;     // The container rectangular box
   private DrawCanvas canvas;    // The Custom canvas for drawing the box/ball
   private int canvasWidth;
   private int canvasHeight;

   private ControlPanel control; // The control panel of buttons and sliders.  
   private boolean paused = false;  // Flag for pause/resume control
   
   /**
    * Constructor to create the UI components and init the game objects.
    * Set the drawing canvas to fill the screen (given its width and height).
    * 
    * @param width : screen width
    * @param height : screen height
    */
   public BallWorld(int width, int height) {
      final int controlHeight = 30;    
      canvasWidth = width;
      canvasHeight = height - controlHeight;  // Leave space for the control panel
      
      // Init the balls
//      currentNumBalls = 2;
//      balls[0] = new Ball(300, 100, 25, 5, 90, Color.YELLOW);
//      balls[1] = new Ball(300, 300, 100, 6, -90, Color.YELLOW);

//      currentNumBalls = 5;  // 2 vertical balls
//      balls[0] = new Ball(300, 100, 25, -5, 90, Color.GREEN);
//      balls[1] = new Ball(300, 200, 25, 6, 90, Color.YELLOW);
//      balls[2] = new Ball(300, 370, 25, -1, 90, Color.CYAN);
//      balls[3] = new Ball(300, 370, 25, 4, 90, Color.PINK);
//      balls[4] = new Ball(300, 450, 25, -3, 90, Color.MAGENTA);

//        // Error here, balls run across each other, need to write log to check the program.
//        currentNumBalls = 5;  // horizontal balls
//        balls[0] = new Ball(100, 300, 25, -5, 0, Color.GREEN);
//        balls[1] = new Ball(200, 300, 25, 6, 0, Color.YELLOW);
//        balls[2] = new Ball(330, 300, 25, -1, 0, Color.CYAN);
//        balls[3] = new Ball(400, 300, 25, 4, 0, Color.PINK);
//        balls[4] = new Ball(550, 300, 25, -3, 0, Color.MAGENTA);

/*      currentNumBalls = 11;
      balls[0] = new Ball(100, 410, 25, 3, 34, Color.YELLOW);
      balls[1] = new Ball(80, 350, 25, 2, -114, Color.YELLOW);
      balls[2] = new Ball(530, 400, 30, 3, 14, Color.GREEN);
      balls[3] = new Ball(400, 400, 30, 3, 14, Color.GREEN);
      balls[4] = new Ball(400, 50, 35, 1, -47, Color.PINK);
      balls[5] = new Ball(480, 320, 35, 4, 47, Color.PINK);
      balls[6] = new Ball(80, 150, 40, 1, -114, Color.ORANGE);
      balls[7] = new Ball(100, 240, 40, 2, 60, Color.ORANGE);
      balls[8] = new Ball(250, 380, 50, 3, -42, Color.BLUE);
      balls[9] = new Ball(200, 80, 70, 6, -84, Color.CYAN);
      balls[10] = new Ball(500, 170, 90, 6, -42, Color.MAGENTA);
      */

      currentNumBalls = 0;
      // The rest of the balls, that can be launched using the launch button
      for (int i = currentNumBalls; i < MAX_BALLS; i++) {
         // Allocate the balls, but position later before the launch
         balls[i] = new Ball(20, canvasHeight - 20, 15, 5, 45, Color.RED);
      }
   
      // Init the Container Box to fill the screen
      box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

      // Init the custom drawing panel for drawing the game
      canvas = new DrawCanvas();
      
      // Init the control panel
      control = new ControlPanel();
   
      // Layout the drawing panel and control panel
      this.setLayout(new BorderLayout());
      this.add(canvas, BorderLayout.CENTER);
      this.add(control, BorderLayout.SOUTH);
      
      // Handling window resize. Adjust container box to fill the screen.
      this.addComponentListener(new ComponentAdapter() {
         // Called back for first display and subsequent window resize.
         @Override
         public void componentResized(ComponentEvent e) {
            Component c = (Component)e.getSource();
            Dimension dim = c.getSize();
            canvasWidth = dim.width;
            canvasHeight = dim.height - controlHeight; // Leave space for control panel
            // Need to resize all components that is sensitive to the screen size.
            box.set(0, 0, canvasWidth, canvasHeight);
         }
      });
       
      // Start the ball bouncing
      gameStart();
   }
   
   /** Start the ball bouncing. */
   public void gameStart() {
      // Run the game logic in its own thread.
      Thread gameThread = new Thread() {
         public void run() {
            while (true) {
               long beginTimeMillis, timeTakenMillis, timeLeftMillis;
               beginTimeMillis = System.currentTimeMillis();
               
               if (!paused) {
                  // Execute one game step
                  gameUpdate();
                  // Refresh the display
                  repaint();
               }
               
               // Provide the necessary delay to meet the target rate
               timeTakenMillis = System.currentTimeMillis() - beginTimeMillis;
               timeLeftMillis = 1000L / UPDATE_RATE - timeTakenMillis;
               if (timeLeftMillis < 5) timeLeftMillis = 5; // Set a minimum
               
               // Delay and give other thread a chance
               try {
                  Thread.sleep(timeLeftMillis);
               } catch (InterruptedException ex) {}
            }
         }
      };
      gameThread.start();  // Invoke GaemThread.run()
   }
   
   /** 
    * One game time-step. 
    * Update the game objects, with proper collision detection and response.
    */
   public void gameUpdate() {
      float timeLeft = 1.0f;  // One time-step to begin with
      
      // Repeat until the one time-step is up 
      do {
         // Find the earliest collision up to timeLeft among all objects
         float tMin = timeLeft;
         
         // Check collision between two balls
         for (int i = 0; i < currentNumBalls; i++) {
            for (int j = 0; j < currentNumBalls; j++) {
               if (i < j) {
                  balls[i].intersect(balls[j], tMin);
                  if (balls[i].earliestCollisionResponse.t < tMin) {
                     tMin = balls[i].earliestCollisionResponse.t;
                  }
               }
            }
         }
         // Check collision between the balls and the box
         for (int i = 0; i < currentNumBalls; i++) {
            balls[i].intersect(box, tMin);
            if (balls[i].earliestCollisionResponse.t < tMin) {
               tMin = balls[i].earliestCollisionResponse.t;
            }
         }
   
         // Update all the balls up to the detected earliest collision time tMin,
         // or timeLeft if there is no collision.
         for (int i = 0; i < currentNumBalls; i++) {
            balls[i].update(tMin);
         }
   
         timeLeft -= tMin;                // Subtract the time consumed and repeat
      } while (timeLeft > EPSILON_TIME);  // Ignore remaining time less than threshold
   }
   
   /** The custom drawing panel for the bouncing ball (inner class). */
   class DrawCanvas extends JPanel {
      /** Custom drawing codes */
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);    // Paint background
         // Draw the balls and box
         box.draw(g);
         for (int i = 0; i < currentNumBalls; i++) {
            balls[i].draw(g);
         }
         // Display balls' information
         g.setColor(Color.WHITE);
         g.setFont(new Font("Courier New", Font.PLAIN, 12));
         for (int i = 0; i < currentNumBalls; i++) {
            g.drawString("Ball " + (i+1) + " " + balls[i].toString(), 20, 30 + i*20);
         }
      }

      /** Called back to get the preferred size of the component. */
      @Override
      public Dimension getPreferredSize() {
         return (new Dimension(canvasWidth, canvasHeight));
      }
   }
   
   /** The control panel (inner class). */
   class ControlPanel extends JPanel {
   
      /** Constructor to initialize UI components of the controls */
      public ControlPanel() {
         // A checkbox to toggle pause/resume movement
         JCheckBox pauseControl = new JCheckBox();
         this.add(new JLabel("Pause"));
         this.add(pauseControl);
         pauseControl.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               paused = !paused;  // Toggle pause/resume flag
               transferFocusUpCycle();  // To handle key events
            }
         });

         // A slider for adjusting the speed of all the balls by a factor
         final float[] ballSavedSpeedXs = new float[MAX_BALLS];
         final float[] ballSavedSpeedYs = new float[MAX_BALLS];
         for (int i = 0; i < currentNumBalls; i++) {
            ballSavedSpeedXs[i] = balls[i].speedX;
            ballSavedSpeedYs[i] = balls[i].speedY;
         }
         int minFactor = 5;    // percent
         int maxFactor = 200;  // percent
         JSlider speedControl = new JSlider(JSlider.HORIZONTAL, minFactor, maxFactor, 100);
         this.add(new JLabel("Speed"));
         this.add(speedControl);
         speedControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               JSlider source = (JSlider)e.getSource();
               if (!source.getValueIsAdjusting()) {
                  int percentage = (int)source.getValue();
                  for (int i = 0; i < currentNumBalls; i++) {
                     balls[i].speedX = ballSavedSpeedXs[i] * percentage / 100.0f;
                     balls[i].speedY = ballSavedSpeedYs[i] * percentage / 100.0f;
                  }
               }
               transferFocusUpCycle();  // To handle key events
            }
         });

         // A button for launching the remaining balls
         final JButton launchControl = new JButton("Launch New Ball");
         this.add(launchControl);
         launchControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (currentNumBalls < MAX_BALLS) {
                  balls[currentNumBalls].x = 20;
                  balls[currentNumBalls].y = canvasHeight - 20;
                  currentNumBalls++;
                  if (currentNumBalls == MAX_BALLS) {
                     // Disable the button, as there is no more ball
                     launchControl.setEnabled(false);
                  }
               }
               transferFocusUpCycle();  // To handle key events
            }
         });
      }
   }
}