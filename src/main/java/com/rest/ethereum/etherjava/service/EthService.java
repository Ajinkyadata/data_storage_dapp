package com.rest.ethereum.etherjava.service;

import com.rest.ethereum.etherjava.contracts.Demo;
import com.rest.ethereum.etherjava.contracts.Owner;
import com.rest.ethereum.etherjava.contracts.Tlc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Slf4j
@Component
public class EthService {

	private final static BigInteger GAS_LIMIT =  BigInteger.valueOf(3000000L);
	private final static BigInteger GAS_PRICE =  BigInteger.valueOf(1000000000L);
	private final static String PRIVATE_KEY = "afa14f27c5cf649676464b04e7d136da39f7ea5dab6dd5f1a0da1b851928a20f";
	private final static String PRIVATE_KEY2 = "049116f06163b24714550dfa3188edd6ab86114714db2d782b194d9c27d70ef0";
	private final static String PRIVATE_KEY3 = "745e74bcdec9fdfe1a9c840b6045f20125fe0bd2136772c45a491b60de67a748";
	private final static String CONTRACT_KEY = "0xbf2be59d91a39696b34efac27dcda7ae24bc0c3b";
	private final static String CONTRACT_KEY2 = "0xadb60544ee026f3d82b64fdd03050780825c8cdf";

	private final static String CONTRACT_KEY_TLC = "0x763c91bb6d910ceb3cc4df867073319a009ff79f";
	private final static String ACCOUNT1 = "0x7FAF000596eFAA2c9B3A28E05349Fe8BEef47B93";
	private final static String ACCOUNT = "0xA04B74DD2BC67cB8dF000A77fb813801f8A74810";
	private final static String CONTRACT_KEY_TLC2="0x235c02199ef305b935a3823445c6e4befc55c69f";
	private final static String CONTRACT_KEY_TLC3="0x344c103b4b5862f7f39837d581c309230a78a3b8";
	private final static String CONTRACT_KEY_EXT_DEPL="0x3c36A32237bcd3CF5F2B6669765ebD164E188cC5";
	Web3j web3;
	Web3ClientVersion clientVersion;
	TransactionManager transactionManager;
	ContractGasProvider contractGasProvider;
	Owner owner;
	Tlc tlc;
	//Demo demo;

	EthService() throws Exception {

		web3 = Web3j.build(new HttpService("HTTP://127.0.0.1:8101"));
		System.out.println("Connecting to Ethereum ...");
		clientVersion = web3.web3ClientVersion().send();
		System.out.println("Successfully connected to Ethereum");
		transactionManager = new RawTransactionManager(
				web3,
				getCredFromPrivateKey(PRIVATE_KEY)
				,66556655
		);
		contractGasProvider = new StaticGasProvider(GAS_PRICE,GAS_LIMIT);
		owner = loadContract(CONTRACT_KEY, web3);
		tlc = loadContractForTlc(CONTRACT_KEY_EXT_DEPL,web3);
		//String iitlc = deployContract(ACCOUNT);
		//demo = loadContractForDemo(CONTRACT_KEY_TLC3,web3);
		//System.out.println("loaded Owner SmartContract with address: " + owner.getContractAddress());
		System.out.println("loaded Tlc SmartContract with address: " + tlc.getContractAddress());
		//System.out.println("loaded demo SmartContract with address: " + demo.getContractAddress());

	}

	public void addEmp() throws Exception {
		//demo.addEmployee(new BigInteger("11"),"hello","Aero","AM").send();
		log.info("success");
	}

	public String addRequest(BigInteger tlcId ) {
		try {
			tlc.add_request(tlcId).send();
			return "Done";
		} catch (Exception e) {
			log.error("error in adding request",e);
		}

		return null;
	}

	public String addResponse(BigInteger tlcId) {
		try {
			tlc.add_response(tlcId).send();
			return "Done";
		} catch (Exception e){
			log.error("error in adding response",e);
		}
		return null;
	}

	public String addAcknowledgement(BigInteger tlcId) {
		try {
			tlc.add_acknowledgement(tlcId).send();
			return "Done";
		} catch (Exception e){
			log.error("error in adding ack",e);
		}
		return null;
	}

	public Tuple3<Boolean, Boolean, Boolean> getTLCStatus(BigInteger tlcId) throws Exception {
		Tuple3<Boolean, Boolean, Boolean> data = tlc.getTransactionLifeCycle(tlcId).send();
		return data;
	}


	/*public static List<Trace> getCallAction(String hash) throws Exception {
		Request<?, ParityTracesResponse> request = parity.traceTransaction(hash);
		ParityTracesResponse response = request.send();
		return response.getTraces();
	}*/
	public String transact(String from, String to) throws Exception {
		Transfer transfer = new Transfer(web3,transactionManager);

		TransactionReceipt transactionReceipt = transfer.sendFunds(
				to,
				BigDecimal.ONE,
				Convert.Unit.ETHER,
				GAS_PRICE,
				GAS_LIMIT
		).send();

		EthGetBalance balanceWeiFrom = web3.ethGetBalance(from, DefaultBlockParameterName.LATEST).send();
		BigDecimal balanceInEther = Convert.fromWei(balanceWeiFrom.getBalance().toString(), Convert.Unit.ETHER);
		System.out.println("From "+from+" balance in ether: " + balanceInEther);
		EthGetBalance balanceWeiTo = web3.ethGetBalance(to, DefaultBlockParameterName.LATEST).send();
		balanceInEther = Convert.fromWei(balanceWeiTo.getBalance().toString(), Convert.Unit.ETHER);
		System.out.println("To "+to+" balance in ether: " + balanceInEther);

		return transactionReceipt.getTransactionHash();
	}

	public String execute(String address){

		try {
			// eth_blockNumber returns the number of most recent block.
			EthBlockNumber blockNumber = web3.ethBlockNumber().send();

			// eth_gasPrice, returns the current price per gas in wei.
			EthGasPrice gasPrice = web3.ethGasPrice().send();

			// Print result
			System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
			System.out.println("Block number: " + blockNumber.getBlockNumber());
			System.out.println("Gas price: " + gasPrice.getGasPrice());

			EthGetBalance balanceWei = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
			//System.out.println("balance in wei: " + balanceWei.getBalance());

			BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
			System.out.println("balance in ether: " + balanceInEther);

		//one account tries to interract with smart contract on network

		// storage contract

		// store 5

		return 	balanceInEther.toString();

		} catch (IOException ex) {
			throw new RuntimeException("Error whilst sending json-rpc requests", ex);
		}
	}

	/*public String changeOwner(String address) {

		YourSmartContract contract = YourSmartContract.load(
				"0x<address>|<ensName>", <web3j>, <credentials>, GAS_PRICE, GAS_LIMIT);

	}*/

	private Credentials getCredFromWalllet() throws CipherException, IOException {
		return WalletUtils.loadCredentials(
				"passphrase",
				"wallet/path"
		);
	}

	private Credentials getCredFromPrivateKey(String privateKey) {
		log.info("getting creds!!");
		return Credentials.create(privateKey);
	}

	public String deployContract(String from) throws Exception {
		EthGetBalance balanceWei = web3.ethGetBalance(from, DefaultBlockParameterName.LATEST).send();

		String contractAddress = Owner.deploy(
				web3,
				transactionManager,
				contractGasProvider
				).send().getContractAddress();

		Transfer transfer = new Transfer(web3,transactionManager);

		TransactionReceipt transactionReceipt = transfer.sendFunds(
				from,
				BigDecimal.ONE,
				Convert.Unit.ETHER,
				GAS_PRICE,
				GAS_LIMIT
		).send();

		EthGetBalance balanceWeiFrom = web3.ethGetBalance(from, DefaultBlockParameterName.LATEST).send();
		BigDecimal balanceInEther = Convert.fromWei(balanceWeiFrom.getBalance().toString(), Convert.Unit.ETHER);
		System.out.println("balance in ether: " + balanceInEther);
		return contractAddress;
	}

	public String whoIsOwner() throws Exception {
		System.out.println("the owner is :"+owner.getOwner().send());
		return owner.getOwner().send();
	}

	public String changeOwner(String newOwner, String privateKey) throws Exception {

		transactionManager = new RawTransactionManager(
				web3,
				getCredFromPrivateKey(privateKey)
				,66556655
		);
		owner = loadContract(CONTRACT_KEY, web3);
		System.out.println("changing the owner from :"+owner.getOwner().send().toString()+"to :"+newOwner);
		owner.changeOwner(newOwner).send();
		return owner.getOwner().send().toString();
	}

	private Owner loadContract(String address, Web3j web3) {
		log.info("loading Owner contract!!");
		return Owner.load(address, web3, transactionManager, contractGasProvider);
	}

	private Tlc loadContractForTlc(String address, Web3j web3) {
		log.info("loading TLC contract!!");
		return Tlc.load(address, web3, transactionManager, contractGasProvider);
	}

	private Demo loadContractForDemo(String address, Web3j web3) {
		log.info("loading TLC contract!!");
		return Demo.load(address, web3, transactionManager, contractGasProvider);
	}

}
