public class Charizard extends Pokemon{
    public Charizard() {
        super("Charizard", Types.type.FIRE, Types.type.FLYING, 266, 213, 161, 323, 235, 205, new Object[][]{
                {"Hurricane", Types.type.FLYING, Types.attackType.SPECIAL, 110, 0, 70, Types.status.PARALYZED, 30, "OPPONENT"},
                {"Dragon Pulse", Types.type.DRAGON, Types.attackType.SPECIAL, 85, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Flamethrower", Types.type.FIRE, Types.attackType.SPECIAL, 90, 0, 100, Types.status.BURNED, 10, "OPPONENT"},
                {"Scorching Sands", Types.type.GROUND, Types.attackType.SPECIAL, 70, 0, 100, Types.status.BURNED, 30, "OPPONENT"}});
    }
}
