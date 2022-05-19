package com.rest.ethereum.etherjava.contracts;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Tlc extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610198806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806327ea558b146100515780634bbfa6cb146100af5780636841a0b6146100e357806398660c6914610115575b600080fd5b61008c61005f366004610149565b6000908152600160208190526040909120015460ff80821692610100830482169262010000900490911690565b604080519315158452911515602084015215159082015260600160405180910390f35b6100e16100bd366004610149565b6000818152600160208190526040909120918255908101805460ff19169091179055565b005b6100e16100f1366004610149565b600081815260016020819052604090912091825501805461ff001916610100179055565b6100e1610123366004610149565b600081815260016020819052604090912091825501805462ff0000191662010000179055565b60006020828403121561015b57600080fd5b503591905056fea264697066735822122081bec2d05b9f86c8f892500a1d0fad78a8dc44bd1873b7f9ee9a7470e16c3ffb64736f6c634300080d0033";

    public static final String FUNC_ADD_ACKNOWLEDGEMENT = "add_acknowledgement";

    public static final String FUNC_ADD_REQUEST = "add_request";

    public static final String FUNC_ADD_RESPONSE = "add_response";

    public static final String FUNC_GETTRANSACTIONLIFECYCLE = "getTransactionLifeCycle";

    @Deprecated
    protected Tlc(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Tlc(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Tlc(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Tlc(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> add_acknowledgement(BigInteger _tlcId) {
        final Function function = new Function(
                FUNC_ADD_ACKNOWLEDGEMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_tlcId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> add_request(BigInteger _tlcId) {
        final Function function = new Function(
                FUNC_ADD_REQUEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_tlcId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> add_response(BigInteger _tlcId) {
        final Function function = new Function(
                FUNC_ADD_RESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_tlcId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<Boolean, Boolean, Boolean>> getTransactionLifeCycle(BigInteger tlcId) {
        final Function function = new Function(FUNC_GETTRANSACTIONLIFECYCLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(tlcId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple3<Boolean, Boolean, Boolean>>(function,
                new Callable<Tuple3<Boolean, Boolean, Boolean>>() {
                    @Override
                    public Tuple3<Boolean, Boolean, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, Boolean, Boolean>(
                                (Boolean) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static Tlc load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Tlc(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Tlc load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Tlc(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Tlc load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Tlc(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Tlc load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Tlc(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Tlc> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Tlc.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Tlc> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Tlc.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Tlc> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Tlc.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Tlc> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Tlc.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
