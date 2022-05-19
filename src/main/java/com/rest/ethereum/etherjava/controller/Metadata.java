package com.rest.ethereum.etherjava.controller;


import lombok.Data;

import java.math.BigInteger;
@Data
public class Metadata {

     boolean request=false;
     boolean response=false;
     boolean ack=false;
     BigInteger tlcId;

    public void clearState() {
        this.request=false;
        this.response=false;
        this.ack=false;
        this.tlcId= BigInteger.valueOf(0);
    }



}
