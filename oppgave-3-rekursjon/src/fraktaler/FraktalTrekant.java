package fraktaler;

public class FraktalTrekant extends Fraktal {
    public FraktalTrekant(int depth, int delay, Tegneflate canvas) {
        super(depth, delay, canvas);
    }

    @Override
    public void tegn() {
        drawTriangle(depth, 20, 800, (20+800)/2, 124, 800, 800);
    }

    private void drawTriangle(int level, int p1X, int p1Y, int p2X, int p2Y, int p3X, int p3Y) {

        canvas.tegnTrekant(p1X, p1Y, p2X, p2Y, p3X, p3Y);
        ventMillis(delay);

        if (level > 0) {
            drawTriangle(level-1, p1X, p1Y, (p1X+p2X)/2, (p1Y+p2Y)/2, (p1X+p3X)/2, (p1Y+p3Y)/2);
            drawTriangle(level-1, (p1X+p2X)/2, (p1Y+p2Y)/2, p2X, p2Y, (p2X+p3X)/2, (p2Y+p3Y)/2);
            drawTriangle(level-1, (p1X+p3X)/2, (p1Y+p3Y)/2, (p2X+p3X)/2, (p2Y+p3Y)/2, p3X, p3Y);
        }

    }
}
