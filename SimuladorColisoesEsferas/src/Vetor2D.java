public class Vetor2D {
    private long x;
    private long y;

    public Vetor2D() {
        setX(0);
        setY(0);
    }

    public Vetor2D(long x, long y) {
        setX(x);
        setY(y);
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
