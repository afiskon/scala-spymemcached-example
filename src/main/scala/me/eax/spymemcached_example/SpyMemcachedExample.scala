package me.eax.spymemcached_example

import java.net.InetSocketAddress
import java.util.concurrent.TimeUnit

import net.spy.memcached.MemcachedClient

import scala.compat.Platform

object SpyMemcachedExample extends App {
  val endpoint = "memcache-cluster.dxwhlt.cfg.usw1.cache.amazonaws.com"
  val port = 11211

  val client = new MemcachedClient(new InetSocketAddress(endpoint, port))
  val startTime = Platform.currentTime

  println(s"Start time: $startTime")

  for (i <- 1 to 32) {
    try {
      val key = s"test-key-$i"
      client.set(key, 3600, s"test-value-$i-$startTime").get(100, TimeUnit.MILLISECONDS)
      val value = client.asyncGet(key).get(100, TimeUnit.MILLISECONDS).asInstanceOf[String]
      println(s"key $i - OK: $value")
    } catch {
      case e: Exception =>
        println(s"key $i - FAILED: ${e.getMessage}")
    }
  }

  // клиент создает трэды, для завершения которых нужно явно завершить приложение
  System.exit(0)
}
