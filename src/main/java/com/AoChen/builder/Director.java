package com.AoChen.builder;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Director {
    private HouseBuilder builder;
    public Director(HouseBuilder builder) {
        this.builder = builder;
    }
    public House constructHouse() {
        builder.buildFoundation();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        return builder.getHouse();
    }
}
