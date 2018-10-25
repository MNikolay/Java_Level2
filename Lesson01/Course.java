import java.util.Random;

public abstract class Course {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Course {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}

class Water extends Course {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}

class Cross extends Course {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}

class MainCourse {

    public static void main(String[] args) {

        Random random = new Random();
        int runDistance=random.nextInt(3000)+2000;
        int jumpHeight=random.nextInt(20)+10;
        int swimDistance= random.nextInt(100)+100;

        Competitor[] player = {new Player("Sergey"), new Player("Ivan"), new Player("Yura"), new Player("Dima")};
        Team team = new Team("Winners",player);
        Course[] course = {new Cross(runDistance), new Wall(jumpHeight), new Water(swimDistance)};

        for (Course c : course) {
            for (Competitor t: team.player) {
                c.doIt(t);
                if (!t.isOnDistance())
                {
                    break;
                }
            }
        }

        team.showResults();
    }
}