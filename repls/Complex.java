public class Complex{
  private double real;
  private double imaginary;
  public Complex(double reel, double imagenery){
    real=reel;
    imaginary=imagenery;
  }
  public double getReal(){
    return real;
  }
  public double getFake(){
    return imaginary;
  }
  public Complex add(Complex other){
    return new Complex(real+other.real,imaginary+other.imaginary);
  }
  public Complex multiply(Complex other){
    return new Complex(real*other.real-(imaginary*other.imaginary),real*other.imaginary+imaginary*other.real);
  }
}