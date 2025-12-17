public class FizzBuzz {
  void main() {
        long startTime = System.nanoTime();
        System.out.println("System Started "+startTime);

//        fizzBuzzIteration(20_000_000);
        fizzBuzzDivision(20_000_000);

        long duration = System.nanoTime() - startTime;
        System.out.println("System Ended "+duration+" ns");
        System.out.println("System Ended "+duration/1_000_000+" ms");
//        SpringApplication.run(ConfigApplication.class);
    }

    private void fizzBuzzIteration(int count) {
        System.out.println("Fizz Buzz Iteration");
        StringBuilder sb = new StringBuilder();
        byte tiga = 0;
        byte lima = 0;
        for (int i = 1; i < count; i++) {
            tiga++;
            lima++;
            if (tiga == 3 && lima == 5) {
                sb.append("FizzBuzz dari angka ").append(i).append("\n");
                tiga = 0;
                lima = 0;
            } else if (tiga == 3) {
                sb.append("Fizz dari angka ").append(i).append("\n");
                tiga = 0;
            } else if (lima == 5) {
                sb.append("Buzz dari angka ").append(i).append("\n");
                lima = 0;
            } else {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private void fizzBuzzDivision(int count) {
        System.out.println("Fizz Buzz Division");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < count; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sb.append("FizzBuzz dari angka ").append(i).append("\n");
            } else if (i % 3 == 0) {
                sb.append("Fizz dari angka ").append(i).append("\n");
            } else if (i % 5 == 0) {
                sb.append("Buzz dari angka ").append(i).append("\n");
            } else {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
