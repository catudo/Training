/*
 * Problem Description:
 *
 * As a user of an investment platform, you manage a portfolio of funds (e.g., GOOG, AAPL, FB, etc).
 * Each portfolio has:
 *   - A total balance in dollars.
 *   - A set of funds, each with a current percentage allocation.
 *
 * When the user wants to rebalance their portfolio to a new target allocation:
 *   - You must compute the buy/sell orders needed to match the new allocation.
 *   - The target allocation is also provided in percentages (e.g., GOOG = 50%, AAPL = 50%).
 *
 * Requirements:
 * 1. Compute the list of buy/sell `Order`s needed to rebalance the portfolio.
 * 2. You must sell funds before buying others, since cash is required to buy new funds.
 * 3. If the target allocation percentages do not add up to 100%, throw an Exception.
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents an investment portfolio.
 * Contains a total dollar balance and a list of fund allocations (as percentages).
 */
class Portfolio {
  List<FundAllocation> fundAllocations;
  Double balance;

  public List<FundAllocation> getFundAllocations() {
    return fundAllocations;
  }

  public Double getBalance() {
    return balance;
  }

  Portfolio(List<FundAllocation> fundAllocations, Double balance) {
    this.fundAllocations = fundAllocations;
    this.balance = balance;
  }
}

/**
 * Represents a single fund allocation.
 * - fund: the name of the fund (e.g., "AAPL")
 * - percent: percentage of the total balance allocated to this fund
 */
class FundAllocation {
  String fund;
  Double percent;

  public String getFund() {
    return fund;
  }

  public Double getPercent() {
    return percent;
  }

  FundAllocation(String fund, Double percent) {
    this.fund = fund;
    this.percent = percent;
  }

}

/**
 * Represents a transaction order for rebalancing.
 * - orderType: "BUY" or "SELL"
 * - fund: name of the fund
 * - amount: amount in dollars to buy or sell
 */
class Order {
  String orderType; // Can be BUY or SELL
  String fund;
  Double amount;

  public String getOrderType() {
    return orderType;
  }

  public String getFund() {
    return fund;
  }

  public Double getAmount() {
    return amount;
  }

  public Order(String orderType, String fund, Double amount) {
    this.orderType = orderType;
    this.amount = amount;
    this.fund = fund;
  }
  @Override public String toString() {
    return this.orderType + "(" + this.fund + ", " + this.amount + ")";
  }

}

public class InvesmentPlattform {

  public static String BUY = "BUY";
  public static String SELL = "SELL";

  public static void main(String[] args) throws Exception {
    FundAllocation porfolioFund1 = new FundAllocation("GOOG", 40.0);
    FundAllocation porfolioFund2 = new FundAllocation("APPL", 60.0);
    List<FundAllocation> portfolioFundAllocations = List.of(porfolioFund1, porfolioFund2);
    Portfolio portfolio = new Portfolio(portfolioFundAllocations, 200.0);

    // Test Case 1
    List<FundAllocation> targetAllocation1 = List.of(new FundAllocation("GOOG", 100.0));
    // Output - [SELL: (AAPL, 120.0), BUY (GOOG, 120.0)]
    System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation1));

    // Test Case 2
    List<FundAllocation> targetAllocation2 = List.of(new FundAllocation("FB", 100.0));
    // Output - [SELL: (GOOG, 80.0), SELL (AAPL, 120.0), BUY (FB, 200.00)]
    System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation2));

    // Test Case 3
    List<FundAllocation> targetAllocation3 = List.of(new FundAllocation("GOOG", 50.0), new FundAllocation("AAPL", 10.0), new FundAllocation("FB", 40.0));
    // Output - [SELL: (AAPL, 10.0), BUY(GOOG, 20.0), BUY(FB, 80.00)]
    System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation3));

    // Test Case 4
    List<FundAllocation> targetAllocation4 = List.of(new FundAllocation("GOOG", 60.0), new FundAllocation("AAPL", 25.0), new FundAllocation("FB", 25.0));
    // Throws exception
    System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation4));

  }

  /**
   * Computes the list of buy and sell orders needed to rebalance a portfolio
   * to match a given target allocation.
   */
  private static Collection<Order> getOrdersNeededToRebalancePortfolio(Portfolio portfolio, List<FundAllocation> targetAllocation) throws Exception {
    // Validate that target allocation sums to 100%
    double targetSum = targetAllocation.stream().mapToDouble(FundAllocation::getPercent).sum();
    if (Math.abs(targetSum - 100.0) > 1e-6) {
      throw new Exception("Target allocation percentages do not sum to 100%");
    }

    Map<String, Double> currentAllocations = new HashMap<>();
    for (FundAllocation fa : portfolio.getFundAllocations()) {
      currentAllocations.put(fa.getFund(), fa.getPercent() * portfolio.getBalance() / 100.0);
    }

    Map<String, Double> targetAllocations = new HashMap<>();
    for (FundAllocation fa : targetAllocation) {
      targetAllocations.put(fa.getFund(), fa.getPercent() * portfolio.getBalance() / 100.0);
    }

    List<Order> orders = new ArrayList<>();

    // Process current funds
    for (Map.Entry<String, Double> entry : currentAllocations.entrySet()) {
      String fund = entry.getKey();
      double currentAmount = entry.getValue();
      double targetAmount = targetAllocations.getOrDefault(fund, 0.0);

      if (currentAmount > targetAmount) {
        orders.add(new Order("SELL", fund, currentAmount - targetAmount));
      } else if (currentAmount < targetAmount) {
        orders.add(new Order("BUY", fund, targetAmount - currentAmount));
      }
    }

    // Process new funds in target allocation
    for (Map.Entry<String, Double> entry : targetAllocations.entrySet()) {
      String fund = entry.getKey();
      if (!currentAllocations.containsKey(fund)) {
        orders.add(new Order("BUY", fund, entry.getValue()));
      }
    }

    return orders;
  }





}
