public class Togekiss extends Pokemon {
    public Togekiss() {
        super("Togekiss", Types.type.FAIRY, Types.type.FLYING, 280, 115, 214, 269, 258, 181, new Object[][]{
                {"Air Slash", Types.type.FLYING, Types.attackType.SPECIAL, 85, 0, 95, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Dazzling Gleam", Types.type.FAIRY, Types.attackType.SPECIAL, 80, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Aura Sphere", Types.type.FIGHTING, Types.attackType.SPECIAL, 80, 0, 101, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Thunder Wave", Types.type.ELECTRIC, Types.attackType.STATUS, 0, 0, 90, Types.status.PARALYZED, 100, "OPPONENT"}});
    }
}
