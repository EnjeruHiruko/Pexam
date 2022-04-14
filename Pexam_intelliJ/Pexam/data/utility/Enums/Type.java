package Pexam.data.utility.Enums;
import java.util.HashSet;

public enum Type {
    
	NORMAL   (new String[]{"Fighting"},				new String[]{},							new String[]{"Ghost"}),
	FIRE     (new String[]{"Water", "Ground", "Rock"},		new String[]{"Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"},	new String[]{}),
	WATER    (new String[]{"Electric", "Grass"},			new String[]{"Fire", "Water", "Ice", "Steel"},			new String[]{}),
	ELECTRIC (new String[]{"Ground"},				new String[]{"Electric", "Flying", "Steel"},			new String[]{}),
	GRASS    (new String[]{"Fire", "Ice", "Poison", "Flying", "Bug"}, new String[]{"Water", "Electric", "Grass", "Ground"},		new String[]{}),
	ICE      (new String[]{"Fire", "Fighting", "Rock", "Steel"},	new String[]{"Ice"},						new String[]{}),
	FIGHTING (new String[]{"Flying", "Psychic", "Fairy"},		new String[]{"Bug", "Rock", "Dark"},				new String[]{}),
	POISON   (new String[]{"Ground", "Psychic"},			new String[]{"Grass", "Fighting", "Poison", "Bug", "Fairy"},	new String[]{}),
	GROUND   (new String[]{"Water", "Grass", "Ice"},		new String[]{"Poison", "Rock"},					new String[]{"Electric"}),
	FLYING   (new String[]{"Electric", "Ice", "Rock"},		new String[]{"Grass", "Fighting", "Bug", "Ground"},		new String[]{}),
	PSYCHIC  (new String[]{"Bug", "Ghost", "Dark"},			new String[]{"Fighting", "Psychic"},				new String[]{}),
	BUG      (new String[]{"Fire", "Flying", "Rock"},		new String[]{"Grass", "Fighting", "Ground"},			new String[]{}),
	ROCK     (new String[]{"Water", "Grass", "Fighting", "Ground", "Steel"}, new String[]{"Normal", "Fire", "Poison", "Flying"},	new String[]{}),
	GHOST    (new String[]{"Ghost", "Dark"},			new String[]{"Poison", "Bug"},					new String[]{"Normal", "Fighting"}),
	DRAGON   (new String[]{"Ice", "Dragon", "Fairy"},		new String[]{"Fire", "Water", "Grass", "Electric"},		new String[]{}),
	DARK     (new String[]{"Fighting", "Bug", "Fairy"},		new String[]{"Ghost", "Dark"},					new String[]{"Psychic"}),
	STEEL    (new String[]{"Fire", "Fighting", "Ground"}, new String[]{"Normal", "Grass", "Ice", "Flying", "Psychic", "Bug", "Rock", "Dragon", "Steel", "Fairy"}, new String[]{"Poison"}),
	FAIRY    (new String[]{"Poison", "Steel"},			new String[]{"Fighting", "Bug", "Dark"},			new String[]{"Dragon"}),
	TYPELESS (new String[]{}, new String[]{}, new String[]{});

	/** The names of the weaknesses of this. */
	private final HashSet<String> weaknesses_;

	/** The names of the resistances of this. */
	private final HashSet<String> resistances_;

	/** The names of the immunities of this. */
	private final HashSet<String> immunities_;


	/** Obtains the corresponding damage multiplier from a given Effectiveness.
	 * @param relation the identifying number of the effectiveness.
	 */
	public static double getMultiplier(int relation) {

		switch(relation) {
			case 9 : return 0.0;
			case -3: return 0.125;
			case -2: return 0.25;
			case -1: return 0.5;
			case  0: return 1.0;
			case  1: return 1.5;
			case  2: return 2.0;
			case  3: return 3.0;
		}

		return 10.0;

	}


	/** Determines the Effectiveness another Type has on this and returns it's identifying number.
	 * @param The name of the other type.
	 */
	public int getEffectiveness(String attacktype) {

		if(this.immunities_.contains(attacktype)) {
			return 9;

		} else if(this.weaknesses_.contains(attacktype)) {
			return 1;

		} else if(this.resistances_.contains(attacktype)) {
			return -1;

		} else {
			return 0;

		}

	}


	/** Determines the Effectiveness another Type has on this and returns it's identifying number.
	 * @param The other type.
	 */
	public int getEffectiveness(Type attacktype) {
		return this.getEffectiveness(attacktype.toString());
	}


	/** Determines the Effectiveness another Type has on this and returns the corresponding damage multiplier.
	 * @param The other type.
	 */
	public double getEffectivenessMultiplier(Type attacktype) {
		return getMultiplier(this.getEffectiveness(attacktype));
	}


	private Type(String[] weaknesses, String[] resistances, String[] immunities) {

		this.weaknesses_ = new HashSet<String>();
		this.resistances_ = new HashSet<String>();
		this.immunities_ = new HashSet<String>();


		for(String w: weaknesses) {
			this.weaknesses_.add(w.toUpperCase());
		}

		for(String r: resistances) {
			this.resistances_.add(r.toUpperCase());
		}

		for(String i: immunities) {
			this.immunities_.add(i.toUpperCase());
		}

	}

	/**
	public static void main(String[] test) {

		out.println(NORMAL.getEffectivenessMultiplier(FIGHTING));

	}
	**/
}