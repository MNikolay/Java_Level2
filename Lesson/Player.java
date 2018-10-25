
import java.util.Random;

public class Player implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;


    private boolean isRun;
    private boolean isSwim;
    private boolean isJump;

    private final Random random = new Random();

    public Player(String name) {
        this.name = name;
        this.maxRunDistance = random.nextInt(3000)+2500;
        this.maxJumpHeight = random.nextInt(20)+25;
        this.maxSwimDistance = random.nextInt(100)+150;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            isRun=true;
        } else {
            isRun=false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            isSwim=true;
        } else {
            isRun=false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            isJump=true;
        } else {
            isJump=false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return isJump && isSwim &&isRun;
    }


    @Override
    public boolean isRunning() {
        return isRun;
    }

    @Override
    public boolean isSwiming() {
        return isSwim;
    }

    @Override
    public boolean isJumping() {
        return isJump;
    }

    @Override
    public String getName() {
        return name;
    }
}
