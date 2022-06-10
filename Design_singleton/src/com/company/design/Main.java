package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        // 싱글톤 메인

//        AClazz aclazz=new AClazz();
//        BClazz bclazz= new BClazz();
//
//
//        SocketClient aClient=aclazz.getSocketClient();
//        SocketClient bClient=bclazz.getSocketClient();
//
//        System.out.println(aClient.equals(bClient));

        // 어댑터 메인
//        HairDryer hairDryer =new HairDryer();
//        connect(hairDryer);
//
//        Cleaner cleaner = new Cleaner();
//        Electronic110V adapter = new SocketAdapter(cleaner);
//        connect(adapter);
//        AirConditioner airConditioner = new AirConditioner();
//        Electronic110V airAdapter = new SocketAdapter(airConditioner);
//        connect(airAdapter);

        // proxy 메인
//        Browser browser =new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();


//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());

                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now-start.get());

                });

        aopBrowser.show();
        System.out.println("loading time : "+ end.get());
        aopBrowser.show();
        System.out.println("loading time : "+ end.get());

    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}