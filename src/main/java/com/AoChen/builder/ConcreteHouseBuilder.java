package com.AoChen.builder;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public void buildFoundation() {
        house.setFoundation("Standard Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Standard Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Standard Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Standard Interior");
    }
}
