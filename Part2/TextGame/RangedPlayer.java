package Part2.TextGame;

class RangedPlayer extends Player{

    public RangedPlayer(String name){
        super(name);
        this.health=100;
        this.attackPower=10;
    }

    @Override
    public void attack(Enemy enemy) {
        this.health -= this.attackPower;
        System.out.println("you shot an arrow at this "+enemy.name+"and dealt"+this.attackPower+"damage.");
    }

}
