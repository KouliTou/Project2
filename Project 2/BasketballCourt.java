import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class BasketballCourt {

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "Basketball Court");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0); // zero means draw as fast as possible

        drawScene(painter);
    }

    // Draws the whole basketball court scene. 
    public static void drawScene(PainterAPI painter) {
        drawWall(painter, new Color(225, 232, 242));
        drawCourtFloor(painter, new Color(198, 134, 66));
        drawDecorations(painter);
        drawPlayer(painter, -140, -150, 100, new Color(30, 80, 200));
        drawPlayer(painter, -250, -170, 140, new Color(200, 30, 30));
        drawReferee(painter, 250, -150, 95, Color.GRAY);
        drawReferee(painter, 150, -170, 130, Color.BLACK);
    }

    // Draws the court lines, two hoops, and a row of basketballs.
    public static void drawDecorations(PainterAPI painter) {
        drawCourtLines(painter, 6);
        drawHoop(painter, -370, -170, true);
        drawHoop(painter, 370, -170, false);
        drawBasketballRow(painter, -120, -255, 5);
    }


    // Draws a filled circle with its center at the given position.
    public static void drawFilledCircle(PainterAPI painter, int xPosition, int yPosition,
            int radius, Color color) {
        // The painter starts a circle at its lowest point, so move down by the radius
        painter.liftPen();
        painter.moveTo(xPosition, yPosition - radius);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        painter.circle(radius);
        painter.finishFill();
    }


    // Draws a filled rectangle with its bottom left corner at the given position. 
    public static void drawFilledRectangle(PainterAPI painter, int xPosition, int yPosition,
            int width, int height, Color color) {
        painter.liftPen();
        painter.moveTo(xPosition, yPosition);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        // Two times around: width side, height side
        for (int side = 0; side < 2; side++) {
            painter.forward(width);
            painter.turnLeft(90);
            painter.forward(height);
            painter.turnLeft(90);
        }
        painter.finishFill();
    }


    // Draws a filled triangle starting at its bottom left corner.
    public static void drawFilledTriangle(PainterAPI painter, int xPosition, int yPosition,
            int size, Color color) {
        painter.liftPen();
        painter.moveTo(xPosition, yPosition);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        for (int side = 0; side < 3; side++) {
            painter.forward(size);
            painter.turnLeft(120);
        }
        painter.finishFill();
    }


    // Draws a line from the start position to the end position.
    public static void drawLine(PainterAPI painter, int startX, int startY, int endX,
            int endY, Color color) {
        painter.liftPen();
        painter.moveTo(startX, startY);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.moveTo(endX, endY);
    }


    // Draws a basketball player facing right, with feet at the given position.
    public static void drawPlayer(PainterAPI painter, int xPosition, int yPosition,
            int height, Color jerseyColor) {
        Color skinColor = new Color(240, 190, 140);

        // Sizes of the body parts
        int legHeight = height * 35 / 100;
        int legWidth = height * 12 / 100;
        int bodyHeight = height * 40 / 100;
        int bodyWidth = height * 32 / 100;
        int headRadius = height * 12 / 100;
        int armLength = height * 25 / 100;
        int armThickness = height * 9 / 100;

        int jerseyBottom = yPosition + legHeight;
        int headCenterY = jerseyBottom + bodyHeight + headRadius;
        int armY = jerseyBottom + bodyHeight - armThickness - 3;

        drawFilledRectangle(painter, xPosition - legWidth - 1, yPosition, legWidth,
                legHeight, skinColor);
        drawFilledRectangle(painter, xPosition + 1, yPosition, legWidth, legHeight,
                skinColor);
        drawFilledRectangle(painter, xPosition - bodyWidth / 2, jerseyBottom - legHeight / 2,
                bodyWidth, legHeight / 2, jerseyColor);
        drawFilledRectangle(painter, xPosition - bodyWidth / 2, jerseyBottom, bodyWidth,
                bodyHeight, jerseyColor);
        drawFilledRectangle(painter, xPosition + bodyWidth / 2, armY, armLength,
                armThickness, skinColor);

        drawFilledCircle(painter, xPosition, headCenterY, headRadius, skinColor);
        drawFilledCircle(painter, xPosition + headRadius / 2, headCenterY + headRadius / 4,
                headRadius / 5, Color.BLACK);
    }


    // Draws a referee facing left, with feet at the given position. 
    public static void drawReferee(PainterAPI painter, int xPosition, int yPosition,
            int height, Color shirtColor) {
        Color skinColor = new Color(240, 190, 140);
        Color pantsColor = new Color(50, 50, 50);

        int legHeight = height * 35 / 100;
        int legWidth = height * 12 / 100;
        int bodyHeight = height * 40 / 100;
        int bodyWidth = height * 32 / 100;
        int headRadius = height * 12 / 100;
        int armLength = height * 25 / 100;
        int armThickness = height * 9 / 100;

        int shirtBottom = yPosition + legHeight;
        int headCenterY = shirtBottom + bodyHeight + headRadius;
        int armY = shirtBottom + bodyHeight - armThickness - 3;

        drawFilledRectangle(painter, xPosition - legWidth - 1, yPosition, legWidth,
                legHeight, pantsColor);
        drawFilledRectangle(painter, xPosition + 1, yPosition, legWidth, legHeight,
                pantsColor);
        drawFilledRectangle(painter, xPosition - bodyWidth / 2, shirtBottom, bodyWidth,
                bodyHeight, shirtColor);
        drawFilledRectangle(painter, xPosition - bodyWidth / 2 - armLength, armY,
                armLength, armThickness, skinColor);

        drawFilledCircle(painter, xPosition, headCenterY, headRadius, skinColor);
        drawFilledCircle(painter, xPosition - headRadius / 2, headCenterY + headRadius / 4,
                headRadius / 5, Color.BLACK);

        drawFilledRectangle(painter, xPosition - headRadius, headCenterY + headRadius / 2,
                headRadius * 2, headRadius / 2 + 3, Color.BLACK);

        drawFilledTriangle(painter, xPosition - headRadius - headRadius, headCenterY
                - headRadius / 2, headRadius, Color.YELLOW);
    }


    // Draws a hoop. The rim points right if facingRight is true and left if false.
    public static void drawHoop(PainterAPI painter, int xPosition, int yPosition,
            boolean facingRight) {
        int rimLength = 50;
        int rimStartX = xPosition + 6;
        int netStartX = xPosition + 11;
        if (!facingRight) {
            rimStartX = xPosition - 6 - rimLength;
            netStartX = xPosition - 11 - 40;
        }

        drawFilledRectangle(painter, xPosition - 5, yPosition, 10, 140, Color.GRAY);
        drawFilledRectangle(painter, xPosition - 8, yPosition + 138, 16, 114, Color.BLACK);
        drawFilledRectangle(painter, xPosition - 6, yPosition + 140, 12, 110, Color.WHITE);
        drawFilledRectangle(painter, netStartX, yPosition + 126, 40, 22, Color.LIGHT_GRAY);
        drawFilledRectangle(painter, rimStartX, yPosition + 148, rimLength, 8,
                new Color(255, 100, 0));
    }


    // Draws one basketball with its center at the given position.
    public static void drawBasketball(PainterAPI painter, int xPosition, int yPosition,
            int radius) {
        drawFilledCircle(painter, xPosition, yPosition, radius, new Color(235, 120, 20));

        drawLine(painter, xPosition - radius, yPosition, xPosition + radius, yPosition,
                Color.BLACK);
        drawLine(painter, xPosition, yPosition - radius, xPosition, yPosition + radius,
                Color.BLACK);
    }


    // Draws a row of basketballs using a loop.
    public static void drawBasketballRow(PainterAPI painter, int xPosition, int yPosition,
            int count) {
        for (int ball = 0; ball < count; ball++) {
            drawBasketball(painter, xPosition + ball * 60, yPosition, 14);
        }
    }


    // Draws the wall as one big rectangle.
    public static void drawWall(PainterAPI painter, Color wallColor) {
        drawFilledRectangle(painter, -400, -300, 800, 600, wallColor);
    }


    // Draws the wooden floor at the bottom of the canvas.
    public static void drawCourtFloor(PainterAPI painter, Color floorColor) {
        drawFilledRectangle(painter, -400, -300, 800, 200, floorColor);
    }


    // Draws evenly spaced white lines on the floor using a loop.
    public static void drawCourtLines(PainterAPI painter, int count) {
        int spacing = 800 / (count + 1);
        for (int line = 1; line <= count; line++) {
            drawFilledRectangle(painter, -400 + line * spacing, -300, 6, 200, Color.WHITE);
        }
    }
}