public class Empoleon extends Pokemon{
    public Empoleon() {
        super("Empoleon", Types.type.WATER, Types.type.STEEL, 278, 194, 199, 249, 227, 137, new Object[][]{
                {"Ice Beam", Types.type.ICE, Types.attackType.SPECIAL, 9000, 0, 100, Types.status.FROZEN, 10, "OPPONENT"},
                {"Earthquake", Types.type.GROUND, Types.attackType.PHYSICAL, 100, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Flash Cannon", Types.type.STEEL, Types.attackType.SPECIAL, 80, 0, 80, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Scald", Types.type.WATER, Types.attackType.SPECIAL, 80, 0, 100, Types.status.BURNED, 30, "OPPONENT"}});
    }
}
