package org.rulevisualization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.rulelearn.data.Attribute;
import org.rulelearn.data.json.AttributeParser;
import org.rulelearn.rules.RuleSetWithCharacteristics;
import org.rulelearn.rules.ruleml.RuleParser;
import org.rulevisualization.serializers.RuleSetWithCharacteristicsSerializer;

import com.google.gson.JsonElement;

public class RulesWithCharacteristicsSerializerTest {
	
	@Test
	public void test1() throws IOException {
		Map<Integer, RuleSetWithCharacteristics> rules = null;
		FileReader attributeReader = new FileReader("src/test/resources/prioritisation.json");
		FileInputStream rulesStream = new FileInputStream("src/test/resources/prioritisation1.rules.xml");
		
		AttributeParser attributeParser = new AttributeParser();
		Attribute [] attributes = attributeParser.parseAttributes(attributeReader);
		RuleParser ruleParser = new RuleParser(attributes);
		rules = ruleParser.parseRulesWithCharacteristics(rulesStream);
		
		RuleSetWithCharacteristicsSerializer serializer = new RuleSetWithCharacteristicsSerializer();
		JsonElement json = serializer.serialize(rules.get(1), null, null);
		try (PrintWriter out = new PrintWriter("src/test/resources/rules1.json")) {
		    out.println(json.toString());
		}
		
		assertEquals(2, json.getAsJsonArray().size());
	}
	
	@Test
	public void test2() throws IOException {
		Map<Integer, RuleSetWithCharacteristics> rules = null;
		FileReader attributeReader = new FileReader("src/test/resources/prioritisation.json");
		FileInputStream rulesStream = new FileInputStream("src/test/resources/prioritisation2.rules.xml");
		
		AttributeParser attributeParser = new AttributeParser();
		Attribute [] attributes = attributeParser.parseAttributes(attributeReader);
		RuleParser ruleParser = new RuleParser(attributes);
		rules = ruleParser.parseRulesWithCharacteristics(rulesStream);
		
		RuleSetWithCharacteristicsSerializer serializer = new RuleSetWithCharacteristicsSerializer();
		JsonElement json = serializer.serialize(rules.get(1), null, null);
		try (PrintWriter out = new PrintWriter("src/test/resources/rules2.json")) {
		    out.println(json.toString());
		}
		
		assertEquals(29, json.getAsJsonArray().size());
	}
	
	@Test
	public void test3() throws IOException {
		Map<Integer, RuleSetWithCharacteristics> rules = null;
		FileReader attributeReader = new FileReader("src/test/resources/prioritisation.json");
		FileInputStream rulesStream = new FileInputStream("src/test/resources/prioritisation3.rules.xml");
		
		AttributeParser attributeParser = new AttributeParser();
		Attribute [] attributes = attributeParser.parseAttributes(attributeReader);
		RuleParser ruleParser = new RuleParser(attributes);
		rules = ruleParser.parseRulesWithCharacteristics(rulesStream);
		
		RuleSetWithCharacteristicsSerializer serializer = new RuleSetWithCharacteristicsSerializer();
		JsonElement json = serializer.serialize(rules.get(1), null, null);
		try (PrintWriter out = new PrintWriter("src/test/resources/rules3.json")) {
		    out.println(json.toString());
		}
		
		assertEquals(2, json.getAsJsonArray().size());
	}
}
