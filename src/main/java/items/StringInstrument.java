package items;

public class StringInstrument extends Instrument{

    private int strings;

    public StringInstrument(String description, double boughtAt, double soldFor, int strings){
        super(description, boughtAt, soldFor);
        this.strings = strings;
    }

    public int getStrings() {
        return strings;
    }


    @Override
    public String play() {
        return "struuuuuuuum!";
    }
}
