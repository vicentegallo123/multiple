public class Main {

    public static void main(String[] arg) {
        // hard-codear vectores
        double sales[]= {651,762,856,1063,1190,1298,1421,1440,1518};
        double advertising[]= {23,26,30,34,43,48,52,57,58};
        double Years[]={1,2,3,4,5,6,7,8,9};

  

        // instanciar un objeto tipo Simple Linear Regression (SLR)
        srl2 mlr = new srl2();

        System.out.println("\n");
        mlr.calculateMlR(sales,advertising,Years);
        mlr.displayRegNo();
        mlr.predict(60,10);
        
        

    }
}
