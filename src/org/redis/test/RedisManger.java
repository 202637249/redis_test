package org.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisManger
{
	public RedisManger manger = null;
	private static Jedis jedis = null;
	private static String hostStr ;
	private static String password;
	private static Transaction transaction;
	
	public RedisManger()
    {
		hostStr = "127.0.0.1";
		password ="";
		jedis = new Jedis(hostStr);
		if(!"".equals(password))
		{
			jedis.auth(password);
		}
		transaction = jedis.multi();
    }
	
	public static void setKeyValue(String key, String value)
	{
	//	jedis.set(key, value);
		transaction.set(key, value);
	}
	
	public static String getValue(String key)
	{
		return jedis.get(key);
	}
	
	synchronized public RedisManger getInstance()
    {
      if(null == manger)
      {
    	  manger = new RedisManger();
      }
      return manger;
    }
	
}
