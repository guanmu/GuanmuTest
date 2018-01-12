/* Copyright 2002-2012 the original author or authors. */
package org.guanmu.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.guanmu.model.Student;

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
	
	private static ObjectNode objNode = mapper.createObjectNode();
	private static ArrayNode lunList = mapper.createArrayNode();
	
	static {
		mapper = new ObjectMapper();
		//设置输出时包含属性的风格
		mapper.setSerializationInclusion(Inclusion.ALWAYS);
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//禁止使用int代表Enum的order()來反序列化Enum,非常危險
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);		
		
		
		JsonNode nullNode = null;
		objNode.put("null", nullNode);
		
		objNode.put("name", "device");
		
		for(int i = 0;i < 2;i++) {
			String lunName = "lun" + i;
			String lunId = "" + i;
			
			ObjectNode lunNode = mapper.createObjectNode();
			lunNode.put("lunName", lunName);
			lunNode.put("lunId", lunId);
			
			lunNode.put("null", nullNode);
			
			lunList.add(lunNode);
		}
		
		String lunListStr = null;
		try {
			lunListStr = mapper.writeValueAsString(lunList);
			System.out.println("lunListStr:" + lunListStr);
			objNode.put("lunList", lunList);
			String objNodeStr = mapper.writeValueAsString(objNode);
			System.out.println("objNodeStr1:" + objNodeStr);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	private static void test1() throws JsonGenerationException, JsonMappingException, IOException {

		
		ArrayNode tmpLunList = (ArrayNode)objNode.path("lunList");
		
		System.out.println(lunList == tmpLunList);
		
		ObjectNode addLun = mapper.createObjectNode();
		addLun.put("lunName", "add");
		addLun.put("lunId", "11111");
		tmpLunList.add(addLun);
		
		System.out.println("objNodeStr2:" + objNode);
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		test1();
//		
//		test2();
//		
//		test3();
		
//		test4();
		
		test5();
		
		test6();
		
	}

	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	private static void test6() throws JsonGenerationException, JsonMappingException, IOException {
		Student student = new Student("a", 17, "s");
		
		
		System.out.println(mapper.writeValueAsString(student));
		
		mapper.configure(DeserializationConfig.Feature.USE_ANNOTATIONS, true);

		System.out.println(mapper.writeValueAsString(student));		
	}

	/**
	 * 
	 */
	private static void test5() {
		JsonNode missing = objNode.path("missing");
		
		System.out.println(missing.isMissingNode());
		
		String test = missing.asText();
		System.out.println("[" + test + "]");
	}

	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	private static void test4() throws JsonGenerationException, JsonMappingException, IOException {
		Test t = new Test();
		t.setA("a");
		
		String testStr = mapper.writeValueAsString(t);
		System.out.println(testStr);
		
		JsonNode tmpNode = mapper.convertValue(testStr, JsonNode.class);
		
		String tmpStr = mapper.writeValueAsString(tmpNode);
		
		System.out.println(tmpStr);
	}

	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	private static void test3() throws JsonGenerationException, JsonMappingException, IOException {
		JsonNode missNode = objNode.path("null");
		
		System.out.println("[" + missNode.asText() + "]");
		
		String nullStr = mapper.writeValueAsString(null);
		System.out.println("[" + nullStr + "]");
		
	}

	/**
	 * 使用convertValue转换后，会产生新的对象
	 */
	private static void test2() {
		JsonNode fieldNode = objNode.path("lunList");
		ArrayNode tmpLunList = (ArrayNode)fieldNode;
		
		ArrayNode convertLunList = mapper.convertValue(fieldNode, ArrayNode.class);
		System.out.println(convertLunList == tmpLunList);
		
		System.out.println(convertLunList.equals(tmpLunList));
	}
	
}
