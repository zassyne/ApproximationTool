package approximationtool;

import Jama.Matrix;

/**
 *
 * @author yassine
 */
public class ApproximationMethods {
    
    public static Betas leastSquaresMethod(Point[] points) {
        
        double sumx = 0f, sumy = 0f, sumx2 = 0f;
        int n = points.length;
        
        for(int i = 0; i<n; i++ ){
            sumx += points[i].getX();
            sumy += points[i].getY();
            sumx2 += points[i].getX() * points[i].getX();   
        }
        
        double xbar = sumx / n;
        double ybar = sumy / n;
        
        
        // We compute summary statistics
        double xxbar = 0f, yybar = 0f, xybar = 0f;
        for (int i = 0; i < n; i++) {
            xxbar += (points[i].getX() - xbar) * (points[i].getX() - xbar);
            yybar += (points[i].getY() - ybar) * (points[i].getY() - ybar);
            xybar += (points[i].getX() - xbar) * (points[i].getY() - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;
        return new Betas(beta1, beta0);
        
        
    }
    
    
    
    public static class Betas {
        public double a;
        public double b;
        public Betas(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }
    
    
    public static double[] findPolynomalFactorsLaGrangeInterpolationSecond(Point[] points){//double[] x, double[] y) {

        int n = points.length;

        double[][] data = new double[n][n];
        double[]   rhs  = new double[n];

        for (int i = 0; i < n; i++) {
          double v = 1;
          for (int j = 0; j < n; j++) {
            data[i][n-j-1] = v;
            v *= points[i].getX();
          }

          rhs[i] = points[i].getY();
        }

        // Solving m * s = b

        Matrix m = new Matrix (data);
        Matrix b = new Matrix (rhs, n);

        Matrix s = m.solve (b);

        return s.getRowPackedCopy();
    }
    
    
    
    
}
