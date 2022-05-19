package com.rest.ethereum.etherjava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EtherjavaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EtherjavaApplication.class, args);

		/*System.out.println("Connecting to Ethereum ...");
		Web3j web3 = Web3j.build(new HttpService("http://localhost:8101"));
		System.out.println("Successfuly connected to Ethereum");

		try {
			// web3_clientVersion returns the current client version.
			Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

			// eth_blockNumber returns the number of most recent block.
			EthBlockNumber blockNumber = web3.ethBlockNumber().send();

			// eth_gasPrice, returns the current price per gas in wei.
			EthGasPrice gasPrice = web3.ethGasPrice().send();

			// Print result
			System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
			System.out.println("Block number: " + blockNumber.getBlockNumber());
			System.out.println("Gas price: " + gasPrice.getGasPrice());

			EthGetBalance balanceWei = web3.ethGetBalance("0x9295020B9e3Ba8870D96d62dC372adA0Ed3CA617", DefaultBlockParameterName.LATEST).send();
			//System.out.println("balance in wei: " + balanceWei.getBalance());

			BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
			System.out.println("balance in ether: " + balanceInEther);

		} catch (IOException ex) {
			throw new RuntimeException("Error whilst sending json-rpc requests", ex);
		}*/
	}


}
