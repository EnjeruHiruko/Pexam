package Pexam.data.Capabilities;

public class Capabilities{

    private String name_;

    private String description_;

    private String[] zones_;

    private String condition_;

    private int value_;

    private int value2_;

    //Constructor and creation block

    public Capabilities(){
        this.name_ = "";
        this.description_ = "";
        this.value_ = 0;
    }

    public Capabilities(String input){

        String in = input.trim();
        //System.out.println(in);
        String[] temp = in.split("\\$");
        StringBuilder pivot = new StringBuilder();
        for (int c = 0; c < temp.length; c++) {
            if (c == temp.length - 1) {
                try {
                    this.value_ = Integer.parseInt(temp[c]);
                } catch (NumberFormatException e) {
                    if (c != 0) {
                        pivot.append(" ");
                    }
                    pivot.append((temp[c].trim()));
                }
            } else {
                if (c != 0) {
                    pivot.append(" ");
                }
                pivot.append((temp[c].trim()));
            }
        }
        //System.out.println(pivot.toString());
        this.name_ = pivot.toString();
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public String getDescription() {
        return this.description_;
    }

    public int getValue() {
        return this.value_;
    }

    //Setter Block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setDescription(String description) {
        this.description_ = description;
    }

    public void setValue(int value) {
        this.value_ = value;
    }

    //misc block

    public String toString(){
        if(value_ != 0){
            return name_ + ": " + value_;
        }else{
            return name_;
        }

    }

}