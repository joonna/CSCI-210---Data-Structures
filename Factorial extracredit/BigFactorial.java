import java.math.BigDecimal;

import java.util.HashMap;

import java.util.LinkedList;

import java.util.List;

import java.util.Map;

public class BigFactorial{

public static void bigFactorial(int limit) {

   System.out.println(factorial(limit) + "\n");

   // Step 1: Build the list of factorial members.

   List<Integer> list = new LinkedList<Integer>();

   for(int i = limit; i > 0; i--) {

       list.add(i);

   }

   // Step 2: Calculate and group into a Map<Integer, Integer> Prime Factors of factorial members.

   Map<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();

   for(int n : list) {

       for(int prime : primeFactors(n)) {

           if(primeFactors.containsKey(prime)) {

               primeFactors.put(prime, primeFactors.get(prime)+1);

           } else {

               primeFactors.put(prime, 1);

           }

       }

   }

   // Step 3: Distribute Prime Factors over powers of 10, largest first.

   List<LinkedList<Integer>> disPrimes = new LinkedList<LinkedList<Integer>>();

   for(int prime : primeFactors.keySet()) {

       LinkedList<Integer> dis = new LinkedList<Integer>();

       int n = (int) Math.pow(prime, primeFactors.get(prime));

       while(n > 0) {

           dis.addFirst(n % 10);

           n /= 10;

       }

       disPrimes.add(dis);

   }

   //System.out.println(disPrimes);

   // Step 4: Multiply Prime Factors, carrying overflow to next index in solution.  

   LinkedList<Integer> solution = disPrimes.get(0);

  

   // For all Prime Factors except the first...

   for(int i = 1; i <= disPrimes.size()-1; i++) {

       // Parse digits back into integer values (solve).

       LinkedList<Integer> l = disPrimes.get(i);

       String str = "";

       for(int j = 0; j < l.size(); j++) {

           str+=l.get(j);

       }

      

       int pf = Integer.parseInt(str);

      

       // Multiply each digit in first Prime Factor list by the next Prime Factor.

       for(int j = 0; j < disPrimes.get(0).size(); j++) {

           solution.set(j, solution.get(j) * pf);

       }

       //System.out.println(solution);

       // Carry the overflow to the next multiple of ten.

       for(int j = solution.size()-1; j >= 0; j--) {

           int top = solution.get(j);

           int last = top % 10;

           top /= 10;

           if(top > 0) {

               if(j-1 >= 0) {

                   solution.set(j-1, solution.get(j-1) + top);

                   solution.set(j, last);

               } else {

                   solution.addFirst(top);

                   solution.set(1, last);

                   j++;

               }

           }

           //System.out.println(solution);

       }

   }

  

   System.out.println(solution);

  

   // Step 5: Print Solution (adding commas).

   for(int i = 0; i < solution.size(); i++) {

       if((solution.size() - i) % 3 == 0) {

           System.out.print(",");

       }

       System.out.print(solution.get(i));

   }

}

/**

* Calculates the prime factors for n.

* @param n - the number to be factorised.

* @return a List<Integer> of the found prime factors.

*/

public static List<Integer> primeFactors(int n) {

   List<Integer> factors = new LinkedList<Integer>();

   int d = 2;

   while (n > 1) {

       while (n % d == 0) {

           factors.add(d);

           n /= d;

       }

       d = d + 1;

   }

   return factors;

}

/**

* Calculates the factorial of a number.

* @param limit - the number to factorial.

* @return a BigDecimal containing the result.

*/

public static BigDecimal factorial(int limit) {

   // Stage 1: Build the list.

   List<Integer> list = new LinkedList<Integer>();

   for(int i = 1; i <= limit; i++) {

       list.add(i);

   }

   System.out.println(list);

   //Stage 2: Calculate the factorial.

   BigDecimal factorial = new BigDecimal(1);

   BigDecimal factor = null;

   for(int n : list) {

       factor = new BigDecimal(n);

       factorial = factorial.multiply(factor);

   }

   return factorial;

}

}