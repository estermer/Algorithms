/*
 * @Author - Nitish
 * @Description - Pretty format Integer
 */

import java.util.Formatter;

public class PrettyFormat {
  
  static String getUnit(int count) {
    switch(count) {
      case 0: return "B";
      case 1: return "K";
      case 2: return "M";
      case 3: return "G";
    }
    return "";
  }

  /*
   * @Description - Function takes integer as input and returns the number in
   * pretty format(Gigabyte, Megabytes, KiloBytes, Bytes) with maximum of 3
   * digits
   * @param integer to convert to pretty format
   * @Assumptions - As mentioned in the problem set, 1000bytes = 1KB
   * Value is rounded to the nearest valid value
   * In java leading 0 in number is considered Octal, this function does not 
   * take care of octal to decimal conversion
   * Time complexity is O(3) in worst case considering the max value 1G
   * As 1G = 1,000,000,000B the loop will run maximum 3 times in worst case 
   * Its requires constant space O(1) to store the result
   */
  static String fpretty(int num) {
    
    int count = 0;
    double div_result = (double) num;
    String display = "";
    
    /*
     * Every time we divide by 1000 count is incremented from B->K->M->G
     * Here two decimal places are preserved for cases like 1.05, 1.11
     * The output result of this loop will have 1,2 or 3 digits with max
     * two decimal places
     */
    while(div_result > 999.5) {
      div_result = div_result / 1000;
      div_result = Math.round(div_result * 100.0) / 100.0;
      count++;
    }

    // Get suffix B, K, M or G
    String measure = getUnit(count);

    // If decimal places is all zeros OR result has 3 digits
    if(div_result % 1 == 0 || div_result >= 100)
      display = (int)div_result + measure;
    // If result has 2 digits
    else if (div_result >= 10) {
      // Then fetch 1 decimal place as we have 2 digits
      div_result = (Math.round(div_result * 10.0) / 10.0);
      // If after rounding decimal places are .0 then truncate zeros 
      // eg. 99.97 rounded to -> 100.0 -> 100
      if(div_result % 1 == 0)
        display = (int)div_result + measure;
      else
        display = div_result + measure;
    }
    else
      display = div_result + measure;

    return display;
  }

  /*
   * @Description - fprint function formats the output to be printed on stdout
   */
  static void fprint(int num, String prettyStr) {
  
    System.out.println(String.format("%-11s : %2s", num, prettyStr));
  }

  /*
   * @Description - Usage Guidelines 
   */
  static void usage() {
    
    System.out.println("Usage: java PrettyFormat [OPTION]");
    System.out.println("  OPTION");
    System.out.println("    1  Execute default test case");
    System.out.println("    2  MIN_VAUE<int> MAX_VALUE<int>, Execute testcase including numbers from MIN to MAX, +ve ints only");
    System.out.println("  Examples");
    System.out.println("    java PrettyFormat 1          :  Executes default test case");
    System.out.println("    java PrettyFormat 2 100 200  :  Executes custom test case, using numbers from 100 to 200");
  }

  static void setHeader() {
  
    System.out.println(String.format("%-11s : %2s", "Orig no", "Formatted"));
    System.out.println("-----------------------");
  }

  static void defaultTestCase() {
    
    setHeader();
    int[] testcases = {5910000, 1076, 99939999 ,9999, 123456, 123999, 1234, 1000, 1200, 100, 54123, 1000000000, 100000000, 999999999, 99999999, 999000, 9900, 99100, 99930000, 99969999, 99939999, 999399999, 999499999, 999599999, 999511111, 999699999, 9969999, 99969999};

    /*int[] testcases = {};*/
    for(int num: testcases) {
      fprint(num, fpretty(num));
    }
  }

  static void customTestCase(int MIN_VAL, int MAX_VAL) {
  
    setHeader();
    for(int i = MIN_VAL; i <= MAX_VAL; i++) {
      fprint(i, fpretty(i));
    } 
  }

  public static void main(String[] args) {

    try {
      int arguments = args.length;

      if(arguments == 0) {
        usage();
        return;
      }

      int param = Integer.parseInt(args[0]);

      switch(param) {
        case 1:
          defaultTestCase(); 
          break;
        case 2: 
          int min = Integer.parseInt(args[1]);
          int max = Integer.parseInt(args[2]);
          if(min < 0 || max < 0) {
            throw new NumberFormatException();
          }
          customTestCase(min, max); 
          break;
        default: usage(); break;
      }
    }
    catch(NumberFormatException nfe) {
      System.out.println("Parameters seem to be incorrect, check usage example\n");
      usage();
    }
    catch(Exception e) {
      usage();
    }
  }
}
