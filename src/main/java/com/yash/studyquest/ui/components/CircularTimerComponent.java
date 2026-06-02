package com.yash.studyquest.ui.components;

import javax.swing.*;
import java.awt.*;

public class CircularTimerComponent extends JPanel {

    private Color progressColor =
            new Color(0, 170, 255);
    private String timeText = "25:00";
    private double progress = 1.0;

    public void setProgressColor(Color color) {

        this.progressColor = color;

        repaint();
    }

    public CircularTimerComponent() {
        setOpaque(false);
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
        repaint();
    }

    public void setProgress(double progress) {
        this.progress = progress;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 350);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight()) - 40;

        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2.setStroke(new BasicStroke(12));

        // Background Circle
        g2.setColor(new Color(70, 70, 70));
        g2.drawOval(x, y, size, size);

        // Progress Arc (temporary)
        g2.setColor(progressColor);
        g2.drawArc(x, y, size, size, 90, (int) (-360 * progress));

        // Time Text
        g2.setFont(new Font("Arial", Font.BOLD, 42));

        String time = timeText;

        FontMetrics fm = g2.getFontMetrics();

        int textX = getWidth() / 2 - fm.stringWidth(time) / 2;

        int textY = getHeight() / 2 + fm.getAscent() / 3;

        g2.drawString(time, textX, textY);

        g2.dispose();
    }
}