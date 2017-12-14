/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

/**
 * <p>
 * 类描述:测试修改JsonNode的属性节点，原父节点是否能感知
 * 结论：path取到的是子节点的对象本身，不是副本，所以修改能反应到父节点中。
 * <p>
 * 
 * 所属包:org.guanmu.test
 * @author guanmu 2017-12-14
 * 
 */
public class JsonNodeTest {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectNode objNode = mapper.createObjectNode();
		objNode.put("name", "device");
		
		ArrayNode lunList = mapper.createArrayNode();
		
		for(int i = 0;i < 2;i++) {
			String lunName = "lun" + i;
			String lunId = "" + i;
			
			ObjectNode lunNode = mapper.createObjectNode();
			lunNode.put("lunName", lunName);
			lunNode.put("lunId", lunId);
			
			lunList.add(lunNode);
		}
		
		String lunListStr = mapper.writeValueAsString(lunList);
		System.out.println("lunListStr:" + lunListStr);
		
		objNode.put("lunList", lunList);
		String objNodeStr = mapper.writeValueAsString(objNode);
		System.out.println("objNodeStr1:" + objNodeStr);
		
		ArrayNode tmpLunList = (ArrayNode)objNode.path("lunList");
		
		System.out.println(lunList == tmpLunList);
		
		ObjectNode addLun = mapper.createObjectNode();
		addLun.put("lunName", "add");
		addLun.put("lunId", "11111");
		tmpLunList.add(addLun);
		
		System.out.println("objNodeStr2:" + objNode);
		
		
	}
	
}
