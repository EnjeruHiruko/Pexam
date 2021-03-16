package Pexam.cute.cuteutility.config;

public class values{

    private String name_;

    private double value_;

    public values (String[] in){
        this.name_ = in[0];
        this.value_ = Integer.parseInt(in[1].trim());
    }

    @Override
    public String toString() {
        return "values{" +
                "name_='" + name_ + '\'' +
                ", value_=" + value_ +
                '}';
    }
}