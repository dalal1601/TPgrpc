package org.xproce.stubs;

import io.grpc.stub.StreamObserver;
import org.xproce.stubs.Bank;
import org.xproce.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void convert(Bank.ConvertCurrencyRequest request,
                        StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();
        double conversionRate = 12.14; // Exemple de taux de conversion
        double result = amount * conversionRate;

        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
