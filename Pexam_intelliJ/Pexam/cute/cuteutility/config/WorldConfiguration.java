package Pexam.cute.cuteutility.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WorldConfiguration {

    final private String version_;

    //Pokemon Config

    private int p_base_stat_mod_;

    private int p_base_sp_;

    private int p_levelup_sp_;

    private int p_max_moves_;

    private int p_max_tms_;

    private int p_base_ttp_;

    private int p_ttp_levelup_mod_;

    //Trainer Config

    private int t_base_kp_;

    private int t_base_at_;

    private int t_base_def_;

    private int t_base_sp_at_;

    private int t_base_sp_def_;

    private int t_base_spe_;

    private int t_base_sp_;

    //Combat Config

    private double c_neg_cs_;

    private double c_pos_cs_;

    private double c_type_effectiveness_;

    private int c_stab_;


    //non vanilla constants
    //private ArrayList<values> other_;


    /**
     * Constructor
     * todo redo for new parameter
     * @param worldpath
     */
    public WorldConfiguration(String worldpath){
        this.version_ = worldpath;
        //this.other_ = new ArrayList<values>();
        Path source = Paths.get("../Pexam/Pexam_intelliJ/Pexam/cute/cuteutility/versions/"+worldpath+"/config.txt" );
        try(Scanner in = new Scanner(source) ){
            while (in.hasNext()){
                String pivot = in.nextLine().trim();
                String[] mem = pivot.split("=");
                if(mem.length > 1) {
                    switch (mem[0].toLowerCase()) {
                        case "p_base_stat_mod":
                            this.p_base_stat_mod_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_base_sp":
                            this.p_base_sp_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_levelup_sp":
                            this.p_levelup_sp_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_max_moves":
                            this.p_max_moves_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_max_tms":
                            this.p_max_tms_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_base_ttp":
                            this.p_base_ttp_ = Integer.parseInt(mem[1]);
                            break;
                        case "p_ttp_levelup_mod":
                            this.p_ttp_levelup_mod_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_kp":
                            this.t_base_kp_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_at":
                            this.t_base_at_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_def":
                            this.t_base_def_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_sp_at":
                            this.t_base_sp_at_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_sp_def":
                            this.t_base_sp_def_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_spe":
                            this.t_base_spe_ = Integer.parseInt(mem[1]);
                            break;
                        case "t_base_sp":
                            this.t_base_sp_ = Integer.parseInt(mem[1]);
                            break;
                        case "c_neg_cs":
                            this.c_neg_cs_ = Double.parseDouble(mem[1]);
                            break;
                        case "c_pos_cs":
                            this.c_pos_cs_ = Double.parseDouble(mem[1]);
                            break;
                        case "c_type_effectiveness":
                            this.c_type_effectiveness_ = Double.parseDouble(mem[1]);
                            break;
                        case "c_stab":
                            this.c_stab_ = Integer.parseInt(mem[1]);
                            break;
                    }

                }
            }
        }catch(Exception mep){
            mep.printStackTrace();
        }
    }

    public WorldConfiguration(String version_, int p_base_stat_mod_, int p_base_sp_, int p_levelup_sp_, int p_max_moves_, int p_max_tms_, int p_base_ttp_, int p_ttp_levelup_mod_, int t_base_kp_, int t_base_at_, int t_base_def_, int t_base_sp_at_, int t_base_sp_def_, int t_base_spe_, int t_base_sp_, double c_neg_cs_, double c_pos_cs_, double c_type_effectiveness_, int c_stab_) {
        this.version_ = version_;
        this.p_base_stat_mod_ = p_base_stat_mod_;
        this.p_base_sp_ = p_base_sp_;
        this.p_levelup_sp_ = p_levelup_sp_;
        this.p_max_moves_ = p_max_moves_;
        this.p_max_tms_ = p_max_tms_;
        this.p_base_ttp_ = p_base_ttp_;
        this.p_ttp_levelup_mod_ = p_ttp_levelup_mod_;
        this.t_base_kp_ = t_base_kp_;
        this.t_base_at_ = t_base_at_;
        this.t_base_def_ = t_base_def_;
        this.t_base_sp_at_ = t_base_sp_at_;
        this.t_base_sp_def_ = t_base_sp_def_;
        this.t_base_spe_ = t_base_spe_;
        this.t_base_sp_ = t_base_sp_;
        this.c_neg_cs_ = c_neg_cs_;
        this.c_pos_cs_ = c_pos_cs_;
        this.c_type_effectiveness_ = c_type_effectiveness_;
        this.c_stab_ = c_stab_;
    }

    public WorldConfiguration (WorldConfiguration in){
        this(in.getVersion_(),in.getP_base_stat_mod_(), in.getP_base_sp_(), in.getP_levelup_sp_(), in.getP_max_moves_(), in.getP_max_tms_(), in.getP_base_ttp_(), in.getP_ttp_levelup_mod_(), in.getT_base_kp_(), in.getT_base_at_(), in.getT_base_def_(), in.getT_base_sp_at_(), in.getT_base_sp_def_(), in.getT_base_spe_(), in.getT_base_sp_(), in.getC_neg_cs_(), in.getC_pos_cs_(), in.getC_type_effectiveness_(), in.getC_stab_());
    }


    public String getVersion_() {
        return version_;
    }

    public int getP_base_stat_mod_() {
        return p_base_stat_mod_;
    }

    public int getP_base_sp_() {
        return p_base_sp_;
    }

    public int getP_levelup_sp_() {
        return p_levelup_sp_;
    }

    public int getP_max_moves_() {
        return p_max_moves_;
    }

    public int getP_max_tms_() {
        return p_max_tms_;
    }

    public int getP_base_ttp_() {
        return p_base_ttp_;
    }

    public int getP_ttp_levelup_mod_() {
        return p_ttp_levelup_mod_;
    }

    public int getT_base_kp_() {
        return t_base_kp_;
    }

    public int getT_base_at_() {
        return t_base_at_;
    }

    public int getT_base_def_() {
        return t_base_def_;
    }

    public int getT_base_sp_at_() {
        return t_base_sp_at_;
    }

    public int getT_base_sp_def_() {
        return t_base_sp_def_;
    }

    public int getT_base_spe_() {
        return t_base_spe_;
    }

    public int getT_base_sp_() {
        return t_base_sp_;
    }

    public double getC_neg_cs_() {
        return c_neg_cs_;
    }

    public double getC_pos_cs_() {
        return c_pos_cs_;
    }

    public double getC_type_effectiveness_() {
        return c_type_effectiveness_;
    }

    public int getC_stab_() {
        return c_stab_;
    }
}