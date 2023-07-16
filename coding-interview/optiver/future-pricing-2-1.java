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
    
    static class IdDividend {
        public int id;
        public long amount = 0;
        public long days = 0;
        public IdDividend(int id, Dividend dividend) {
            this.id = id;
            this.amount = dividend.amount;
            this.days = dividend.days;
        }
    }

    static class FuturePricingEngine {
        public long stockPrice;
        public List<Dividend> dividends;
        public TreeMap<Long, HashMap<Integer, IdDividend>> divs;
        
        public FuturePricingEngine(long stockPrice, List<Dividend> dividends)
        {
            this.stockPrice = stockPrice;
            this.dividends = dividends;
            this.divs = new TreeMap<>();
            
            for (int i = 0; i < dividends.size(); i++)  {
                Dividend dividend = dividends.get(i);
                this.divs.putIfAbsent(dividend.days, new HashMap<>());
                this.divs.get(dividend.days).put(i + 1, new IdDividend(i + 1, dividend));
            }
        }

        public void updateDividend(int dividendId, Dividend updatedDividend)
        {
            Dividend oldDividend = this.dividends.get(dividendId - 1);
            this.dividends.set(dividendId - 1, updatedDividend);
            
            this.divs.get(oldDividend.days).remove(dividendId);
            if (this.divs.get(oldDividend.days).size() == 0) {
                this.divs.remove(oldDividend.days);
            }
            this.divs.putIfAbsent(updatedDividend.days, new HashMap<>());
            this.divs.get(updatedDividend.days).put(dividendId, new IdDividend(dividendId, updatedDividend));
        }

        long calculateFuturePrice(long daysToFuture)
        {
            long decrease = 0;
            
            SortedMap<Long, HashMap<Integer, IdDividend>> sm = this.divs.headMap(daysToFuture + 1l);
            
            for (HashMap<Integer, IdDividend> hm : sm.values()) {
                for (IdDividend dividend : hm.values()) {
                    if (dividend.days <= daysToFuture) {
                        decrease += dividend.amount;
                    }
                }
            }
            
            // for (Dividend dividend : sm.) {
            //     if (dividend.days <= daysToFuture) {
            //         decrease += dividend.amount;
            //     }
            // }
            
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
