package network.platon.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.9.1.0-SNAPSHOT.
 */
public class InterfaceContractParentTest extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060b88061001f6000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c8063e288b0b514602d575b600080fd5b606060048036036040811015604157600080fd5b8101908080359060200190929190803590602001909291905050506076565b6040518082815260200191505060405180910390f35b600081830190509291505056fea265627a7a723158200ae96e79ef1731f3b80843f451945977fa4a124181c5303a4233096cb407c9db64736f6c634300050d0032";

    public static final String FUNC_SUMEXTERNAL = "sumExternal";

    @Deprecated
    protected InterfaceContractParentTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected InterfaceContractParentTest(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected InterfaceContractParentTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected InterfaceContractParentTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> sumExternal(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SUMEXTERNAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<InterfaceContractParentTest> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(InterfaceContractParentTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<InterfaceContractParentTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(InterfaceContractParentTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<InterfaceContractParentTest> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(InterfaceContractParentTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<InterfaceContractParentTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(InterfaceContractParentTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static InterfaceContractParentTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new InterfaceContractParentTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static InterfaceContractParentTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new InterfaceContractParentTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static InterfaceContractParentTest load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new InterfaceContractParentTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static InterfaceContractParentTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new InterfaceContractParentTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}