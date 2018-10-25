
public interface Competitor {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    boolean isOnDistance();

    boolean isRunning();

    boolean isSwiming();

    boolean isJumping();

    String getName();

}
