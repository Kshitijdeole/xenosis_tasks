package Part2.TextGame;

class MeleePlayer extends Player {
    public MeleePlayer(String name) {
        super(name);
        this.health=80;
        this.attackPower=20;
    }

    @Override
    public void attack(Enemy enemy) {
        enemy.health -=this.attackPower;
        System.out.println("you attacked the "+ enemy.name+ " and dealt "+this.attackPower+" damage");
    }

}
