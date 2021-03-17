package Pexam.data.Pokemon;

public class Evolution{

    private String name_;

    private String means_;

    private int level_;

    //Constructor and Creation block

    public Evolution(){
        this.name_ = "";
        this.level_ = 0;
    }

    public Evolution(String[] in){
        this.name_ = in[0].replace("$", " ");
        String temp = in[1].replace("$", "---");
        String[] well = temp.split("---");
        try {
            if (well.length == 1) {
                this.level_ = Integer.parseInt(well[0]);
            } else {
                String mem = "";
                for (int c = 0; c < well.length; c++) {
                    if (c != well.length - 1) {
                        mem += well[c];
                    }
                }
                this.means_ = mem;
                this.level_ = Integer.parseInt(well[well.length - 1]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Evolution(String name, int level){
        this.name_ = name;
        this.level_ = level;
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public int getLevel() {
        return this.level_;
    }

    //Setter block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setLevel(int level) {
        this.level_ = level;
    }


    //misc block

    public String toString(){
        return "Evolution: " + name_ +" at " + level_ + "%n";
    }

}