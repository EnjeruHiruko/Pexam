package Pexam.data.utility.Enums;
import java.util.EnumSet;

public enum Type {
    
	NORMAL   (new String[]{"Fighting"}, new String[]{}, new String[]{"Ghost"}),
	FIRE     (new String[]{"Water", "Ground"}, new String[]{""}, new String[]{}),
	WATER    (new String[]{""}, new String[]{""}, new String[]{}),
	ELECTRIC (new String[]{""}, new String[]{""}, new String[]{}),
	GRASS    (new String[]{""}, new String[]{""}, new String[]{}),
	ICE      (new String[]{""}, new String[]{""}, new String[]{}),
	FIGHTING (new String[]{""}, new String[]{""}, new String[]{}),
	POISON   (new String[]{""}, new String[]{""}, new String[]{}),
	GROUND   (new String[]{""}, new String[]{""}, new String[]{}),
	FLYING   (new String[]{""}, new String[]{""}, new String[]{}),
	PSYCHIC  (new String[]{""}, new String[]{""}, new String[]{}),
	BUG      (new String[]{""}, new String[]{""}, new String[]{}),
	ROCK     (new String[]{""}, new String[]{""}, new String[]{}),
	GHOST    (new String[]{""}, new String[]{""}, new String[]{}),
	DRAGON   (new String[]{""}, new String[]{""}, new String[]{}),
	DARK     (new String[]{""}, new String[]{""}, new String[]{}),
	STEEL    (new String[]{""}, new String[]{""}, new String[]{}),
	FAIRY    (new String[]{""}, new String[]{""}, new String[]{}),
	TYPELESS (new String[]{}, new String[]{}, new String[]{});

	private final EnumSet<Type> weaknesses_;
	private final EnumSet<Type> resistances_;
	private final EnumSet<Type> immunities_;

	//public int getEffectiveness(Type attacktype) {}

	//public static double getMultiplier(int effectiveness) {}

	private Type(String[] weaknesses, String[] resistances, String[] immunities) {

		this.weaknesses_ = EnumSet.noneOf(Type.class);
		this.resistances_ = EnumSet.noneOf(Type.class);
		this.immunities_ = EnumSet.noneOf(Type.class);

	}

}