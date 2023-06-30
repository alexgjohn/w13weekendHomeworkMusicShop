package items;

public class WindInstrument extends Instrument {

    private String material;

    private int holes;

    public WindInstrument(String description, double boughtAt, double soldFor, String material, int holes){
        super(description, boughtAt, soldFor);
        this.material = material;
        this.holes = holes;
    }

    public String getMaterial() {
        return material;
    }

    public int getHoles() {
        return holes;
    }

    @Override
    public String play() {
        return "Toodle-doodle-doo!";
    }
}
