package items;

import behaviours.IPlay;

public abstract class Instrument extends Item implements IPlay {

    public Instrument(String description, double boughtAt, double soldFor){
        super(description, boughtAt, soldFor);
    }

}
