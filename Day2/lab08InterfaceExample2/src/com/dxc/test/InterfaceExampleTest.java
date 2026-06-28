package com.dxc.test;

import com.dxc.model.Boy;
import com.dxc.model.IEmotionable;
import com.dxc.model.IMannerable;
import com.dxc.model.Man;

public class InterfaceExampleTest {
    public static void main(String args[])
    {
        Man x= new Man();
        Boy y= new Boy();
        atThePartyHall(x);
       // atTheCinemaHall(x);
        atThePartyHall(y);
        atTheCinemaHall(y);


    }
    public static void atThePartyHall(IMannerable x){
        System.out.println("At the Party Hall ");
        x.wish();
        x.depart();
    }
    public static void atTheCinemaHall(IEmotionable x){
        System.out.println("At the Cinema Hall ");
        x.cry();
        x.laugh();
    }
}
