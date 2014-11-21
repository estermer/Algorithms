public class Power {

  public double xPowY(double base, int exp) {
    boolean isNeg = false;
    if(exp < 0) {
      isNeg = true;
      exp = -exp;
    }

    double xy = pow(base, exp, new double[exp + 1]);
    if(isNeg)
      xy = 1 / xy;
    return xy;
  }

  public double pow(double base, int exp, double[] powers) {
    if(exp == 0)
      return 1;
    if(exp == 1)
      return base;
    if(powers[exp] != 0)
      return powers[exp];
    else 
      return powers[exp] = base * pow(base, exp - 1, powers);
  }

  public static void main(String[] args) {
    Power p = new Power();
    double x = Double.parseDouble(args[0]);
    int y = Integer.parseInt(args[1]);
    System.out.println(p.xPowY(x, y));
  }
}
