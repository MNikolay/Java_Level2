

public class Team {
    private String name;
    Competitor[] player;

    public Team(String name, Competitor player[]) {
        this.name=name;
        this.player=player;
    }

    public void showResults() {
        System.out.printf("Результаты команды: %s",this.name);
        System.out.println();
        for (Competitor c:this.player)
        {
           System.out.println(c.getName() + ((c.isRunning())?" успешно прошел бег" : " провалил бег"));
           System.out.println(c.getName() + ((c.isJumping())?" успешно прыгнул" : " провалил прыжок"));
           System.out.println(c.getName() + ((c.isSwiming())?" успешно проплыл" : " провалил плавание")) ;
           System.out.println(c.getName() + ((c.isOnDistance())?" прошел полосу препятсвий" : " сошел с дистанции")) ;
           System.out.println("-----------------");

        }
    }
}
