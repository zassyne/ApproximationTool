package approximationtool;

/**
 *
 * @author yassine
 */
public class ApproximationMethods {
    
    public static Betas leastSquaresMethod(Point[] points) {
        
        float sumx = 0f, sumy = 0f, sumx2 = 0f;
        int n = points.length;
        
        for(int i = 0; i<n; i++ ){
            sumx += points[i].getX();
            sumy += points[i].getY();
            sumx2 += points[i].getX() * points[i].getX();   
        }
        
        float xbar = sumx / n;
        float ybar = sumy / n;
        
        
        
        // second pass: compute summary statistics
        float xxbar = 0f, yybar = 0f, xybar = 0f;
        for (int i = 0; i < n; i++) {
            xxbar += (points[i].getX() - xbar) * (points[i].getX() - xbar);
            yybar += (points[i].getY() - ybar) * (points[i].getY() - ybar);
            xybar += (points[i].getX() - xbar) * (points[i].getY() - ybar);
        }
        float beta1 = xybar / xxbar;
        float beta0 = ybar - beta1 * xbar;
        return new Betas(beta1, beta0);
        
        
    }
    
    
    
    public static class Betas {
        public float a;
        public float b;
        public Betas(float a, float b) {
            this.a = a;
            this.b = b;
        }
    }
    
    
    
}
