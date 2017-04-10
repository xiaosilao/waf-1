package com.chinaredstar.waf;

import org.littleshoot.proxy.HostResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author:杨果
 * @date:2017/3/31 下午7:28
 *
 * Description:
 *
 */
public class RedStarHostResolver implements HostResolver {
    private static Logger logger = LoggerFactory.getLogger(RedStarHostResolver.class);

    @Override
    public InetSocketAddress resolve(String host, int port)
            throws UnknownHostException {
        logger.info("host resolver host:{},port:{}", host, port);
        InetAddress addr = InetAddress.getByName(host);
        if (host.equals("waf.mklmall.com")) {
            return new InetSocketAddress("172.16.121.226", 8080);
        }else if(host.equals("localhost")){
            return new InetSocketAddress("172.16.108.37", 8081);
        }
        return new InetSocketAddress(addr, port);
    }
}