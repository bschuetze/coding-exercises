import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    enum BuySell {
        BUY,
        SELL
    }
    
    static class Trade {
        public long tradeId; 
        public String instrumentId; 
        public BuySell buySell; 
        public long price; 
        public long volume;
        
        public Trade(long tradeId, String instrumentId, BuySell buySell, long price, long volume) {
            this.tradeId = tradeId;
            this.instrumentId = instrumentId;
            this.buySell = buySell;
            this.price = price;
            this.volume = volume;
        }
        
        public long calculatePnL(long currentPrice) {
            return this.calculatePerLot(currentPrice) * this.volume;
        }
        
        public long calculatePerLot(long currentPrice) {
            if (this.buySell == BuySell.SELL) {
                return this.price  - currentPrice;
            } else if (this.buySell == BuySell.BUY) {
                return currentPrice - this.price;
            } else {
                // Shouldn't happen
                return 0;
            }
        }
    }

    static class PnlCalculator {
        public HashMap<String, Long> instrumentPrices = new HashMap<>();
        public HashMap<String, ArrayList<Trade>> trades = new HashMap<>();
        
        public void processTrade(long tradeId, String instrumentId, BuySell buySell, long price, long volume) {
            trades.putIfAbsent(instrumentId, new ArrayList<Trade>());
            trades.get(instrumentId).add(new Trade(tradeId, instrumentId, buySell, price, volume));
        }

        public void processPriceUpdate(String instrumentId, long price) {
            this.instrumentPrices.put(instrumentId, price);
        }

        // returns the output string to be printed
        String outputWorstTrade(String instrumentId)
        {
            long currentPrice = this.instrumentPrices.get(instrumentId);
            Long currentWorstTradeId = 0l;
            long currentWorstTradePnL = 0l;
            ArrayList<Trade> instrumentTrades = this.trades.get(instrumentId);
            
            if (instrumentTrades != null) {
                for (Trade trade : instrumentTrades) {
                    long pnl = trade.calculatePerLot(currentPrice);
                    
                    if (pnl <= currentWorstTradePnL) {
                        currentWorstTradePnL = pnl;
                        currentWorstTradeId = trade.tradeId;
                    }
                }
            }
            
            if (currentWorstTradePnL >= 0l) {
                return "NO BAD TRADES";
            } else {
                return currentWorstTradeId.toString();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PnlCalculator calculator = new PnlCalculator();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] query = scanner.nextLine().split(" ");
            String queryType = query[0];

            if (queryType.equals("TRADE")) {
                long tradeId = Long.parseLong(query[1]);
                String instrumentId = query[2];
                String buySell = query[3];
                long price = Long.parseLong(query[4]);
                long volume = Long.parseLong(query[5]);

                if (buySell.equals("BUY")) {
                    calculator.processTrade(tradeId, instrumentId, BuySell.BUY, price, volume);
                } else if (buySell.equals("SELL")) {
                    calculator.processTrade(tradeId, instrumentId, BuySell.SELL, price, volume);
                } else {
                    System.out.println("Malformed input!");
                    System.exit(-1);
                }
            } else if (queryType.equals("PRICE")) {
                String instrumentId = query[1];
                long price = Long.parseLong(query[2]);
                calculator.processPriceUpdate(instrumentId, price);
            } else if (queryType.equals("WORST_TRADE")) {
                String instrumentId = query[1];
                String output = calculator.outputWorstTrade(instrumentId);
                System.out.println(output);
            } else {
                System.out.println("Malformed input!");
                System.exit(-1);
            }
        }
    }
}