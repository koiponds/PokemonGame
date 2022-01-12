public class Turtwig extends Pokemon{
    public Turtwig() {
        super("Turtwig", Types.type.GRASS, Types.type.NOSECONDTYPE, 354, 298, 289, 247, 269, 217, new Object[][]{
                {"Seed Bomb", Types.type.GRASS, Types.attackType.PHYSICAL, 90, 0, 100, Types.status.FROZEN, 10, "OPPONENT"},
                {"Giga Drain", Types.type.GROUND, Types.attackType.SPECIAL, 75, 30, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Crunch", Types.type.DARK, Types.attackType.PHYSICAL, 80, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Body Slam", Types.type.NORMAL, Types.attackType.PHYSICAL, 85, 0, 100, Types.status.PARALYZED, 30, "OPPONENT"}});
    }
}
