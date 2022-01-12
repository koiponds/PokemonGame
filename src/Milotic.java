public class Milotic extends Pokemon{
    public Milotic() {
        super("Milotic", Types.type.WATER, Types.type.NOSECONDTYPE, 300, 137, 179, 225, 280, 183, new Object[][]{
                {"Recover", Types.type.NORMAL, Types.attackType.STATUS, 0, 150, 101, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Shadow Ball", Types.type.DARK, Types.attackType.SPECIAL, 80, 0, 100, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Hydro Pump", Types.type.WATER, Types.attackType.SPECIAL, 110, 0, 80, Types.status.NOSTATUSEFFECT, 100, "SELF"},
                {"Scald", Types.type.WATER, Types.attackType.SPECIAL, 80, 0, 100, Types.status.BURNED, 30, "OPPONENT"}});
    }
}
