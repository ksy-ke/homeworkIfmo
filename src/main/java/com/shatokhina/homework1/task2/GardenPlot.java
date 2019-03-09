package com.shatokhina.homework1.task2;

public class GardenPlot {
/*    private final int gardenPlot = 1000;
    private final int areaBed = 15 * 25;

    public int getRemainder() { return gardenPlot % areaBed; }*/

    private final int lengthPlot;
    private final int widthPlot;

    public GardenPlot(int lengthPlot, int widthPlot) {
        if (lengthPlot <= 0 || widthPlot <= 0) {
            throw new IllegalArgumentException();
        }
        this.lengthPlot = lengthPlot;
        this.widthPlot = widthPlot;
    }

    private int calculateOccupiedArea(int width, int length) {
        int countWidth = widthPlot / width;
        int remainderWidth = widthPlot % width;
        int countLength = lengthPlot / length;
        int remainderLength = lengthPlot % length;

        if (remainderWidth > length) {
            countLength += remainderWidth / length;
            countWidth += remainderLength / width;
        }
        if (remainderLength > width) {
            countWidth += remainderLength / width;
            countLength += remainderWidth / length;
        }
        return countLength * length * countWidth * width;
    }

    public int remainderArea(int widthBed, int lengthBed) {
        if (widthBed <= 0 || lengthBed <= 0 ||
                widthPlot < widthBed && lengthPlot < widthBed ||
                widthPlot < lengthBed && lengthPlot < lengthBed) {
            throw new IllegalArgumentException();
        }

        int widthLength = calculateOccupiedArea(widthBed, lengthBed);
        int lengthWidth = calculateOccupiedArea(lengthBed, widthBed);

        return widthLength > lengthWidth ?
                widthPlot * lengthPlot - widthLength :
                widthPlot * lengthPlot - lengthWidth;
    }
}
