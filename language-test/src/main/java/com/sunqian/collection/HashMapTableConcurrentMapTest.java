package com.sunqian.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapTableConcurrentMapTest {

    Hashtable table= new Hashtable<String,String>();

    ConcurrentMap concurrentMap=new  ConcurrentHashMap();

    Set<String> custSendedSeqSet=Collections.synchronizedSet(new HashSet<String>());
}
