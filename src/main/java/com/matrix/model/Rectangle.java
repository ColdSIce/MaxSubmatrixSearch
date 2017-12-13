package com.matrix.model;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    private int s;

    public Rectangle() {
    }

    public Rectangle(Point topLeft, Point bottomRight, int s) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.s = s;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rect S = ");
        builder.append(s);
        builder.append(", coordinates: ");
        if(topLeft != null) builder.append("(")
                .append(topLeft.getX())
                .append(",")
                .append(topLeft.getY())
                .append(")");
        else builder.append("(null,null)");
        builder.append(",");
        if(bottomRight != null) builder.append("(")
                .append(bottomRight.getX())
                .append(",")
                .append(bottomRight.getY())
                .append(")");
        else builder.append("(null,null)");
        return builder.toString();
    }
}
