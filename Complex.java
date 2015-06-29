public class Complex {
    private double x=0.0;
    private double y=0.0;
    
    public Complex(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }
    public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double modul2(){
        return Math.sqrt(x*x+y*y);
    }
    public Complex dodaj(Complex z){
        Complex wynik = new Complex(x+z.x, y+z.y);
        return wynik;
    }
    public Complex kwadrat(){
        return new Complex(Math.pow(x,  2)-(Math.pow(y,2)), 2*x*y);
    }
}
