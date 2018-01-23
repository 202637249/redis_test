package org.redis.test;

import redis.clients.jedis.Jedis;

public class Test1
{
	public static void main(String[] args)
    {
	    Jedis jedis = new Jedis("127.0.0.1");
	    //redis 验证密码,没有密码直接跳过
	    //jedis.auth("");
	    jedis.set("name", "lzq");
	    
	    System.out.println(jedis.ping());
	    System.out.println(jedis.get("name"));
	    
    }
}
