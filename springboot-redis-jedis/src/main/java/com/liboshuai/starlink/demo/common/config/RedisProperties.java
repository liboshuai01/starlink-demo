package com.liboshuai.starlink.demo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String nodes;

    private Integer maxRedirects;

    private String password;

    private int timeout;

    private Integer maxIdle;

    private Integer maxTotal;

    private Integer maxWaitMillis;

    private Integer minEvictableIdleTimeMillis;

    private Integer numTestsPerEvictionRun;

    private long timeBetweenEvictionRunsMillis;

    private boolean testOnBorrow;

    private boolean testWhileIdle;

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(Integer maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public Integer getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedisProperties that = (RedisProperties) o;
        return timeout == that.timeout && timeBetweenEvictionRunsMillis == that.timeBetweenEvictionRunsMillis && testOnBorrow == that.testOnBorrow && testWhileIdle == that.testWhileIdle && Objects.equals(nodes, that.nodes) && Objects.equals(maxRedirects, that.maxRedirects) && Objects.equals(password, that.password) && Objects.equals(maxIdle, that.maxIdle) && Objects.equals(maxTotal, that.maxTotal) && Objects.equals(maxWaitMillis, that.maxWaitMillis) && Objects.equals(minEvictableIdleTimeMillis, that.minEvictableIdleTimeMillis) && Objects.equals(numTestsPerEvictionRun, that.numTestsPerEvictionRun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, maxRedirects, password, timeout, maxIdle, maxTotal, maxWaitMillis, minEvictableIdleTimeMillis, numTestsPerEvictionRun, timeBetweenEvictionRunsMillis, testOnBorrow, testWhileIdle);
    }

    @Override
    public String toString() {
        return "RedisProperties{" +
                "nodes='" + nodes + '\'' +
                ", maxRedirects=" + maxRedirects +
                ", password='" + password + '\'' +
                ", timeout=" + timeout +
                ", maxIdle=" + maxIdle +
                ", maxTotal=" + maxTotal +
                ", maxWaitMillis=" + maxWaitMillis +
                ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis +
                ", numTestsPerEvictionRun=" + numTestsPerEvictionRun +
                ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis +
                ", testOnBorrow=" + testOnBorrow +
                ", testWhileIdle=" + testWhileIdle +
                '}';
    }
}