import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class BasketballCourt {

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "Basketball Court");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(10);

        // Setup test: three different PainterAPI calls to show drawing works
        painter.forward(100);
        painter.turnRight(90);
        painter.circle(50);

        // Later: call drawScene(painter) here
    }

    /**
     * Draws the whole basketball court scene by calling the methods that draw
     * the floor, court lines, hoop, basketballs, players, and referees.
     *
     * @param painter the painter used to draw everything
     */
    public static void drawScene(PainterAPI painter) {
        // Calls drawCourtFloor
        // Calls drawCourtLines
        // Calls drawHoop
        // Calls drawBasketballRow
        // Calls drawPlayer (twice, different sizes and colors)
        // Calls drawReferee (twice, different sizes and colors)
    }

    /**
     * Draws a filled circle with its center at the given position.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the center of the circle
     * @param yPosition the Y coordinate of the center of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle, both outline and fill
     */
    public static void drawFilledCircle(PainterAPI painter, int xPosition, int yPosition,
            int radius, Color color) {
    }

    /**
     * Draws a filled rectangle with its bottom left corner at the given position.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the bottom left corner
     * @param yPosition the Y coordinate of the bottom left corner
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param color the color of the rectangle, both outline and fill
     */
    public static void drawFilledRectangle(PainterAPI painter, int xPosition, int yPosition,
            int width, int height, Color color) {
    }

    /**
     * Draws a filled triangle with equal sides, starting at the given position.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the starting corner
     * @param yPosition the Y coordinate of the starting corner
     * @param size the length of each side of the triangle
     * @param color the color of the triangle, both outline and fill
     */
    public static void drawFilledTriangle(PainterAPI painter, int xPosition, int yPosition,
            int size, Color color) {
    }

    /**
     * Draws one basketball player facing right. The player has a circle head,
     * a rectangle jersey, and rectangle legs.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the center of the player
     * @param yPosition the Y coordinate of the player's feet
     * @param height the height of the player from feet to top of head
     * @param jerseyColor the color of the player's jersey
     */
    public static void drawPlayer(PainterAPI painter, int xPosition, int yPosition,
            int height, Color jerseyColor) {
        // Calls drawFilledCircle (head)
        // Calls drawFilledRectangle (jersey, legs, arm)
    }

    /**
     * Draws one referee facing left. The referee has a circle head, a rectangle
     * shirt, rectangle legs, and a small triangle whistle.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the center of the referee
     * @param yPosition the Y coordinate of the referee's feet
     * @param height the height of the referee from feet to top of head
     * @param shirtColor the color of the referee's shirt
     */
    public static void drawReferee(PainterAPI painter, int xPosition, int yPosition,
            int height, Color shirtColor) {
        // Calls drawFilledCircle (head)
        // Calls drawFilledRectangle (shirt, legs, arm)
        // Calls drawFilledTriangle (whistle)
    }

    /**
     * Draws a hoop made of a backboard, a pole, and an orange rim.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the backboard
     * @param yPosition the Y coordinate of the bottom of the pole
     */
    public static void drawHoop(PainterAPI painter, int xPosition, int yPosition) {
        // Calls drawFilledRectangle (backboard, pole, rim)
    }

    /**
     * Draws one orange basketball.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the center of the ball
     * @param yPosition the Y coordinate of the center of the ball
     * @param radius the radius of the ball
     */
    public static void drawBasketball(PainterAPI painter, int xPosition, int yPosition,
            int radius) {
        // Calls drawFilledCircle
    }

    /**
     * Draws a row of basketballs on the floor using a loop.
     *
     * @param painter the painter used to draw
     * @param xPosition the X coordinate of the first ball
     * @param yPosition the Y coordinate of the row
     * @param count how many basketballs are in the row
     */
    public static void drawBasketballRow(PainterAPI painter, int xPosition, int yPosition,
            int count) {
        // Uses a loop
        // Calls drawBasketball
    }

    /**
     * Draws the wooden court floor across the bottom of the canvas.
     *
     * @param painter the painter used to draw
     */
    public static void drawCourtFloor(PainterAPI painter) {
        // Calls drawFilledRectangle
    }

    /**
     * Draws white lines across the court floor using a loop.
     *
     * @param painter the painter used to draw
     * @param count how many lines to draw
     */
    public static void drawCourtLines(PainterAPI painter, int count) {
        // Uses a loop
        // Calls drawFilledRectangle
    }
}