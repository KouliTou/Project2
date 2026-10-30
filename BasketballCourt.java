import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class BasketballCourt {

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "Basketball Court");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(10);

  
        painter.forward(100);
        painter.turnRight(90);
        painter.circle(50);

    
    }

    
    public static void drawScene(PainterAPI painter) {
        // Calls drawCourtFloor
        // Calls drawCourtLines
        // Calls drawHoop
        
    }


        // Draws a filled circle with its center at the given position.
        //@param painter the painter used to draw
     
    public static void drawFilledCircle(PainterAPI painter, int xPosition, int yPosition,
            int radius, Color color) {
    }

    /**
     * Draws a filled rectangle with its bottom left corner at the given position.
     *
     * @param painter the painter used to draw
   
     */
    public static void drawFilledRectangle(PainterAPI painter, int xPosition, int yPosition,
            int width, int height, Color color) {
    }

    /**
     * Draws a filled triangle with equal sides, starting at the given position.
     *
     * @param painter the painter used to draw
     */
    public static void drawFilledTriangle(PainterAPI painter, int xPosition, int yPosition,
            int size, Color color) {
    }

    /**
     * Draws one basketball player facing right. The player has a circle head,
  
  
    }

    /**
     * Draws one referee facing left. The referee has a circle head, a rectangle
     * shirt, rectangle legs, and a small triangle whistle.

     */
    public static void drawReferee(PainterAPI painter, int xPosition, int yPosition,
            int height, Color shirtColor) {
        // Calls drawFilledCircle (head)
        // Calls drawFilledRectangle (shirt, legs, arm)
        // Calls drawFilledTriangle (whistle)
    }

    /**
     * Draws a hoop made of a backboard, a pole, and an orange rim.
     */
    public static void drawHoop(PainterAPI painter, int xPosition, int yPosition) {
        // Calls drawFilledRectangle (backboard, pole, rim)
    }

    /**
     * Draws one orange basketball.
     */
    public static void drawBasketball(PainterAPI painter, int xPosition, int yPosition,
            int radius) {
        // Calls drawFilledCircle
    }

    /**
     * Draws a row of basketballs on the floor using a loop.
     */
    public static void drawBasketballRow(PainterAPI painter, int xPosition, int yPosition,
            int count) {
        // Uses a loop
        // Calls drawBasketball
    }

    /**
     * Draws the wooden court floor across the bottom of the canvas.
     */
    public static void drawCourtFloor(PainterAPI painter) {
        // Calls drawFilledRectangle
    }

    /**
     * Draws white lines across the court floor using a loop.
   
     */
    public static void drawCourtLines(PainterAPI painter, int count) {
        // Uses a loop
        // Calls drawFilledRectangle
    }
}