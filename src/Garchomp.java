public class Garchomp extends Pokemon{
    public Garchomp() {
        super("Garchomp", Types.type.DRAGON, Types.type.GROUND, 326, 291, 214, 181, 192, 229, new Object[][]{
                {"Dragon Claw", Types.type.DRAGON, Types.attackType.PHYSICAL, 80, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Poison Jab", Types.type.POISON, Types.attackType.PHYSICAL, 80, 0, 100, Types.status.POISONED, 30, "OPPONENT"},
                {"Earthquake", Types.type.GROUND, Types.attackType.PHYSICAL, 100, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Fire Fang", Types.type.FIRE, Types.attackType.PHYSICAL, 65, 0, 95, Types.status.BURNED, 20, "OPPONENT"}});
    }
}
