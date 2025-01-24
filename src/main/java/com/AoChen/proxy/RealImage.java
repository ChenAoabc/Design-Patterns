package com.AoChen.proxy;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class RealImage  implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk(){
        System.out.println("Loading image "+fileName+" from disk");
    }
    @Override
    public void display() {
        System.out.println("Displaying image "+fileName);
    }
}
