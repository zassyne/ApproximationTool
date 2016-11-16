package approximationtool;

import javafx.beans.property.SimpleFloatProperty;
/**
 *
 * @author yassine
 */
public class Point {
    private final SimpleFloatProperty x = new SimpleFloatProperty();
    private final SimpleFloatProperty y = new SimpleFloatProperty();
    
    public Point() {
        this(0, 0);
    }
    
    public Point(float x, float y) {
        
        this.x.set(x);
        this.y.set(y);
    }
    
    public void setX(float x) {
        this.x.set(x);
    }
    public void setY(float y) {
        this.y.set(y);
    }
    
    public float getX() { return x.get();}
    public float getY() { return y.get();}
    
}
