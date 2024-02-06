package Problem10;

import javax.swing.*;
import java.awt.*;

public class Problem10 extends JPanel {

    private int level;

    public Problem10(int level) {
        this.level = level;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTriangle(g, getWidth() / 2, getHeight() / 2, getHeight(), level);
    }

    private void drawTriangle(Graphics g, int x, int y, int size, int level) {
        if (level == 0) {

            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{x - size / 2, x + size / 2, x},
                    new int[]{y - size, y - size, y}, 3);
        } else {
            drawTriangle(g, x - size / 2, y + size, size / 2, level - 1);
            drawTriangle(g, x + size / 2, y + size, size / 2, level - 1);
            drawTriangle(g, x, (y - size), size / 2, level - 1);
        }
    }

    public static void main(String[] args) {
        int level = 6;
        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.add(new Problem10(level));
        frame.setVisible(true);
    }
}