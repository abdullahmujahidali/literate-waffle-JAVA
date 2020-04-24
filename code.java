import java.util.Scanner;


public class Fractions {
   private int numerator;
   private int denominator;

   // constructor with GCD capability
   public Fractions(int num, int denom) {
int gcd = getGCD(num,denom);
if(denom>0)
   this.numerator = num/gcd;
else
   this.numerator = -1*num/gcd;
this.denominator = Math.abs(denom)/gcd;
   }
  
   // getting greatest common divisor for a fraction
private static int getGCD(int num, int denom) {
int gcd=1;
int n = Math.abs(num);
int d = Math.abs(denom);
  
for (int i = 1; i <= n && i <= d; i++)
if (n % i == 0 && d % i == 0)
gcd = i;

return gcd;
}
  
// operations + - / *
  
   public Fractions add(Fractions f){
       int num = this.numerator*f.denominator + this.denominator*f.numerator;
       int denom = this.denominator*f.denominator;
       return new Fractions(num,denom);
   }
  
   public Fractions subtract(Fractions f){
       int num = this.numerator*f.denominator - this.denominator*f.numerator;
       int denom = this.denominator*f.denominator;
       return new Fractions(num,denom);
   }
  
  
   public Fractions divide(Fractions f){
       int num = this.numerator*f.denominator;
       int denom = this.denominator*f.numerator;
       return new Fractions(num,denom);
   }
  
   public Fractions multiply(Fractions f){
       int num = this.numerator*f.numerator;
       int denom = this.denominator*f.denominator;
       return new Fractions(num,denom);
   }
  
// comparing two fraction for <,> or ==
   public String compare(Fractions f){

       if(this.subtract(f).numerator<0) // (f1numerator - f2numerator)<0 ?
           return "<";
       else if(f.subtract(this).numerator<0) // (f2numerator - f1numerator)<0 ?
           return ">";
       else
           return "==";
   }
  

   // formating the output message and also for conversion of improper fractions to mixed fraction
   @Override
   public String toString(){
      
   if(Math.abs(this.numerator)<=this.denominator){ // proper fraction
       return this.numerator+"/"+this.denominator;
   }else{   // improper fraction -->convert to mixed before displaying
   int wholeNumber = (int) Math.floor(this.numerator/this.denominator);
   int remainder = (int) (this.numerator % this.denominator);
  
   if (remainder!=0) // case of whole numbers
   return wholeNumber+" "+Math.abs(remainder)+"/"+this.denominator;
   else
       return wholeNumber+"";  
  
   }
  
   }
  

   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int num1,denom1,num2,denom2;
       double n,d;
       int i,j;
      
      
       i=0;
       do{
       if (i<1)
           System.out.println("Please enter the first numerator> ");
       else
       System.out.println("Please enter an integer> ");
         
         
       n = input.nextDouble();
       i++;
       }while(Math.floor(n)!=n);
       num1 = (int) n;

       j=0;
       do{
       if (j<1)
           System.out.println("Please enter the first denominator> ");
       else
       System.out.println("Please enter a non-zero integer> ");
         
       d = input.nextDouble();
       j++;
       }while(Math.floor(d)!=d || d==0);
       denom1 = (int) d;
         
         
       Fractions f1 = new Fractions(num1,denom1);
System.out.println(f1.toString());
         
  
  
  
       i=0;
       do{
       if (i<1)
           System.out.println("Please enter the second numerator> ");
       else
       System.out.println("Please enter an integer> ");
         
         
       n = input.nextDouble();
       i++;
       }while(Math.floor(n)!=n);
       num2 = (int) n;

       j=0;
       do{
       if (j<1)
           System.out.println("Please enter the second denominator> ");
       else
       System.out.println("Please enter a non-zero integer> ");
         
       d = input.nextDouble();
       j++;
       }while(Math.floor(d)!=d || d==0);
       denom2 = (int) d;
         
         
       Fractions f2 = new Fractions(num2,denom2);
System.out.println(f2.toString());
  
System.out.println(f1.toString()+" + "+f2.toString()+" = " +f1.add(f2));
System.out.println(f1.toString()+" - "+f2.toString()+" = " +f1.subtract(f2));
System.out.println(f1.toString()+" * "+f2.toString()+" = " +f1.multiply(f2));
System.out.println(f1.toString()+" ÷ "+f2.toString()+" = " +f1.divide(f2));
System.out.println(f1.toString()+" "+f1.compare(f2)+" "+f2.toString());
      
   }

}
