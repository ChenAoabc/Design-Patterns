package com.AoChen.adapter;

/**
 * <p>
 * description： 由于LegacyRectangle只能输出对应的坐标点，
 * 而Shape1接口的标准需要提供的是坐标点和距离，显然无法类或接口不兼容
 * 这里采用适配类将LegacyRectangle适配到Shape2接口上
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class RectangleAdapter implements Shape2{
    private final LegacyRectangle legacyRectangle;
    public RectangleAdapter(LegacyRectangle legacyRectangle){
        this.legacyRectangle = legacyRectangle;
    }
    @Override
    public void draw(int x, int y, int width, int height) {
        int x2=x+width;
        int y2=y+height;
        legacyRectangle.display(x, y,x2,y2);
    }
}
