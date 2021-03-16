package Pexam.data.utility.Enums;

public class Frequency{

    Freq freq_;

    int value_;

    public Frequency(){
        this.freq_ = Freq.NON;
        this.value_ = 0;
    }

    public Frequency(String input){
        String[] temp = input.split("#");
        this.freq_ = Freq.valueOf(temp[0]);
        if(this.freq_ == Freq.AW || this.freq_ == Freq.EOT || this.freq_ == Freq.STATIC || this.freq_ == Freq.NON){
            this.value_ = 0;
        } else {
            if(temp.length > 1){
                this.value_ = Integer.valueOf(temp[1]);
            }
            if(temp[1] == null){
                this.value_ = 0;
            }
        }
    }

    public Frequency(Freq freq, int value){
        if(freq == Freq.STATIC || freq == Freq.AW || freq == Freq.EOT){
            this.freq_ = freq;
            this. value_ = 0;
        } else if(freq == Freq.SCENE || freq == Freq.DAILY) {
            this.freq_ = freq;
            this.value_ = 1 * value;
        }
    }

    public void setFrequency(Freq freq, int value){
        if(freq == Freq.STATIC || freq == Freq.AW || freq == Freq.EOT){
            this.freq_ = freq;
            this. value_ = 0;
        } else if(freq == Freq.SCENE || freq == Freq.DAILY) {
            this.freq_ = freq;
            this.value_ = 1 * value;
        }
    }

    public Freq getFreq() {
        return this.freq_;
    }

    public int getValue() {
        return this.value_;
    }

    @Override
    public String toString() {
        return "" + freq_ + " " + value_;
    }
}