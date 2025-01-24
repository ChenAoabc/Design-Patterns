package com.AoChen.builder;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }
    @Override
    public String toString() {
        return "House [foundation="+foundation+", structure="+structure+", roof="+roof+", interior="+interior+"]";
    }
}
