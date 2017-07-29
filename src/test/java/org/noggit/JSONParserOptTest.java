package org.noggit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

import java.io.IOException;

public class JSONParserOptTest extends TestCase {

  public void testSingle() throws IOException {
    JSONParserOpt parser = new JSONParserOpt("{'count': 1600}");

    // {
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'count'
    assertEquals(JSONParser.STRING, parser.nextEvent());
    assertEquals("count", parser.getString());

    // 1600
    assertEquals(JSONParser.LONG, parser.nextEvent());
    assertEquals(1600, parser.getLong());

    // }
    assertEquals(JSONParser.OBJECT_END, parser.nextEvent());

    String data = "{'quatro': {'gone': 128} }";
    parser.reUse(data, 0, data.length());

    // {
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'quatro'
    assertEquals(JSONParser.STRING, parser.nextEvent());
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'gone'
    assertEquals(JSONParser.STRING, parser.nextEvent());
    assertEquals("gone", parser.getString());

    // 1600
    assertEquals(JSONParser.LONG, parser.nextEvent());
    assertEquals(128, parser.getLong());

    // }}
    assertEquals(JSONParser.OBJECT_END, parser.nextEvent());
    assertEquals(JSONParser.OBJECT_END, parser.nextEvent());
  }

  public void testFinishInMiddle() throws IOException {
    JSONParserOpt parser = new JSONParserOpt("{'count': 1600}");

    // {
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'count'
    assertEquals(JSONParser.STRING, parser.nextEvent());

    String data = "{'quatro': {'gone': 128} }";
    parser.reUse(data, 0, data.length());

    // {
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'quatro'
    assertEquals(JSONParser.STRING, parser.nextEvent());
    assertEquals(JSONParser.OBJECT_START, parser.nextEvent());

    // 'gone'
    assertEquals(JSONParser.STRING, parser.nextEvent());
    assertEquals("gone", parser.getString());

    // 1600
    assertEquals(JSONParser.LONG, parser.nextEvent());
    assertEquals(128, parser.getLong());

    // }}
    assertEquals(JSONParser.OBJECT_END, parser.nextEvent());
    assertEquals(JSONParser.OBJECT_END, parser.nextEvent());
  }

}
