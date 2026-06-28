package com.dxc.model;

public class Boy implements IEmotionable,IMannerable {
    public void cry(){
        System.out.println("Boy cries");
    }
    public void laugh(){
        System.out.println("Boy laughs");
    }

    @Override
    public void wish() {

    }

    @Override
    public void depart() {

    }
}
