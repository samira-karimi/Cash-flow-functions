/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashflows;
    import jsl.utilities.random.distributions.Normal;
    import jsl.utilities.statistic.Statistic;
/**
 *
 * @author Samira
 */
public class cashflows {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("P given F is: "+getPgivenF(0.1,5,100)); 
        System.out.println("P given A is: "+getPgivenA(0.1,5,100)); 
        System.out.println("F given P is: "+getFgivenP(0.1,5,100)); 
        System.out.println("A given P is: "+getAgivenP(0.1,5,100)); 
        System.out.println("F given A is: "+getFgivenA(0.1,5,100)); 
        System.out.println("A given F is: "+getAgivenF(0.1,5,100)); 
  
        
        Normal normRnd = new Normal(2, Math.pow(1.5, 2)); //3
        Statistic SampleCollector = new Statistic();
        Statistic ProbabilityCollector = new Statistic();
        double[] sample = normRnd.getSample(1000);
        SampleCollector.collect(sample);
        for(double v: sample){
            ProbabilityCollector.collect(v > 1);
        }
        

        System.out.println("The sample size is: " + SampleCollector.getCount());
        System.out.println("The sample mean is: " + SampleCollector.getAverage());
        System.out.println("The sample Standars Deviation is: " + SampleCollector.getStandardDeviation());
        System.out.println("The sample minimum is: " + SampleCollector.getMin());
        System.out.println("The sample maximum is: " + SampleCollector.getMax());
        System.out.println("The sample %90 confidence interval is: " + SampleCollector.getConfidenceInterval(0.90));
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
    

