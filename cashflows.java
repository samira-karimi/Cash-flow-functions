/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
    import jsl.utilities.random.distributions.Normal;
    import jsl.utilities.statistic.Statistic;
/**
 *
 * @author Samira
 */
public class hw1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("P given F is: "+getPgivenF(0.1,5,100)); //1-a
        System.out.println("P given A is: "+getPgivenA(0.1,5,100)); //1-b
        System.out.println("F given P is: "+getFgivenP(0.1,5,100)); //1-c
        System.out.println("A given P is: "+getAgivenP(0.1,5,100)); //1-d
        System.out.println("F given A is: "+getFgivenA(0.1,5,100)); //1-e
        System.out.println("A given F is: "+getAgivenF(0.1,5,100)); //1-f
        
        
        double[] Test={-4000,400,400,400,400}; //2
        CashFlow CF=new CashFlow(0.1, Test);   //2
        System.out.println("The present worth of our test cash flow for question 2 is: "+CF.getPresentWorth());  //2
        
        
//        double r = 0.10;
//        double[] y = {-5000.0, 1400.0, 4100.0, 4000.0, 200.0};
//        CashFlow c = new CashFlow(r, y);
//        System.out.println("Question 6's answer is: "+c.getAnnualWorth());
        
        
        
        
        Normal normRnd = new Normal(2, Math.pow(1.5, 2)); //3
        Statistic SampleCollector = new Statistic();
        Statistic ProbabilityCollector = new Statistic();
        double[] sample = normRnd.getSample(1000);
        SampleCollector.collect(sample);
        for(double v: sample){
            ProbabilityCollector.collect(v > 1);
        }
        
//        for (int k = 0; k < 1000; k++) {
//            double nn = normRnd.getValue();
//            SampleCollector.collect(nn);
//            if (nn > 1) {
//                ProbabilityCollector.collect(true);
//            } else {
//                ProbabilityCollector.collect(false);
//            }
//        }

        System.out.println("The sample size is: " + SampleCollector.getCount());
        System.out.println("The sample mean is: " + SampleCollector.getAverage());
        System.out.println("The sample Standars Deviation is: " + SampleCollector.getStandardDeviation());
        System.out.println("The sample minimum is: " + SampleCollector.getMin());
        System.out.println("The sample maximum is: " + SampleCollector.getMax());
        System.out.println("The sample %99 confidence interval is: " + SampleCollector.getConfidenceInterval(0.99));
        System.out.println("95% confidence interval for P(x>1) is: " + ProbabilityCollector.getConfidenceInterval(0.95));
        
    
        
    }
     public static double getPgivenF(double i, int n, double f){ //1
        double p;
        p=f*(1/Math.pow(1+i, n));
        return p;
    }
    public static double getPgivenA(double i, int n, double a){
        double p;
        p=a*((Math.pow(i+1, n)-1)/(i*Math.pow(1+i, n)));
        return p;
    }
    
    public static double getFgivenP(double i, int n, double p){
    double f;
    f=p*(Math.pow(1+i, n));
    return f;
    }
    
    public static double getAgivenP(double i, int n, double p){
    double a;
    a=p*i*(i*Math.pow(1+i, n))/((Math.pow(i+1, n)-1));
    return a;    
    }
    
    public static double getFgivenA(double i, int n, double a){
    double p;
    double f;
    p=a*((Math.pow(i+1, n)-1)/(i*Math.pow(1+i, n)));
    f=p*(Math.pow(1+i, n));
    return f;
    }
    
    public static double getAgivenF(double i, int n, double f){
    double p;
    double a;
    p=f*(1/Math.pow(1+i, n));
    a=p*i*(i*Math.pow(1+i, n))/((Math.pow(i+1, n)-1));
    return a;
    }
    
    }
    

