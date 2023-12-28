package com.vdp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//开启EurekaServer
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        boolean setProfile = false;

        for (String arg : args) {
            if (arg.contains("--spring.profiles.active"))
                setProfile = true;
        }
        String[] newArgs = new String[args.length];

        if (!setProfile) {
            newArgs = new String[args.length + 1];
            newArgs[args.length] = "--spring.profiles.active=peer1";
        }
        System.arraycopy(args, 0, newArgs, 0, args.length);
        SpringApplication.run(EurekaApplication.class, args);
    }

}


