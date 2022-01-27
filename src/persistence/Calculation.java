package persistence;

import model.Currency;

public class Calculation {
    
    public double exchange(double amount, String baseCurrency, String destCurrency){
        return obtainExchangeRate(baseCurrency, destCurrency) * amount;
    }
    
    
    public double obtainExchangeRate(String baseCurrency, String destCurrency){
        
        Currency currency1 = new Currency(baseCurrency);
        Currency currency2 = new Currency(destCurrency);
        
        if(!currency1.currencyInList() || !currency2.currencyInList()) return 0.0;

        String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + currency1.getCode().toLowerCase() + "/" + currency2.getCode().toLowerCase() + ".json";
        Converter conv = new Converter(url);
        return conv.getExchangeRate();
    }
}
