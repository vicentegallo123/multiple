public class srl2{
    private double beta0m;
    private double beta1m;
    private double beta2m;

	srl2(){
	beta0m = 0;
        beta1m = 0;
        beta2m = 0;
        }
	
    public void calculateMlR(double[] vectorSales, double[] vectorAdvertising,double[] Years) {
        int n=9;
        double sumatoria;
        double sumx2=0;
        double sumx2c=0;
        double sumy=0;
        double sumx1=0;
        double sumx1c=0;
        double ds=0;
        double dx=0;
        double dy=0;
        double dz=0;
        double Ex2x1=0;
        double Ex1y=0;
        double Ex2y=0;

        for(int i=0;i<n;i++) {
            sumx2+=vectorAdvertising[i];
            }
            for(int r=0;r<n;r++) {
            sumx2c+=Math.pow(vectorAdvertising[r],2);
              System.out.printf("\nsumatoria x2="+sumx2c);
            }
            for(int j=0;j<n;j++) {
            sumy+=vectorSales[j];
                          System.out.printf("\nsumatoria y="+sumy);
            }
            for(int k=0;k<n;k++) {
            sumx1+=Years[k];
                          System.out.printf("\nsumatoria x1="+sumx1);
            }
            for(int q=0;q<n;q++) {
            sumx1c+=Math.pow(Years[q],2);
                          System.out.printf("\nsumatoria x1="+sumx1);
            }
            for(int l=0;l<n;l++) {
            Ex2x1+=vectorAdvertising[l]*Years[l];
            }
            for(int o=0;o<n;o++) {
            Ex2y+=vectorAdvertising[o]*vectorSales[o];
            }
            for(int p=0;p<n;p++) {
            Ex1y+=Years[p]*vectorSales[p];
            }
        ds=((n*sumx1c*sumx2c)+(sumx1*Ex2x1*sumx2)+(sumx2*sumx1*Ex2x1)-(sumx2*sumx1c*sumx2)-(Ex2x1*Ex2x1*n)-(sumx2c*sumx1*sumx1));
        ds=ds;//determinante del sistema
        
        dx=((sumy*sumx1c*sumx2c)+(sumx1*Ex2x1*Ex2y)+(sumx2*Ex1y*Ex2x1)-(Ex2y*sumx1c*sumx2)-(Ex2x1*Ex2x1*sumy)-(sumx2c*Ex1y*sumx1));
        beta0m=dx/ds;//beta0
        
        dy=((n*Ex1y*sumx2c)+(sumy*Ex2x1*sumx2)+(sumx2*sumx1*Ex2y)-(sumx2*Ex1y*sumx2)-(Ex2y*Ex2x1*n)-(sumx2c*sumx1*sumy));
        beta1m=dy/ds;//beta1
        
        dz=((n*sumx1c*Ex2y)+(sumx1*Ex1y*sumx2)+(sumy*sumx1*Ex2x1)-(sumx2*sumx1c*sumy)-(Ex2x1*Ex1y*n)-(Ex2y*sumx1*sumx1));
        beta2m=dz/ds;//beta2
    }
    
    public void displayRegNo() {
        System.out.println("\nBeta0(sales) =  " + beta0m + " \nBeta1(years)= " + beta1m +  "\n Beta2(advestating)= "+beta2m);
    }
    public void predict(double advertising, double year) {
		double sales = 0;

		sales = beta0m + ((beta1m * year)+beta2m*advertising);
		System.out.println("Dado el valor de advertsing: " + advertising + " las ventas predicidas son = " + sales);
	}
}
