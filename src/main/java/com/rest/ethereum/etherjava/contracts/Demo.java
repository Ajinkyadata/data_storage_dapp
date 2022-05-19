package com.rest.ethereum.etherjava.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
public class Demo extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610701806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806321bbba5d1461003b578063412b3cfc14610066575b600080fd5b61004e610049366004610476565b61007b565b60405161005d939291906104dc565b60405180910390f35b6100796100743660046105c2565b610306565b005b606080606060005b6000548110156102b65760008082815481106100a1576100a1610654565b9060005260206000209060040201604051806080016040529081600082015481526020016001820180546100d49061066a565b80601f01602080910402602001604051908101604052809291908181526020018280546101009061066a565b801561014d5780601f106101225761010080835404028352916020019161014d565b820191906000526020600020905b81548152906001019060200180831161013057829003601f168201915b505050505081526020016002820180546101669061066a565b80601f01602080910402602001604051908101604052809291908181526020018280546101929061066a565b80156101df5780601f106101b4576101008083540402835291602001916101df565b820191906000526020600020905b8154815290600101906020018083116101c257829003601f168201915b505050505081526020016003820180546101f89061066a565b80601f01602080910402602001604051908101604052809291908181526020018280546102249061066a565b80156102715780601f1061024657610100808354040283529160200191610271565b820191906000526020600020905b81548152906001019060200180831161025457829003601f168201915b5050505050815250509050858160000151036102a35780602001518160400151826060015194509450945050506102ff565b50806102ae816106a4565b915050610083565b5050604080518082018252600980825268139bdd08119bdd5b9960ba1b602080840182905284518086018652838152808201839052855180870190965292855284015290935091505b9193909250565b604080516080810182528581526020808201868152928201859052606082018490526000805460018101825590805282517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56360049092029182019081559351805193948594909361039b937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564019201906103dd565b50604082015180516103b79160028401916020909101906103dd565b50606082015180516103d39160038401916020909101906103dd565b5050505050505050565b8280546103e99061066a565b90600052602060002090601f01602090048101928261040b5760008555610451565b82601f1061042457805160ff1916838001178555610451565b82800160010185558215610451579182015b82811115610451578251825591602001919060010190610436565b5061045d929150610461565b5090565b5b8082111561045d5760008155600101610462565b60006020828403121561048857600080fd5b5035919050565b6000815180845260005b818110156104b557602081850181015186830182015201610499565b818111156104c7576000602083870101525b50601f01601f19169290920160200192915050565b6060815260006104ef606083018661048f565b8281036020840152610501818661048f565b90508281036040840152610515818561048f565b9695505050505050565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261054657600080fd5b813567ffffffffffffffff808211156105615761056161051f565b604051601f8301601f19908116603f011681019082821181831017156105895761058961051f565b816040528381528660208588010111156105a257600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080608085870312156105d857600080fd5b84359350602085013567ffffffffffffffff808211156105f757600080fd5b61060388838901610535565b9450604087013591508082111561061957600080fd5b61062588838901610535565b9350606087013591508082111561063b57600080fd5b5061064887828801610535565b91505092959194509250565b634e487b7160e01b600052603260045260246000fd5b600181811c9082168061067e57607f821691505b60208210810361069e57634e487b7160e01b600052602260045260246000fd5b50919050565b6000600182016106c457634e487b7160e01b600052601160045260246000fd5b506001019056fea26469706673582212203fbe580cf746b4d4a70525d9ce3442688138df8785dc885195219dcfe6bc7b9564736f6c634300080d0033";

    public static final String FUNC_ADDEMPLOYEE = "addEmployee";

    public static final String FUNC_GETEMPLOYEE = "getEmployee";

    @Deprecated
    protected Demo(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Demo(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Demo(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Demo(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addEmployee(BigInteger empid, String name, String department, String designation) {
        final Function function = new Function(
                FUNC_ADDEMPLOYEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(empid), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(department), 
                new org.web3j.abi.datatypes.Utf8String(designation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<String, String, String>> getEmployee(BigInteger empid) {
        final Function function = new Function(FUNC_GETEMPLOYEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(empid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, String>>(function,
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static Demo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Demo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Demo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Demo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Demo load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Demo(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Demo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Demo(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Demo> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Demo.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Demo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Demo.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Demo> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Demo.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Demo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Demo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
