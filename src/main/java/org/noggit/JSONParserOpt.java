package org.noggit;

public class JSONParserOpt extends JSONParser {

  public JSONParserOpt(String data) {
    this(data, 0, data.length());
  }

  public JSONParserOpt(String data, int start, int end) {
    this.in = null;
    this.start = start;
    this.end = end;
    int power = 32 - Integer.numberOfLeadingZeros(end - start);
    this.buf = new char[1 << Math.max(power, 13)];
    this.valstate = 0;

    data.getChars(start,end,buf,0);
  }

  public void reUse(String data, int start, int end) {
    if (buf.length < end - start + 1) {
      int power = 32 - Integer.numberOfLeadingZeros(end - start);
      buf = new char[1 << power];
    }

    this.valstate = 0;
    this.start = start;
    this.end = end;
    ptr = 0;
    state = 0;
    event = 0;
    gpos = 0;
    stringTerm = 0;
    nstate = 0;
    data.getChars(start, end, buf,0);
  }
}
