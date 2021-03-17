package Pexam.data.utility.Enums;

public enum Type{
    /*
    0 = neutral
    1 = effective
    9 = resistence
    -1 = immunity
     */
    NORMAL  (new int[]{0,0,0,0,0,0,0,0,0,0,0,0,9,-1,0,0,9,0},0),
    FIRE    (new int[]{0,9,9,0,1,1,0,0,0,0,0,1,9,0,9,0,1,0},1),
    WATER   (new int[]{0,1,9,0,9,0,0,0,1,0,0,0,1,0,9,0,0,0},2),
    ELECTRIC(new int[]{0,0,1,9,9,0,0,0,-1,1,0,0,0,0,9,0,0,0},3),
    GRASS   (new int[]{0,9,1,0,9,0,0,9,1,9,0,9,1,0,9,0,9,0},4),
    ICE     (new int[]{0,9,9,0,1,9,0,0,1,1,0,0,0,0,1,0,9,0},5),
    FIGHTING(new int[]{1,0,0,0,0,1,0,9,0,9,9,9,1,-1,0,1,1,9},6),
    POISON  (new int[]{0,0,0,0,1,0,0,9,9,0,0,0,0,9,0,0,-1,1},7),
    GROUND  (new int[]{0,1,0,1,9,0,0,1,0,-1,0,9,1,0,0,0,1,0},8),
    FLYING  (new int[]{0,0,0,9,1,0,1,0,0,0,0,1,9,0,0,0,9,0},9),
    PSYCHIC (new int[]{0,0,0,0,0,0,1,1,0,0,9,0,1,0,0,-1,9,0},10),
    BUG     (new int[]{0,9,0,0,1,0,9,9,0,9,1,0,9,9,0,1,9,9},11),
    ROCK    (new int[]{0,1,0,0,0,1,9,0,9,1,0,1,0,0,0,0,9,0},12),
    GHOST   (new int[]{-1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,9,0,0},13),
    DRAGON  (new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,9,-1},14),
    DARK    (new int[]{0,0,0,0,0,0,9,0,0,0,1,0,0,1,0,9,0,9},15),
    STEEL   (new int[]{0,9,9,9,0,1,0,0,0,0,0,0,1,0,0,0,9,1},16),
    FAIRY   (new int[]{0,9,0,0,0,0,1,9,0,0,0,0,0,0,1,1,9,0},17),
    UKN     (new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},18);

    private final int[] relation_;

    private final int rank_;

    Type(int[] relations, int rank){
        this.relation_ = relations;
        this.rank_ = rank;
    }

    public int[] getRelation() {
        return relation_;
    }

    public int getRank() {
        return rank_;
    }


}