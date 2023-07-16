import java.util.*;
import java.lang.*;

public class Main {

    static class Dividend {
        public long amount = 0;
        public long days = 0;
        public Dividend(long amount, long days) {
            this.amount = amount;
            this.days = days;
        }
    }

    static class FuturePricingEngine {
        public long stockPrice;
        
        public long[] divDays;
        public long[] divAmounts;
        
        public FuturePricingEngine(long stockPrice, List<Dividend> dividends)
        {
            this.stockPrice = stockPrice;
            
            this.divDays = new long[dividends.size()];
            this.divAmounts = new long[dividends.size()];
            
            for (int i = 0; i < dividends.size(); i++) {
                this.divDays[i] = dividends.get(i).days;
                this.divAmounts[i] = dividends.get(i).amount;
            }
        }

        public void updateDividend(int dividendId, Dividend updatedDividend)
        {
            this.divDays[dividendId - 1] = updatedDividend.days;
            this.divAmounts[dividendId - 1] = updatedDividend.amount;
        }

        long calculateFuturePrice(long daysToFuture)
        {
            long decrease = 0;
            
            for (int i = 0; i < this.divDays.length; i++) {
                if (this.divDays[i] <= daysToFuture) {
                    decrease += this.divAmounts[i];
                }
            }

            return this.stockPrice - decrease;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int S = scanner.nextInt();
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        List<Dividend> dividends = new ArrayList<Dividend>(N);
        for (int i = 0; i < N; i++) {
            dividends.add(new Dividend(scanner.nextInt(), scanner.nextInt()));
        }
        scanner.nextLine();

        FuturePricingEngine engine = new FuturePricingEngine(S, dividends);
        for (int q = 0; q < Q; q++) {
            String[] query = scanner.nextLine().split(" ");
            String queryType = query[0];

            if (queryType.equals("DIVIDEND_UPDATE")) {
                int dividendId = Integer.parseInt(query[1]);
                Dividend updatedDividend = new Dividend(Long.parseLong(query[2]), Long.parseLong(query[3]));
                engine.updateDividend(dividendId, updatedDividend);
            } else if (queryType.equals("PRICE")) {
                long daysToFuture = Long.parseLong(query[1]);
                long futurePrice = engine.calculateFuturePrice(daysToFuture);
                System.out.println(futurePrice);
            } else {
                System.out.println("Malformed input!");
                System.exit(-1);
            }
        }
    }
}
