package com.rest.ethereum.etherjava.controller;

import com.rest.ethereum.etherjava.service.EthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;

@RestController
public class ApiControllerForEth {


    @Autowired
    EthService ethService;

    @PostMapping("/request")
    String inRequest (@RequestParam BigInteger tlcId) throws Exception {
        ethService.addRequest(tlcId);
        return "request";

    }

    @PostMapping("/response")
    String inResponse (@RequestParam BigInteger tlcId) {
        String response = ethService.addResponse(tlcId);
        return response;
    }

    @PostMapping("/ack")
    String inAck(@RequestParam BigInteger tlcId) {
        String response = ethService.addAcknowledgement(tlcId);
        return response;
    }

    @GetMapping("/status")
    Metadata getStatus(@RequestParam BigInteger tlcId) throws Exception {
        Tuple3<Boolean, Boolean, Boolean> response = ethService.getTLCStatus(tlcId);
        Metadata metadata = new Metadata();
        metadata.setTlcId(tlcId);
        metadata.setRequest(response.component1());
        metadata.setResponse(response.component2());
        metadata.setAck(response.component3());
        return metadata;
    }

    @PostMapping("/transact")
    String transact (@RequestParam String address,@RequestParam int amount) {
        return ethService.execute(address);
    }

    @PostMapping("/transact/smartContract")
    String transactWithSmartContract (@RequestParam String address,@RequestParam int amount) {
        return ethService.execute(address);
    }

    @PostMapping("/send")
    String transactWithSmartContract (@RequestParam String from,@RequestParam String to) throws Exception {
        return ethService.transact(from,to);
    }

    @PostMapping("/deployContract")
    String deplyContract (@RequestParam String from) throws Exception {
        return ethService.deployContract(from);
    }

    @GetMapping("/getOwner")
    String getOwner () throws Exception {
        return ethService.whoIsOwner();
    }

    @PostMapping("/changeOwner")
    String changeOwner (@RequestParam String newOwner,@RequestParam String privateKey) throws Exception {
        return ethService.changeOwner(newOwner,privateKey);
    }

    /*@GetMapping("/call")
    String call () {

    }*/


}
