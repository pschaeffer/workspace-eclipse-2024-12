package com.headlamp;
import com.google.common.cache.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
class HDLmBuildJsCompressBlanksAndNames{
  private static final Logger LOG=LoggerFactory.getLogger(HDLmBuildJsCompressBlanksAndNames.class);
	private HDLmBuildJsCompressBlanksAndNames() {}
  @SuppressWarnings("unused")
  public static String getJsBuildJs(final HDLmProtocolTypes protocol,
                                    final String B7,
                                    final String hostName,
                                    final String divisionName,
                                    final String siteName,
                                    final ArrayList<HDLmMod>mods,
                                    final HDLmSession sessionObj,
                                    final HDLmLogMatchingTypes m5,
                                    final String serverName) {
    if (protocol==null) {
		  String  b3="Protocol string passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
		if (hostName==null) {
		  String  b3="Host name string passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
		if (divisionName==null) {
		  String  b3="Division name string passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
		if (siteName==null) {
		  String  b3="Site name string passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
		if (mods==null) {
		  String  b3="Modifications array passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
    if (sessionObj==null) {
		  String  b3="Session object passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
    if (m5==null) {
		  String  b3="Log rule matching reference passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
    if (serverName==null) {
		  String  b3="Server name string passed to getJsBuildJs is null";
      throw new NullPointerException(b3);
}
    HDLmBuildLines  builder;
    String          actualJS;
    String          fixedJSName=null;
    boolean         useCreateFixedJS=false;
    String        B9=sessionObj.getSessionId();
    String        C2=sessionObj.getIndex();
    String        sessionParametersStr=sessionObj.getParameters();
    ArrayList<Double>sessionParametersArray=HDLmMain.getParametersArray(sessionParametersStr);
    if (1==2) {
      actualJS=HDLmUtility.fileGetContents("HDLmBuildJsCompressBlanksAndNamesOld.txt");
      return actualJS;
}
    if (useCreateFixedJS) {
    	fixedJSName=HDLmDefines.getString("HDLMFIXEDFILENAME");
    	boolean   fileExists=HDLmUtility.fileExists(fixedJSName);
    	if (fileExists) {
        actualJS=HDLmUtility.fileGetContents(fixedJSName);
        return actualJS;
}
}
    if (mods.size() ==0&&
    		mods.size() !=0)
      return "<script></script>";
    builder=new HDLmBuildLines("JS");
    builder.addLine("<script>");
    builder.addLine("\"use strict\";");
    builder.addLine("let h9={");
    builder.addLine("\"none\":0,");
    builder.addLine("\"off\":1,");
    builder.addLine("\"error\":2,");
    builder.addLine("\"all\":3");
    builder.addLine("};");
    builder.addLine("document.addEventListener(\"keydown\",event=>{");
    builder.addLine("if (event.key=='b'&&event.ctrlKey==true)");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionDebugRulesEnabled\",'true');");
    builder.addLine("if (event.key=='i'&&event.ctrlKey==true)");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionDebugNodeIdenEnabled\",'all');");
    builder.addLine("if (event.key=='m'&&event.ctrlKey==true)");
    builder.addLine("k0();");
    builder.addLine("if (event.key=='q'&&event.ctrlKey==true)");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionPostRuleTracingEnabled\",'true');");
    builder.addLine("if (event.key=='x'&&event.ctrlKey==true)");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionIgnoreProbability\",'true');");
    builder.addLine("});");
    builder.addLine("function d7(y7,");
    builder.addLine("D,");
    builder.addLine("C0,");
    builder.addLine("sessionIndexValue,");
    builder.addLine("x7,");
    builder.addLine("z5,");
    builder.addLine("k3,");
    builder.addLine("Y,");
    builder.addLine("C4,");
    builder.addLine("z6,");
    builder.addLine("d4,");
    builder.addLine("m5,");
    builder.addLine("z8,");
    builder.addLine("handlingARealMod) {");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionRuleInfoHostName\",k3);");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionRuleInfoDivisionName\",Y);");
    builder.addLine("sessionStorage.setItem(\"HDLmSessionRuleInfoSiteName\",C4);");
    builder.addLine("if (sessionStorage.getItem('HDLmSessionDebugRulesEnabled') =='true')");
    builder.addLine("m5=true;");
    builder.addLine("let u1=h9.off;");
    builder.addLine("if (sessionStorage.getItem('HDLmSessionDebugNodeIdenEnabled') =='all')");
    builder.addLine("u1=h9.all;");
    builder.addLine("let y9=false;");
    builder.addLine("if (sessionStorage.getItem('HDLmSessionPostRuleTracingEnabled') =='true')");
    builder.addLine("y9=true;");
    builder.addLine("let n1=false;");
    builder.addLine("let n0='';");
    builder.addLine("let n2=k3+'/'+Y+'/'+C4+'/'+D.name");
    builder.addLine("n2=i8(n2);");
    builder.addLine("let P=D.type;");
    builder.addLine("while (true) {");
    builder.addLine("let z0=new Object();");
    builder.addLine("if (D.prob<100.0) {");
    builder.addLine("let localRandomValue=Math.random();");
    builder.addLine("let ignoreProbability=sessionStorage.getItem('HDLmSessionIgnoreProbability');");
    builder.addLine("if (ignoreProbability==null)");
    builder.addLine("ignoreProbability='false';");
    builder.addLine("if (localRandomValue*100.0>D.prob&&");
    builder.addLine("ignoreProbability!='true') {");
    builder.addLine("n0='probability';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,null,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (false) {");
    builder.addLine("n0='false';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,null,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("let n4;");
    builder.addLine("let n3;");
    builder.addLine("if (D.pathre===true) {");
    builder.addLine("let H=D.path.length;");
    builder.addLine("n3=new RegExp(D.path.substr(2,H-3));");
    builder.addLine("n4=n3.test(y7);");
    builder.addLine("if (y9==true) {");
    builder.addLine("z0.matchpathre=D.pathre;");
    builder.addLine("z0.matchpath=D.path;");
    builder.addLine("z0.matchpathvalue=y7;");
    builder.addLine("z0.matchmatch=n4;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("n4= (D.path===y7);");
    builder.addLine("if (y9==true) {");
    builder.addLine("z0.matchpathre=D.pathre;");
    builder.addLine("z0.matchpath=D.path;");
    builder.addLine("z0.matchpathvalue=y7;");
    builder.addLine("z0.matchmatch=n4;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (n4==false) {");
    builder.addLine("n0='Path value mismatch';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,null,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("if (m5==true) {");
    builder.addLine("let b3=e1(D,'match',y7);");
    builder.addLine("e0('Trace','Mod',35,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("const c9={");
    builder.addLine("'fontcolor':'color',");
    builder.addLine("'fontfamily':'font-family',");
    builder.addLine("'fontkerning':'font-kerning',");
    builder.addLine("'fontsize':'font-size',");
    builder.addLine("'fontstyle':'font-style',");
    builder.addLine("'fontweight':'font-weight'");
    builder.addLine("}");
    builder.addLine("let x5=-1;");
    builder.addLine("let finalLookupIndex=0;");
    builder.addLine("let m9=-1.0;");
    builder.addLine("let sessionIndexValueUsed=false;");
    builder.addLine("let D4=g6(D.name);");
    builder.addLine("if (typeof(D4) !='undefined'&&");
    builder.addLine("D4!=null) {");
    builder.addLine("m9=sessionIndexValue;");
    builder.addLine("sessionIndexValueUsed=true;");
    builder.addLine("finalLookupIndex=D4;");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("x5=D.parameter;");
    builder.addLine("if (x5!=null&&");
    builder.addLine("x5>=0&&");
    builder.addLine("x5<x7.length)");
    builder.addLine("m9=x7[x5];");
    builder.addLine("}");
    builder.addLine("let u5=f5(D,u1,y9,z0);");
    builder.addLine("let u7=u5.length;");
    builder.addLine("if (u7==0&&P!='visit') {");
    builder.addLine("n0='nonodes';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("switch (P) {");
    builder.addLine("case'attribute':{");
    builder.addLine("let E=D.extra;");
    builder.addLine("let F=E.split('/');");
    builder.addLine("let g=F[0];");
    builder.addLine("let h=F[1]");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let K=u5[i];");
    builder.addLine("f2(K,P,E);");
    builder.addLine("n1=true;");
    builder.addLine("if (h6(K,n2,z8) >0)");
    builder.addLine("break;");
    builder.addLine("h6(K,n2);");
    builder.addLine("if (h.toUpperCase() =='USEPROXYHOST') {");
    builder.addLine("let l=K.getAttribute(g);");
    builder.addLine("let w8=l;");
    builder.addLine("let v7=new URL(l);");
    builder.addLine("v7.host=z5;");
    builder.addLine("let q3=v7.href;");
    builder.addLine("K.setAttribute(g,v7.href);");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("w8,q3);");
    builder.addLine("z0.matchError='attribute';");
    builder.addLine("j7(m4,'href','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'extract':{");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let K=u5[i];");
    builder.addLine("let E=D.extra;");
    builder.addLine("f2(K,P,E);");
    builder.addLine("n1=true;");
    builder.addLine("if (h1(K,n2,z8) >0)");
    builder.addLine("break;");
    builder.addLine("h6(K,n2);");
    builder.addLine("let w8;");
    builder.addLine("if (j2.hasOwnProperty(D.name))");
    builder.addLine("w8=j2[D.name];");
    builder.addLine("else");
    builder.addLine("w8=null;");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("w8,null);");
    builder.addLine("let m3='extract';");
    builder.addLine("if ((typeof E) !='undefined'&&");
    builder.addLine("E!=null&&");
    builder.addLine("E!='')");
    builder.addLine("m3=E;");
    builder.addLine("z0.matchError='extract';");
    builder.addLine("j7(m4,m3,'1.0',z0);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'modify':{");
    builder.addLine("if (z6==null) {");
    builder.addLine("let b3=`No secure host name for (${k3})`;");
    builder.addLine("e0('Error','Mod',16,b3);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let K=u5[i];");
    builder.addLine("let E=D.extra;");
    builder.addLine("f2(K,P,E);");
    builder.addLine("if (E.toUpperCase() !=='FIXIFRAMESRC')");
    builder.addLine("break;");
    builder.addLine("n1=true;");
    builder.addLine("if (h1(K,n2,z8) >0)");
    builder.addLine("break;");
    builder.addLine("h6(K,n2);");
    builder.addLine("let v2=K.getAttribute('src');");
    builder.addLine("let w8=v2;");
    builder.addLine("let v7=new URL(v2);");
    builder.addLine("v7.host=z6;");
    builder.addLine("let q3=v7.href+'&HDLmSessionId='+C0;");
    builder.addLine("K.setAttribute('src',q3);");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("null,null);");
    builder.addLine("let m3='modify';");
    builder.addLine("if ((typeof E) !='undefined'&&");
    builder.addLine("E!=null&&");
    builder.addLine("E!='')");
    builder.addLine("m3=E;");
    builder.addLine("z0.matchError='modify';");
    builder.addLine("j7(m4,m3,'1.0',z0);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'notify':{");
    builder.addLine("let B8=false;");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let v1=u5[i];");
    builder.addLine("if (h1(v1,n2,z8) ==0) {");
    builder.addLine("B8=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("let E=D.extra;");
    builder.addLine("if (B8) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("null,null);");
    builder.addLine("let m3='notify';");
    builder.addLine("if ((typeof E) !='undefined'&&");
    builder.addLine("E!=null&&");
    builder.addLine("E!='')");
    builder.addLine("m3=E;");
    builder.addLine("z0.matchError='notify';");
    builder.addLine("j7(m4,m3,'1.0',z0);");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let K=u5[i];");
    builder.addLine("f2(K,P,E);");
    builder.addLine("n1=true;");
    builder.addLine("if (h1(K,n2,z8) >0)");
    builder.addLine("break;");
    builder.addLine("h6(K,n2);");
    builder.addLine("K.addEventListener('click', (function() {");
    builder.addLine("return function() {");
    builder.addLine("let m4=new Object();");
    builder.addLine("if (D.valuesCount<=0) {");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("null,null);");
    builder.addLine("}");
    builder.addLine("for (let j=0;j<D.valuesCount;j++) {");
    builder.addLine("let B1=D.values[j];");
    builder.addLine("B1=h8(B1);");
    builder.addLine("let B2;");
    builder.addLine("if (j3.hasOwnProperty(B1))");
    builder.addLine("B2=j3[B1];");
    builder.addLine("else");
    builder.addLine("B2=null;");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("B2,null);");
    builder.addLine("}");
    builder.addLine("let m3='notify';");
    builder.addLine("let E=D.extra;");
    builder.addLine("if ((typeof E) !='undefined'&&");
    builder.addLine("E!=null&&");
    builder.addLine("E!='')");
    builder.addLine("m3=E;");
    builder.addLine("z0.matchError='click';");
    builder.addLine("j7(m4,m3,'1.0',z0);");
    builder.addLine("}");
    builder.addLine("})());");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'visit':{");
    builder.addLine("let D5=false;");
    builder.addLine("h5(D.extra,z0,D5,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7,handlingARealMod);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'changeattrs':");
    builder.addLine("case'changenodes':");
    builder.addLine("case'fontcolor':");
    builder.addLine("case'fontfamily':");
    builder.addLine("case'fontkerning':");
    builder.addLine("case'fontsize':");
    builder.addLine("case'fontstyle':");
    builder.addLine("case'fontweight':");
    builder.addLine("case'height':");
    builder.addLine("case'image':");
    builder.addLine("case'order':");
    builder.addLine("case'remove':");
    builder.addLine("case'replace':");
    builder.addLine("case'script':");
    builder.addLine("case'style':");
    builder.addLine("case'text':");
    builder.addLine("case'textchecked':");
    builder.addLine("case'title':");
    builder.addLine("case'webpage':");
    builder.addLine("case'width':{");
    builder.addLine("let q5=D.values;");
    builder.addLine("let o6=D.valuesCount;");
    builder.addLine("if (m9!=null&&sessionIndexValueUsed==false) {");
    builder.addLine("finalLookupIndex=Math.floor(o6*m9);");
    builder.addLine("finalLookupIndex=Math.min(finalLookupIndex,o6-1);");
    builder.addLine("}");
    builder.addLine("let d2=false;");
    builder.addLine("let q3;");
    builder.addLine("if (m9!=null) {");
    builder.addLine("if (finalLookupIndex>=0)");
    builder.addLine("q3=q5[finalLookupIndex];");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<o6;i++) {");
    builder.addLine("if (q5[i].startsWith(d4)) {");
    builder.addLine("q3=q5[i].substring(d4.length);");
    builder.addLine("finalLookupIndex=i;");
    builder.addLine("d2=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (m9==null&&");
    builder.addLine("d2==false) {");
    builder.addLine("n0='Null lookup value';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("n0='Fired';");
    builder.addLine("let K=u5[i];");
    builder.addLine("let E=D.extra;");
    builder.addLine("f2(K,P,E);");
    builder.addLine("let w8;");
    builder.addLine("if (P=='changeattrs') {");
    builder.addLine("w8=g2(K);");
    builder.addLine("}");
    builder.addLine("else if (P=='changenodes') {");
    builder.addLine("w8=K.outerHTML;");
    builder.addLine("}");
    builder.addLine("else if (P=='fontcolor'||");
    builder.addLine("P=='fontfamily'||");
    builder.addLine("P=='fontkerning'||");
    builder.addLine("P=='fontsize'||");
    builder.addLine("P=='fontstyle'||");
    builder.addLine("P=='fontweight') {");
    builder.addLine("let p2=c9[P];");
    builder.addLine("w8='';");
    builder.addLine("if (K.style.hasOwnProperty(p2))");
    builder.addLine("w8=K.style.getPropertyValue(p2);");
    builder.addLine("else if (K.hasAttribute(p2))");
    builder.addLine("w8=K.getAttribute(p2);");
    builder.addLine("}");
    builder.addLine("else if (P=='height'||");
    builder.addLine("P=='width') {");
    builder.addLine("w8='';");
    builder.addLine("if (K.hasAttribute(P))");
    builder.addLine("w8=K.getAttribute(P);");
    builder.addLine("}");
    builder.addLine("else if (P=='image') {");
    builder.addLine("w8='';");
    builder.addLine("if (K.hasAttribute('src')) {");
    builder.addLine("w8=K.getAttribute('src');");
    builder.addLine("if (w8.startsWith('http'))");
    builder.addLine("w8=i7(w8);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='order') {");
    builder.addLine("w8='';");
    builder.addLine("}");
    builder.addLine("else if (P=='remove') {");
    builder.addLine("w8='';");
    builder.addLine("}");
    builder.addLine("else if (P=='replace') {");
    builder.addLine("w8='';");
    builder.addLine("}");
    builder.addLine("else if (P=='script') {");
    builder.addLine("w8='';");
    builder.addLine("}");
    builder.addLine("else if (P=='style') {");
    builder.addLine("w8='';");
    builder.addLine("let I=j9(E);");
    builder.addLine("let J=I.length;");
    builder.addLine("for (let i=0;i<J;i++) {");
    builder.addLine("let O=I[i];");
    builder.addLine("let Q='';");
    builder.addLine("if (K.hasAttribute('style')) {");
    builder.addLine("if (K.style.hasOwnProperty(O))");
    builder.addLine("Q=K.style.getPropertyValue(O);");
    builder.addLine("}");
    builder.addLine("if (Q==''&&");
    builder.addLine("K.hasAttribute(O)) {");
    builder.addLine("Q=K.getAttribute(O);");
    builder.addLine("}");
    builder.addLine("if (Q!='') {");
    builder.addLine("if (w8!='')");
    builder.addLine("w8+=' '");
    builder.addLine("w8+=Q;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='text'||");
    builder.addLine("P=='textchecked'||");
    builder.addLine("P=='title') {");
    builder.addLine("w8=K.textContent;");
    builder.addLine("}");
    builder.addLine("else if (P=='webpage') {");
    builder.addLine("w8='';");
    builder.addLine("}");
    builder.addLine("if (P=='textchecked') {");
    builder.addLine("let D6=e7(w8,E,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7);");
    builder.addLine("if (!D6) {");
    builder.addLine("n0='textunequal';");
    builder.addLine("continue;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("n1=true;");
    builder.addLine("let n5=h1(K,n2,z8);");
    builder.addLine("if (P=='changenodes') {");
    builder.addLine("if (n5>255)");
    builder.addLine("break;");
    builder.addLine("let D5=true;");
    builder.addLine("let d0=e6(K,q3,n5,D5,sessionIndexValueUsed,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("x7,C0,");
    builder.addLine("sessionIndexValue,x5,m9,");
    builder.addLine("k3,Y,C4,");
    builder.addLine("D,y7,w8);");
    builder.addLine("if (d0==true)");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("else if (P=='image') {");
    builder.addLine("if (n5>2)");
    builder.addLine("if (w8==q3||");
    builder.addLine("w8.startsWith('data:'))");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("else if (P=='remove'||");
    builder.addLine("P=='replace') {");
    builder.addLine("let y0=K.parentNode;");
    builder.addLine("if (y0!=null) {");
    builder.addLine("if (h1(y0,n2,z8) >0)");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='textchecked') {");
    builder.addLine("if (n5>1)");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("if (n5>0)");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (P=='remove'||");
    builder.addLine("P=='replace') {");
    builder.addLine("let y0=K.parentNode;");
    builder.addLine("h6(y0,n2);");
    builder.addLine("}");
    builder.addLine("else if (P=='script') {");
    builder.addLine("if (z8=='complete')");
    builder.addLine("h6(K,n2);");
    builder.addLine("}");
    builder.addLine("else if (P=='webpage') {");
    builder.addLine("h6(K,n2);");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("h6(K,n2);");
    builder.addLine("}");
    builder.addLine("if (P=='changeattrs') {");
    builder.addLine("if (q3.trim() !='')");
    builder.addLine("e5(K,q3);");
    builder.addLine("}");
    builder.addLine("else if (P=='changenodes') {");
    builder.addLine("let D5=false;");
    builder.addLine("e6(K,q3,n5,D5,sessionIndexValueUsed,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,");
    builder.addLine("D,y7,w8);");
    builder.addLine("}");
    builder.addLine("else if (P=='fontcolor'||");
    builder.addLine("P=='fontfamily'||");
    builder.addLine("P=='fontkerning'||");
    builder.addLine("P=='fontsize'||");
    builder.addLine("P=='fontstyle'||");
    builder.addLine("P=='fontweight') {");
    builder.addLine("if (P=='fontsize')");
    builder.addLine("q3=e4(q3,'px');");
    builder.addLine("let p2=c9[P];");
    builder.addLine("K.style.setProperty(p2,q3);");
    builder.addLine("}");
    builder.addLine("else if (P=='height'||");
    builder.addLine("P=='width') {");
    builder.addLine("q3=e4(q3,'px');");
    builder.addLine("K.setAttribute(P,q3);");
    builder.addLine("}");
    builder.addLine("else if (P=='image') {");
    builder.addLine("if (q3.startsWith('//'))");
    builder.addLine("K.setAttribute('src','https:'+q3);");
    builder.addLine("if (q3.startsWith('data:'))");
    builder.addLine("K.setAttribute('src',q3);");
    builder.addLine("if (1==1) {");
    builder.addLine("K.style.setProperty('background-repeat','no-repeat');");
    builder.addLine("K.style.setProperty('background-size','cover');");
    builder.addLine("K.style.setProperty('text-align','center');");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='order') {");
    builder.addLine("let s8=K.children.length;");
    builder.addLine("let q2=e3(q3,s8);");
    builder.addLine("for (let j=0;j<q2.length;j++) {");
    builder.addLine("K.appendChild(K.children[q2[j]]);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='remove') {");
    builder.addLine("if (f3(q3,'yes'))");
    builder.addLine("K.remove();");
    builder.addLine("}");
    builder.addLine("else if (P=='replace') {");
    builder.addLine("if (q3!='') {");
    builder.addLine("let y0=K.parentNode;");
    builder.addLine("let p7=JSON.parse(q3);");
    builder.addLine("let p3=e2(p7);");
    builder.addLine("y0.replaceChild(p3,K);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='script') {");
    builder.addLine("if (z8=='complete') {");
    builder.addLine("let functionStr='HDLmExecute'+i8(D.name) +finalLookupIndex;");
    builder.addLine("window[functionStr]();");
    builder.addLine("}");
    builder.addLine("n0=z8;");
    builder.addLine("}");
    builder.addLine("else if (P=='style') {");
    builder.addLine("if (E=='background-image') {");
    builder.addLine("let o8=q3;");
    builder.addLine("if (o8.startsWith('url')) {");
    builder.addLine("}");
    builder.addLine("else if (o8.startsWith('data:')) {");
    builder.addLine("o8='url('+o8+')';");
    builder.addLine("}");
    builder.addLine("else if (o8.startsWith('http')) {");
    builder.addLine("o8='url('+o8+')';");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("if (o8.startsWith('//'))");
    builder.addLine("o8='url(https:'+o8+')';");
    builder.addLine("}");
    builder.addLine("if (1==1) {");
    builder.addLine("K.style.setProperty(E,o8);");
    builder.addLine("K.style.setProperty('background-repeat','no-repeat');");
    builder.addLine("K.style.setProperty('background-size','cover');");
    builder.addLine("}");
    builder.addLine("if (1==2) {");
    builder.addLine("let b9=g3(K,'junk.jpg');");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("let I=j9(E);");
    builder.addLine("let q6=j8(q3);");
    builder.addLine("for (let i in I) {");
    builder.addLine("let q7=q6[i];");
    builder.addLine("if (q7=='none')");
    builder.addLine("continue;");
    builder.addLine("K.style.setProperty(I[i],q7);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (P=='title'||");
    builder.addLine("P=='text'||");
    builder.addLine("P=='textchecked') {");
    builder.addLine("K.textContent=q3;");
    builder.addLine("}");
    builder.addLine("else if (P=='webpage') {");
    builder.addLine("const blob=new Blob([q3],{type:'text/html'});");
    builder.addLine("const blobUrl=URL.createObjectURL(blob);");
    builder.addLine("window.location.href=blobUrl;");
    builder.addLine("}");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("w8,q3);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,P,'1.0',z0);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("default:{");
    builder.addLine("let b3=\"Invalid modification type value-\"+P;");
    builder.addLine("e0('Error','Mod',31,b3);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (n1===false) {");
    builder.addLine("if (n0==='') {");
    builder.addLine("n0='nomatch';");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("null,null,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("null,null);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (n0!=''&&");
    builder.addLine("m5==true) {");
    builder.addLine("let b3=e1(D,n0,y7);");
    builder.addLine("e0('Trace','Mod',2,b3);");
    builder.addLine("}");
    builder.addLine("return n1;");
    builder.addLine("}");
    builder.addLine("function d9(y,l1) {");
    builder.addLine("let rv=\"\";");
    builder.addLine("let d=typeof(y);");
    builder.addLine("if (d=='undefined') {");
    builder.addLine("rv='undefined';");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("if (y==null) {");
    builder.addLine("rv=null;");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("let c=y.length;");
    builder.addLine("if (c<=0)");
    builder.addLine("return rv;");
    builder.addLine("for (let i=0;i<c;i++) {");
    builder.addLine("if (i>0)");
    builder.addLine("rv+=l1;");
    builder.addLine("let Q=y[i];");
    builder.addLine("if (Q==null)");
    builder.addLine("rv+='null';");
    builder.addLine("else");
    builder.addLine("rv+=String(Q);");
    builder.addLine("}");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("function e1(D,n0,y7) {");
    builder.addLine("let b3=\"Modification \"+n0+\"-\";");
    builder.addLine("b3+=\"name (\";");
    builder.addLine("b3+=D.name;");
    builder.addLine("b3+=\")\";");
    builder.addLine("if (Array.isArray(D.find) &&");
    builder.addLine("D.find.length>0) {");
    builder.addLine("b3+=\" key (\";");
    builder.addLine("let c1=D.find[0];");
    builder.addLine("b3+=c1.attributeName;");
    builder.addLine("b3+=\")\";");
    builder.addLine("b3+=\" value (\";");
    builder.addLine("b3+=c1.attributeValue;");
    builder.addLine("b3+=\")\";");
    builder.addLine("}");
    builder.addLine("b3+='-'+y7;");
    builder.addLine("return b3;");
    builder.addLine("}");
    builder.addLine("function e2(a1) {");
    builder.addLine("if (a1.type!='Element')");
    builder.addLine("return null;");
    builder.addLine("if (a1.tag==null)");
    builder.addLine("return null;");
    builder.addLine("let a0=document.createElement(a1.tag);");
    builder.addLine("let e=a1.attributes;");
    builder.addLine("if (e!=null) {");
    builder.addLine("for (let f in e) {");
    builder.addLine("a0.setAttribute(f,e[f]);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("let a6=a1.text;");
    builder.addLine("if (a6!=null) {");
    builder.addLine("let D7=document.createTextNode(a6);");
    builder.addLine("a0.appendChild(D7);");
    builder.addLine("}");
    builder.addLine("let a3=a1.subnodes;");
    builder.addLine("if (a3!=null) {");
    builder.addLine("let a4=a3.length;");
    builder.addLine("for (let i=0;i<a4;i++) {");
    builder.addLine("let a2=a3[i];");
    builder.addLine("let a5=e2(a2);");
    builder.addLine("if (a5!=null)");
    builder.addLine("a0.appendChild(a5);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("return a0;");
    builder.addLine("}");
    builder.addLine("function e3(q3,E1) {");
    builder.addLine("q3=q3.replace(/,/g,' ');");
    builder.addLine("let q4=q3.split(' ');");
    builder.addLine("let o9=[];");
    builder.addLine("let x2=[];");
    builder.addLine("let D3= (function(a,b) {while(a--) b[a]=a;return b})(E1,[]);");
    builder.addLine("for (let i=0;i<q4.length;i++) {");
    builder.addLine("if (q4[i]=='')");
    builder.addLine("continue;");
    builder.addLine("let D2=parseInt(q4[i]);");
    builder.addLine("if (typeof(D2) !='v8')");
    builder.addLine("continue;");
    builder.addLine("o9.push(D2);");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<E1;i++)");
    builder.addLine("if (o9.includes(i) ==false)");
    builder.addLine("o9.push(i);");
    builder.addLine("for (let i=0;i<E1;i++) {");
    builder.addLine("let l0=D3.indexOf(o9[i]);");
    builder.addLine("x2.push(l0);");
    builder.addLine("D3.splice(l0,1);");
    builder.addLine("D3.push(l0)");
    builder.addLine("}");
    builder.addLine("return x2;");
    builder.addLine("}");
    builder.addLine("function e4(q7,D1) {");
    builder.addLine("if ((typeof(q7) =='v8') &&");
    builder.addLine("q7!='')");
    builder.addLine("q7+=D1;");
    builder.addLine("return q7");
    builder.addLine("}");
    builder.addLine("function e6(K,l4,n5,D5,sessionIndexValueUsed,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,");
    builder.addLine("D,y7,w8) {");
    builder.addLine("let t=JSON.parse(l4);");
    builder.addLine("let d0=false;");
    builder.addLine("for (const l6 in t) {");
    builder.addLine("if (!t.hasOwnProperty(l6))");
    builder.addLine("continue;");
    builder.addLine("let v=t[l6];");
    builder.addLine("switch (l6) {");
    builder.addLine("case'text':");
    builder.addLine("case'textchecked':{");
    builder.addLine("let a=K.textContent;");
    builder.addLine("let A1=v[0];");
    builder.addLine("let s=e7(a,A1,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7);");
    builder.addLine("if (n5>1) {");
    builder.addLine("d0=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (s&&D5==false)");
    builder.addLine("K.textContent=v[1];");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'title':{");
    builder.addLine("if (n5>0) {");
    builder.addLine("d0=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (D5==false)");
    builder.addLine("K.textContent=v;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'visit':{");
    builder.addLine("let x=h5(v,z0,D5,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7,handlingARealMod);");
    builder.addLine("if (x==true)");
    builder.addLine("d0=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("default:{");
    builder.addLine("if (n5>0) {");
    builder.addLine("d0=true;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (v==null) {");
    builder.addLine("if (D5==false)");
    builder.addLine("K.style.removeProperty(l6);");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("let u=typeof v;");
    builder.addLine("if (u=='v8') {");
    builder.addLine("v=v.toString();");
    builder.addLine("v+='px';");
    builder.addLine("}");
    builder.addLine("if (D5==false)");
    builder.addLine("K.style.setProperty(l6,v);");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("return d0;");
    builder.addLine("}");
    builder.addLine("function e7(a,A1,");
    builder.addLine("n0,z0,y9,");
    builder.addLine("x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7) {");
    builder.addLine("let rv;");
    builder.addLine("let A2=A1.toLowerCase();");
    builder.addLine("let b=a.toLowerCase();");
    builder.addLine("if (b.indexOf(A2) ===-1) {");
    builder.addLine("if (y9==true) {");
    builder.addLine("let m4=new Object();");
    builder.addLine("n0='textunequal';");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,a,A1);");
    builder.addLine("z0.matchError=n0;");
    builder.addLine("j7(m4,'failure','1.0',z0);");
    builder.addLine("}");
    builder.addLine("rv=false;;");
    builder.addLine("}");
    builder.addLine("else");
    builder.addLine("rv=true;");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("function f2(K,P,b8) {");
    builder.addLine("if (P=='order')");
    builder.addLine("return;");
    builder.addLine("if (P=='style'&&b8=='background-image') {");
    builder.addLine("f1(K,'HDLmClassBackground');");
    builder.addLine("return;");
    builder.addLine("}");
    builder.addLine("f1(K,'HDLmClassPrimary');");
    builder.addLine("}");
    builder.addLine("function f0(y3,y4) {");
    builder.addLine("var C8='HDLmSessionClasses';");
    builder.addLine("var D0=document.createElement('style');");
    builder.addLine("D0.type='text/css';");
    builder.addLine("D0.title=C8;");
    builder.addLine("document.getElementsByTagName('head')[0].appendChild(D0);");
    builder.addLine("D0.sheet.insertRule(y3+\"{\"+y4+\"}\",0);");
    builder.addLine("var T=sessionStorage.getItem(C8+'Disabled');");
    builder.addLine("if (T==null)");
    builder.addLine("T=true;");
    builder.addLine("if (T=='true')");
    builder.addLine("T=true;");
    builder.addLine("if (T=='false')");
    builder.addLine("T=false;");
    builder.addLine("var C7=document.styleSheets;");
    builder.addLine("for (let i=0;i<C7.length;i++) {");
    builder.addLine("var C6=C7[i];");
    builder.addLine("if (C6.title!=null&&");
    builder.addLine("C6.title==C8) {");
    builder.addLine("if (C6.disabled!=T)");
    builder.addLine("C6.disabled=T;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("function f1(a8,o5) {");
    builder.addLine("const a7=a8.classList;");
    builder.addLine("if (a7.length==0)");
    builder.addLine("a7.add(o5);");
    builder.addLine("else if (a7.contains(o5) ==false)");
    builder.addLine("a7.add(o5);");
    builder.addLine("}");
    builder.addLine("function f3(c6,B4) {");
    builder.addLine("return c6.localeCompare(B4,undefined,{sensitivity:'accent'}) ===0;");
    builder.addLine("}");
    builder.addLine("function f4(b1) {");
    builder.addLine("let q1={};");
    builder.addLine("if (typeof b1==='string') {");
    builder.addLine("q1.name='';");
    builder.addLine("q1.message=b1;");
    builder.addLine("q1.reason='exception';");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("q1.name=b1.name;");
    builder.addLine("q1.message=b1.message;");
    builder.addLine("q1.stack=b1.stack;");
    builder.addLine("q1.reason='exception';");
    builder.addLine("}");
    builder.addLine("return JSON.stringify(q1);");
    builder.addLine("}");
    builder.addLine("function f5(D,u1,y9,z0) {");
    builder.addLine("let u5=[];");
    builder.addLine("if (D.cssselector!=='') {");
    builder.addLine("if (y9) {");
    builder.addLine("z0.findtype='CSS Selector';");
    builder.addLine("z0.findvalue=D.cssselector;");
    builder.addLine("}");
    builder.addLine("u5=document.querySelectorAll(D.cssselector);");
    builder.addLine("}");
    builder.addLine("else if (D.xpath!=='') {");
    builder.addLine("if (y9) {");
    builder.addLine("z0.findtype='XPath';");
    builder.addLine("z0.findvalue=D.xpath;");
    builder.addLine("}");
    builder.addLine("let u4=document.evaluate(D.xpath,document,null,");
    builder.addLine("XPathResult.ORDERED_NODE_ITERATOR_TYPE,");
    builder.addLine("null);");
    builder.addLine("let D9=u4.iterateNext();");
    builder.addLine("while (D9) {");
    builder.addLine("u5.push(D9);");
    builder.addLine("D9=u4.iterateNext();");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (D.nodeiden!==null) {");
    builder.addLine("if (y9) {");
    builder.addLine("z0.findtype='Node identifier';");
    builder.addLine("z0.findvalue=D.nodeiden;");
    builder.addLine("}");
    builder.addLine("u5=f6(D,u1,y9,z0);");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("let c2=D.find;");
    builder.addLine("u5=[document];");
    builder.addLine("if (y9) {");
    builder.addLine("z0.findtype='Finds';");
    builder.addLine("z0.findvalues=D.find;");
    builder.addLine("}");
    builder.addLine("let c3=c2.length");
    builder.addLine("for (let i=0;i<c3;i++) {");
    builder.addLine("let c0=c2[i];");
    builder.addLine("u5=f9(u5,c0);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("return u5;");
    builder.addLine("}");
    builder.addLine("function f6(D,u1,y9,z0) {");
    builder.addLine("let t4;");
    builder.addLine("let t5=[];");
    builder.addLine("let t9=D.nodeiden;");
    builder.addLine("let u5=[];");
    builder.addLine("let s5=t9.attributes;");
    builder.addLine("let t2=t9.counts;");
    builder.addLine("let v5=t9.type;");
    builder.addLine("let v6=null;");
    builder.addLine("switch (v5) {");
    builder.addLine("case'tag':{");
    builder.addLine("let v3=s5.tag;");
    builder.addLine("v6=v3;");
    builder.addLine("t5=document.getElementsByTagName(v3);");
    builder.addLine("if (y9) {");
    builder.addLine("z0.nodegetby='tag';");
    builder.addLine("z0.nodegetvalue=v3;");
    builder.addLine("z0.nodecount=t5.length;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'id':{");
    builder.addLine("let t8=s5.id;");
    builder.addLine("v6=t8;");
    builder.addLine("t4=document.getElementById(t8);");
    builder.addLine("if (t4!=null)");
    builder.addLine("t5=[t4];");
    builder.addLine("else");
    builder.addLine("t5=[];");
    builder.addLine("if (y9) {");
    builder.addLine("z0.nodegetby='id';");
    builder.addLine("z0.nodegetvalue=t8;");
    builder.addLine("z0.nodecount=t5.length;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'class':{");
    builder.addLine("let s9;");
    builder.addLine("if (s5.hasOwnProperty('bestclass'))");
    builder.addLine("s9=s5['bestclass'];");
    builder.addLine("else{");
    builder.addLine("let t0=s5.class;");
    builder.addLine("s9=t0[0];");
    builder.addLine("}");
    builder.addLine("v6=s9;");
    builder.addLine("t5=document.getElementsByClassName(s9);");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&s9=='')) {");
    builder.addLine("let b3=`Node identifier-node class is (${s9})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("z0.nodegetby='class';");
    builder.addLine("z0.nodegetvalue=s9;");
    builder.addLine("z0.nodecount=t5.length;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'name':{");
    builder.addLine("let u8=s5.name;");
    builder.addLine("v6=u8;");
    builder.addLine("t5=document.getElementsByName(u8);");
    builder.addLine("if (y9) {");
    builder.addLine("z0.nodegetby='name';");
    builder.addLine("z0.nodegetvalue=u8;");
    builder.addLine("z0.nodecount=t5.length;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("default:{");
    builder.addLine("let b3=\"Invalid node identifier type value-\"+v5;");
    builder.addLine("e0('Error','NodeIden',40,b3);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("let t6=t5.length;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&t6==0)) {");
    builder.addLine("let v4=v5;");
    builder.addLine("if (v6!=null)");
    builder.addLine("v4=v5+'/'+v6");
    builder.addLine("let b3=`Node identifier-get for (${v4}) returned (${t6}) nodes`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("let u0='full';");
    builder.addLine("if (t2[v5]==1&&t6==1)");
    builder.addLine("u0='partial';");
    builder.addLine("u5=f7(t5,");
    builder.addLine("t9,");
    builder.addLine("u0,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0);");
    builder.addLine("return u5;");
    builder.addLine("}");
    builder.addLine("function f7(t5,");
    builder.addLine("t9,");
    builder.addLine("u0,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0) {");
    builder.addLine("let u5=[];");
    builder.addLine("let t1=0;");
    builder.addLine("let z1;");
    builder.addLine("let t6=t5.length;");
    builder.addLine("a9:for (let i=0;i<t6;i++) {");
    builder.addLine("let M=t5[i];");
    builder.addLine("let d5;");
    builder.addLine("let x8;");
    builder.addLine("t1++;");
    builder.addLine("z1='nodetarget';");
    builder.addLine("if (t1>1)");
    builder.addLine("z1+=String(t1-1)");
    builder.addLine("let t3=t9.attributes;");
    builder.addLine("let C=f8(M,");
    builder.addLine("t3,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0,");
    builder.addLine("z1);");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&C<0.95)) {");
    builder.addLine("let b3=`Node identifier-current match value (${C}) for element (${M})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("if (C<0.95)");
    builder.addLine("continue a9;");
    builder.addLine("while (true) {");
    builder.addLine("x8=M.parentElement;");
    builder.addLine("if (typeof x8=='undefined'||");
    builder.addLine("x8==null)");
    builder.addLine("break;");
    builder.addLine("if (t9.hasOwnProperty('parent') ==false)");
    builder.addLine("break;");
    builder.addLine("z1='nodeparent';");
    builder.addLine("if (t1>1)");
    builder.addLine("z1+=String(t1-1);");
    builder.addLine("let u9=t9.parent;");
    builder.addLine("if (typeof u9=='undefined'||");
    builder.addLine("u9==null)");
    builder.addLine("break;");
    builder.addLine("let x9=f8(x8,");
    builder.addLine("u9,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0,");
    builder.addLine("z1);");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&x9<0.95)) {");
    builder.addLine("let b3=`Node identifier-parent match value (${x9}) for element (${x8})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("if (x9<0.95)");
    builder.addLine("continue a9;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("while (true) {");
    builder.addLine("if (typeof x8=='undefined'||");
    builder.addLine("x8==null)");
    builder.addLine("break;");
    builder.addLine("if (t9.hasOwnProperty('grandparent') ==false)");
    builder.addLine("break;");
    builder.addLine("d5=x8.parentElement;");
    builder.addLine("if (typeof d5=='undefined'||");
    builder.addLine("d5==null)");
    builder.addLine("break;");
    builder.addLine("z1='nodegrandparent';");
    builder.addLine("if (t1>1)");
    builder.addLine("z1+=String(t1-1);");
    builder.addLine("let t7=t9.grandparent;");
    builder.addLine("if (typeof t7=='undefined'||");
    builder.addLine("t7==null)");
    builder.addLine("break;");
    builder.addLine("let d6=f8(d5,");
    builder.addLine("t7,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0,");
    builder.addLine("z1);");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&d6<0.95)) {");
    builder.addLine("let b3=`Node identifier-grandparent match value (${d6}) for element (${d5})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("if (d6<0.95)");
    builder.addLine("continue a9;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("u5.push(M);");
    builder.addLine("}");
    builder.addLine("return u5;");
    builder.addLine("}");
    builder.addLine("function f8(t4,");
    builder.addLine("s5,");
    builder.addLine("u1,");
    builder.addLine("y9,");
    builder.addLine("z0,");
    builder.addLine("y8) {");
    builder.addLine("let S=0.0;");
    builder.addLine("let r1;");
    builder.addLine("let s4;");
    builder.addLine("let r9=[];");
    builder.addLine("let v9=0.0;");
    builder.addLine("let w0;");
    builder.addLine("if (y9) {");
    builder.addLine("r1=t4.tagName;");
    builder.addLine("s4=s5.tag");
    builder.addLine("let r8=new Object();");
    builder.addLine("r8.type='tag';");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (f3(t4.tagName,s5.tag))");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("z0[y8+'tag']=r8;");
    builder.addLine("}");
    builder.addLine("if (f3(t4.tagName,s5.tag) ==false) {");
    builder.addLine("return 0.0;");
    builder.addLine("}");
    builder.addLine("let s1=Object.keys(s5);");
    builder.addLine("let s2=s1.length;");
    builder.addLine("for (let i=0;i<s2;i++) {");
    builder.addLine("let s0=s1[i];");
    builder.addLine("if (s0=='bestclass')");
    builder.addLine("continue;");
    builder.addLine("let r8=new Object();");
    builder.addLine("w0=0.0;");
    builder.addLine("S++;");
    builder.addLine("s4=s5[s0];");
    builder.addLine("if (s0=='tag') {");
    builder.addLine("r1=t4.tagName;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(r1,s4))");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(r1,s4))");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (f3(r1,s4))");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("else if (s0=='class') {");
    builder.addLine("if (Array.isArray(s4) &&");
    builder.addLine("s4.length>0)");
    builder.addLine("s4=s4[0];");
    builder.addLine("let r2=t4.getAttribute('class');");
    builder.addLine("if (r2!=null) {");
    builder.addLine("let r4=r2.split(' ');");
    builder.addLine("let r5=r4.length;");
    builder.addLine("let r3=[];");
    builder.addLine("for (let i=0;i<r5;i++) {");
    builder.addLine("let r6=r4[i];");
    builder.addLine("if (r6.endsWith('\\n')) {");
    builder.addLine("let r7=r6.length;");
    builder.addLine("r6=r6.substr(0,r7-1);");
    builder.addLine("}");
    builder.addLine("if (r6.length>0)");
    builder.addLine("r3.push(r6);");
    builder.addLine("}");
    builder.addLine("if (r3.length>0) {");
    builder.addLine("r1=[...r3];");
    builder.addLine("}");
    builder.addLine("else");
    builder.addLine("r1=null;");
    builder.addLine("}");
    builder.addLine("else");
    builder.addLine("r1=null;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("r1.includes(s4))");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("r1.includes(s4))");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (r1.includes(s4))");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("else if (s0=='innertext') {");
    builder.addLine("let u2;");
    builder.addLine("let u3=t4.innerText;");
    builder.addLine("if ((typeof u3) =='undefined')");
    builder.addLine("u3=null;");
    builder.addLine("if (u3!=null) {");
    builder.addLine("u2=u3.indexOf('ï¿½');");
    builder.addLine("if (u2>=0)");
    builder.addLine("u3=u3.substring(0,u2);");
    builder.addLine("u2=u3.indexOf('\\n');");
    builder.addLine("if (u2>=0)");
    builder.addLine("u3=u3.substring(0,u2);");
    builder.addLine("u3=u3.toLowerCase().trim();");
    builder.addLine("if (u3.length>20)");
    builder.addLine("u3=u3.substring(0,20);");
    builder.addLine("}");
    builder.addLine("r1=u3;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(s4,r1))");
    builder.addLine("E2=1.0;");
    builder.addLine("if (r1==null&&s4==null)");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(s4,r1))");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("let compareValues=true;");
    builder.addLine("if (r1==null) {");
    builder.addLine("if (s4!=null)");
    builder.addLine("continue;");
    builder.addLine("else{");
    builder.addLine("w0=1.0;");
    builder.addLine("compareValues=false;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (compareValues&&f3(s4,");
    builder.addLine("r1))");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("else if (s0=='phash') {");
    builder.addLine("r1=s4;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(s4,r1))");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("f3(s4,r1))");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (f3(s4,r1))");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("else if (s0=='src') {");
    builder.addLine("r1=t4.getAttribute(s0);");
    builder.addLine("let v0=false;");
    builder.addLine("while (true) {");
    builder.addLine("let q8;");
    builder.addLine("let q9;");
    builder.addLine("let r0;");
    builder.addLine("let s6;");
    builder.addLine("if (r1==null)");
    builder.addLine("break;");
    builder.addLine("q8=r1.indexOf('http');");
    builder.addLine("if (q8<0)");
    builder.addLine("break;");
    builder.addLine("r0=i7(r1);");
    builder.addLine("q9=g0(r0);");
    builder.addLine("h0(r0);");
    builder.addLine("if (q9==null) {");
    builder.addLine("j6(r0);");
    builder.addLine("h0(r0);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (s5.hasOwnProperty('phash') ==false)");
    builder.addLine("break;");
    builder.addLine("let s7=s5['phash'];");
    builder.addLine("s6=h3(s7,");
    builder.addLine("q9);");
    builder.addLine("v0=true;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&s6>=0.10)) {");
    builder.addLine("b3=`Node identifier-key (perceptual hash) actual (${q9}) expected (${s7})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (perceptual hash) comparison value (${s6})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s7;");
    builder.addLine("r8.actualvalue=q9;");
    builder.addLine("r8.matchvalue=s6;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (s6<0.10) {");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (v0==false) {");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (s4==r1)");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else if (s0=='style') {");
    builder.addLine("r1=t4.getAttribute(s0);");
    builder.addLine("let v0=false;");
    builder.addLine("while (true) {");
    builder.addLine("let q8;");
    builder.addLine("let q9;");
    builder.addLine("let r0;");
    builder.addLine("let s6;");
    builder.addLine("if (r1==null)");
    builder.addLine("break;");
    builder.addLine("q8=r1.indexOf('background-image');");
    builder.addLine("if (q8<0)");
    builder.addLine("break;");
    builder.addLine("q8=r1.indexOf('url(\"http');");
    builder.addLine("if (q8<0)");
    builder.addLine("break;");
    builder.addLine("r0=r1.substr(q8+5);");
    builder.addLine("q8=r0.indexOf('\")');");
    builder.addLine("if (q8<0)");
    builder.addLine("break");
    builder.addLine("r0=r0.substring(0,q8);");
    builder.addLine("r0=i7(r0);");
    builder.addLine("q9=g0(r0);");
    builder.addLine("h0(r0);");
    builder.addLine("if (q9==null) {");
    builder.addLine("j6(r0);");
    builder.addLine("h0(r0);");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (s5.hasOwnProperty('phash') ==false)");
    builder.addLine("break;");
    builder.addLine("let s7=s5['phash'];");
    builder.addLine("s6=h3(s7,");
    builder.addLine("q9);");
    builder.addLine("v0=true;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&s6>=0.10)) {");
    builder.addLine("b3=`Node identifier-key (perceptual hash) actual (${q9}) expected (${s7})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (perceptual hash) comparison value (${s6})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s7;");
    builder.addLine("r8.actualvalue=q9;");
    builder.addLine("r8.matchvalue=s6;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (s6<0.10) {");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("if (v0==false) {");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (s4==r1)");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("r1=t4.getAttribute(s0);");
    builder.addLine("if (s0=='href'&&");
    builder.addLine("r1!=null)");
    builder.addLine("r1=i6(r1);");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("u1==h9.error) {");
    builder.addLine("let b3;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("if (u1==h9.all||");
    builder.addLine("(u1==h9.error&&E2!=1.0)) {");
    builder.addLine("b3=`Node identifier-key (${s0}) actual (${r1}) expected (${s4})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("b3=`Node identifier-key (${s0}) comparison value (${E2})`;");
    builder.addLine("e0('Trace','NodeIden',41,b3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("if (y9) {");
    builder.addLine("r8.type=s0;");
    builder.addLine("r8.attributevalue=s4;");
    builder.addLine("r8.actualvalue=r1;");
    builder.addLine("let E2=0.0;");
    builder.addLine("if (r1!=null&&");
    builder.addLine("s4==r1)");
    builder.addLine("E2=1.0;");
    builder.addLine("r8.matchvalue=E2;");
    builder.addLine("r9.push(r8);");
    builder.addLine("}");
    builder.addLine("if (r1==null)");
    builder.addLine("continue;");
    builder.addLine("if (s4==r1)");
    builder.addLine("w0=1.0;");
    builder.addLine("}");
    builder.addLine("v9+=w0;");
    builder.addLine("}");
    builder.addLine("if (y9)");
    builder.addLine("z0[y8]=r9;");
    builder.addLine("return v9/S;");
    builder.addLine("}");
    builder.addLine("function f9(u5,c0) {");
    builder.addLine("let x1=[];");
    builder.addLine("let u7=u5.length;");
    builder.addLine("for (let i=0;i<u7;i++) {");
    builder.addLine("let K=u5[i];");
    builder.addLine("let v5=K.constructor.name;");
    builder.addLine("if (typeof K.getElementById==='function'&&");
    builder.addLine("c0.attributeName==='id'&&");
    builder.addLine("c0.attributeValue!=='') {");
    builder.addLine("let p3=K.getElementById(c0.attributeValue);");
    builder.addLine("if (p3!==null) {");
    builder.addLine("if (c0.tag!=='') {");
    builder.addLine("if (c0.tag.toUpperCase() ===p3.tagName.toUpperCase())");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("else");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("continue;");
    builder.addLine("}");
    builder.addLine("if (typeof K.getElementByClassName==='function'&&");
    builder.addLine("c0.attributeName==='class'&&");
    builder.addLine("c0.attributeValue!=='') {");
    builder.addLine("let p4=K.getElementByClassName(c0.attributeValue);");
    builder.addLine("let p6=p4.length;");
    builder.addLine("for (let i=0;i<p6;i++) {");
    builder.addLine("p3=p4[i];");
    builder.addLine("if (c0.tag!=='') {");
    builder.addLine("if (c0.tag.toUpperCase() ===p3.tagName.toUpperCase())");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("else");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("continue;");
    builder.addLine("}");
    builder.addLine("if (typeof K.getElementsByTagName==='function'&&");
    builder.addLine("c0.tag!=='') {");
    builder.addLine("let p8=K.getElementsByTagName(c0.tag);");
    builder.addLine("let q0=p8.length;");
    builder.addLine("if (c0.attributeName!==''&&");
    builder.addLine("c0.attributeValue!=='') {");
    builder.addLine("for (let i=0;i<q0;i++) {");
    builder.addLine("let p3=p8[i];");
    builder.addLine("if (!p3.hasAttribute(c0.attributeName))");
    builder.addLine("continue;");
    builder.addLine("if (p3.getAttribute(c0.attributeName) !==c0.attributeValue)");
    builder.addLine("continue;");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("for (let i=0;i<q0;i++) {");
    builder.addLine("let p3=p8[i];");
    builder.addLine("x1.push(p3);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("continue;");
    builder.addLine("}");
    builder.addLine("let A=K.childNodes;");
    builder.addLine("let B=A.length;");
    builder.addLine("for (let i=0;i<B;i++) {");
    builder.addLine("let z=A[i];");
    builder.addLine("if (typeof z.hasAttribute!=='function')");
    builder.addLine("continue;");
    builder.addLine("if (typeof z.getAttribute!=='function')");
    builder.addLine("continue;");
    builder.addLine("if (!z.hasAttribute(c0.attributeName))");
    builder.addLine("continue;");
    builder.addLine("if (z.getAttribute(c0.attributeName) !==c0.attributeValue)");
    builder.addLine("continue;");
    builder.addLine("x1.push(z);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("return x1;");
    builder.addLine("}");
    builder.addLine("function g0(E9) {");
    builder.addLine("let F1=E9.replace(/\\+/g,' ');");
    builder.addLine("if (i5.hasOwnProperty(F1))");
    builder.addLine("return i5[F1];");
    builder.addLine("return null;");
    builder.addLine("}");
    builder.addLine("function g1(w1) {");
    builder.addLine("let A3=new Set();");
    builder.addLine("while (w1) {");
    builder.addLine("Object.getOwnPropertyNames(w1).forEach(p=>A3.add(p));");
    builder.addLine("w1=Object.getPrototypeOf(w1);");
    builder.addLine("}");
    builder.addLine("return[...A3];");
    builder.addLine("}");
    builder.addLine("function g3(Z,A0) {");
    builder.addLine("let c4=Z;");
    builder.addLine("let b9=null;");
    builder.addLine("while (Z!=null) {");
    builder.addLine("let w=window.getComputedStyle(Z);");
    builder.addLine("if (w==null)");
    builder.addLine("break;");
    builder.addLine("let p=w['background-image'];");
    builder.addLine("let q=typeof p;");
    builder.addLine("if (p==null||p=='none'||q!='string'||p.indexOf('url(') <0) {");
    builder.addLine("Z=Z.parentElement;");
    builder.addLine("continue;");
    builder.addLine("}");
    builder.addLine("let o=p.lastIndexOf('/');");
    builder.addLine("if (o>0)");
    builder.addLine("b9=p.substring(0,o+1) +A0+'\")';");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("return b9;");
    builder.addLine("}");
    builder.addLine("function g4(w1,w2,hostName,pathName,sessionId) {");
    builder.addLine("let w3=g1(w1);");
    builder.addLine("let rv='{\"b7\":\"'+w2+'\"'+',\"hostName\":\"'+hostName+'\"'+',\"pathName\":\"'+pathName+'\"';");
    builder.addLine("rv+=',\"sessionId\":\"'+sessionId+'\"';");
    builder.addLine("w3.forEach(prop=>{");
    builder.addLine("let w4=w1[prop];");
    builder.addLine("let E3=typeof w4;");
    builder.addLine("let z7=true;");
    builder.addLine("if (E3=='v8'||");
    builder.addLine("E3=='boolean'||");
    builder.addLine("w4==null)");
    builder.addLine("z7=false;");
    builder.addLine("if (E3=='string') {");
    builder.addLine("let l7=w4.length;");
    builder.addLine("if (l7>=2) {");
    builder.addLine("let w5=w4.charAt(0);");
    builder.addLine("let w6=w4.charAt(l7-1);");
    builder.addLine("if (w5=='{'&&w6=='}') {");
    builder.addLine("z7=false;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("let w7=rv.length;");
    builder.addLine("try{");
    builder.addLine("rv+=',\"'+prop+'\":';");
    builder.addLine("if (z7)");
    builder.addLine("rv+='\"';");
    builder.addLine("rv+=w4;");
    builder.addLine("if (z7)");
    builder.addLine("rv+='\"';");
    builder.addLine("}");
    builder.addLine("catch (b1) {");
    builder.addLine("rv=rv.substring(0,w7);");
    builder.addLine("}");
    builder.addLine("});");
    builder.addLine("rv+='}';");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("function g5(link,hostName,pathName,sessionId) {");
    builder.addLine("let rv='{\"link\":\"'+link+'\"'+',\"hostName\":\"'+hostName+'\"'+',\"pathName\":\"'+pathName+'\"';");
    builder.addLine("rv+=',\"sessionId\":\"'+sessionId+'\"';");
    builder.addLine("rv+='}';");
    builder.addLine("return rv;");
    builder.addLine("}");
    builder.addLine("function g8(w1) {");
    builder.addLine("let A3=w1.constructor.name;");
    builder.addLine("return A3;");
    builder.addLine("}");
    builder.addLine("function h1(K,n2,z8) {");
    builder.addLine("let g='hdlmupdated'+n2;");
    builder.addLine("if (K.hasAttribute(g) ==false) {");
    builder.addLine("return 0;");
    builder.addLine("}");
    builder.addLine("let L=K.getAttribute(g);");
    builder.addLine("return L;");
    builder.addLine("}");
    builder.addLine("function h2(c8,B6) {");
    builder.addLine("let F7=c8^B6;");
    builder.addLine("let U=0;");
    builder.addLine("while (F7>0) {");
    builder.addLine("F7&=F7-1;");
    builder.addLine("U++;");
    builder.addLine("}");
    builder.addLine("return U;");
    builder.addLine("};");
    builder.addLine("function h3(c8,B6) {");
    builder.addLine("let W=h4(c8,B6);");
    builder.addLine("return W/(4.0*c8.length);");
    builder.addLine("};");
    builder.addLine("function h4(c8,B6) {");
    builder.addLine("let V=0;");
    builder.addLine("let c7,B5;");
    builder.addLine("while (c8.length>0) {");
    builder.addLine("if (c8.length>8) {");
    builder.addLine("c7=c8.substr(0,8);");
    builder.addLine("c8=c8.substr(8);");
    builder.addLine("B5=B6.substr(0,8);");
    builder.addLine("B6=B6.substr(8);");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("c7=c8;");
    builder.addLine("c8='';");
    builder.addLine("B5=B6;");
    builder.addLine("B6='';");
    builder.addLine("}");
    builder.addLine("let c5=parseInt(c7,16);");
    builder.addLine("let B3=parseInt(B5,16);");
    builder.addLine("V+=h2(c5,B3);");
    builder.addLine("}");
    builder.addLine("return V;");
    builder.addLine("};");
    builder.addLine("function h5(F4,z0,D5,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D,");
    builder.addLine("y7,handlingARealMod) {");
    builder.addLine("let x=false;");
    builder.addLine("let E4='HDLmUpdateCount'+D.name;");
    builder.addLine("if (isNaN(window[E4]))");
    builder.addLine("window[E4]=0;");
    builder.addLine("else");
    builder.addLine("if (window[E4]>0)");
    builder.addLine("x=true;");
    builder.addLine("if (x||D5)");
    builder.addLine("return x;");
    builder.addLine("window[E4]+=1;");
    builder.addLine("let m4=new Object();");
    builder.addLine("let w8=null;");
    builder.addLine("let q3=null;");
    builder.addLine("if ((typeof F4) !='undefined'&&");
    builder.addLine("F4!=null&&");
    builder.addLine("F4!='')");
    builder.addLine("w8=F4;");
    builder.addLine("j0(m4,sessionIndexValueUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("x5,m9,");
    builder.addLine("k3,Y,C4,D.name,");
    builder.addLine("D.path,D.type,y7,");
    builder.addLine("w8,q3);");
    builder.addLine("let m3=D.type;");
    builder.addLine("if (handlingARealMod)");
    builder.addLine("z0.matchError='Fired';");
    builder.addLine("else");
    builder.addLine("z0.matchError='visit';");
    builder.addLine("j7(m4,m3,'1.0',z0);");
    builder.addLine("return x;");
    builder.addLine("}");
    builder.addLine("function h6(K,n2) {");
    builder.addLine("let g='hdlmupdated'+n2;");
    builder.addLine("if (K.hasAttribute(g) ==false) {");
    builder.addLine("K.setAttribute(g,1);");
    builder.addLine("return 1;");
    builder.addLine("}");
    builder.addLine("let L=K.getAttribute(g);");
    builder.addLine("L++;");
    builder.addLine("K.setAttribute(g,L);");
    builder.addLine("return L;");
    builder.addLine("}");
    builder.addLine("function h8(B1) {");
    builder.addLine("let B0=JSON.parse(B1);");
    builder.addLine("let A7=B0.attributes;");
    builder.addLine("if (A7.hasOwnProperty('innertext')) {");
    builder.addLine("let A9=A7.innertext;");
    builder.addLine("let A8=A9.indexOf('$');");
    builder.addLine("if (A8>=0) {");
    builder.addLine("delete A7['innertext'];");
    builder.addLine("B0['attributes']=A7;");
    builder.addLine("};");
    builder.addLine("B1=JSON.stringify(B0);");
    builder.addLine("}");
    builder.addLine("return B1;");
    builder.addLine("}");
    builder.addLine("function i4(B2) {");
    builder.addLine("let D8=null;");
    builder.addLine("let l9={};");
    builder.addLine("if (B2.length>0&&B2.charAt(0) =='/') {");
    builder.addLine("l9.cssselector='';");
    builder.addLine("l9.nodeiden=null;");
    builder.addLine("l9.xpath=B2;");
    builder.addLine("}");
    builder.addLine("else if (B2.length>0&&B2.charAt(0) =='{') {");
    builder.addLine("l9.cssselector='';");
    builder.addLine("l9.nodeiden=JSON.parse(B2);");
    builder.addLine("l9.xpath=\"\";");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("l9.cssselector=B2;");
    builder.addLine("l9.nodeiden=null;");
    builder.addLine("l9.xpath='';");
    builder.addLine("}");
    builder.addLine("let m1=f5(l9,false,null,null);");
    builder.addLine("let m2=m1.length;");
    builder.addLine("for (let i=0;i<m2;i++) {");
    builder.addLine("let m0=m1[i];");
    builder.addLine("D8=m0.textContent;");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("return D8;");
    builder.addLine("}");
    builder.addLine("function i6(E9) {");
    builder.addLine("let F0=E9.indexOf(':');");
    builder.addLine("if (F0<0||");
    builder.addLine("F0>6)");
    builder.addLine("return E9;");
    builder.addLine("let E8=new URL(E9);");
    builder.addLine("return E9.substring(E8.origin.length);");
    builder.addLine("}");
    builder.addLine("function i7(E9) {");
    builder.addLine("let E7=E9.indexOf(':');");
    builder.addLine("if (E7<0)");
    builder.addLine("return E9;");
    builder.addLine("return E9.substring(E7+1);");
    builder.addLine("}");
    builder.addLine("function i8(k6) {");
    builder.addLine("k6=k6.replace(/A/g,'\u0e81');");
    builder.addLine("k6=k6.replace(/B/g,'\u0e82');");
    builder.addLine("k6=k6.replace(/C/g,'\u0e84');");
    builder.addLine("k6=k6.replace(/D/g,'\u0e87');");
    builder.addLine("k6=k6.replace(/E/g,'\u0e88');");
    builder.addLine("k6=k6.replace(/F/g,'\u0e8a');");
    builder.addLine("k6=k6.replace(/G/g,'\u0e8d');");
    builder.addLine("k6=k6.replace(/H/g,'\u0e94');");
    builder.addLine("k6=k6.replace(/I/g,'\u0e97');");
    builder.addLine("k6=k6.replace(/J/g,'\u0e99');");
    builder.addLine("k6=k6.replace(/K/g,'\u0e9f');");
    builder.addLine("k6=k6.replace(/L/g,'\u0ea1');");
    builder.addLine("k6=k6.replace(/M/g,'\u0ea3');");
    builder.addLine("k6=k6.replace(/N/g,'\u0ea5');");
    builder.addLine("k6=k6.replace(/O/g,'\u0ea7');");
    builder.addLine("k6=k6.replace(/P/g,'\u0eaa');");
    builder.addLine("k6=k6.replace(/Q/g,'\u0eab');");
    builder.addLine("k6=k6.replace(/R/g,'\u0ead');");
    builder.addLine("k6=k6.replace(/S/g,'\u0eb9');");
    builder.addLine("k6=k6.replace(/T/g,'\u0ebb');");
    builder.addLine("k6=k6.replace(/U/g,'\u0ebd');");
    builder.addLine("k6=k6.replace(/V/g,'\u0ec0');");
    builder.addLine("k6=k6.replace(/W/g,'\u0ec4');");
    builder.addLine("k6=k6.replace(/X/g,'\u0ec6');");
    builder.addLine("k6=k6.replace(/Y/g,'\u0ec8');");
    builder.addLine("k6=k6.replace(/Z/g,'\u0ecd');");
    builder.addLine("k6=k6.replace(/\\s/g,'\u0ed0');");
    builder.addLine("k6=k6.replace(/\\$/g,'\u0ed1');");
    builder.addLine("k6=k6.replace(/\\./g,'\u0ed2');");
    builder.addLine("k6=k6.replace(/\\//g,'\u0ed3');");
    builder.addLine("k6=k6.replace(/\\(/g,'\u0ed4');");
    builder.addLine("k6=k6.replace(/\\)/g,'\u0ed5');");
    builder.addLine("return k6;");
    builder.addLine("}");
    builder.addLine("function i9(E0,T) {");
    builder.addLine("var C7=document.styleSheets;");
    builder.addLine("for (let i=0;i<C7.length;i++) {");
    builder.addLine("var C6=C7[i];");
    builder.addLine("if (C6.title!=null&&");
    builder.addLine("C6.title==E0) {");
    builder.addLine("C6.disabled=T;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("function j0(A6,indexUsed,");
    builder.addLine("sessionIndexValue,x7,C0,");
    builder.addLine("y1,m9,");
    builder.addLine("k3,Y,C4,n8,");
    builder.addLine("n9,o2,");
    builder.addLine("y6,x0,q7) {");
    builder.addLine("let E5={};");
    builder.addLine("E5.indexValue=sessionIndexValue;");
    builder.addLine("E5.indexUsed=indexUsed;");
    builder.addLine("E5.parameters=d9(x7,' ');");
    builder.addLine("E5.sessionId=C0;");
    builder.addLine("E5.parmNumber=y1;");
    builder.addLine("E5.lookupValue=m9;");
    builder.addLine("E5.hostName=k3;");
    builder.addLine("E5.divisionName=Y;");
    builder.addLine("E5.siteName=C4;");
    builder.addLine("E5.modName=n8;");
    builder.addLine("E5.modPathValue=n9;");
    builder.addLine("E5.modType=o2;");
    builder.addLine("E5.pathValue=y6;");
    builder.addLine("E5.oldValue=x0;");
    builder.addLine("E5.newValue=q7;");
    builder.addLine("if (!A6.hasOwnProperty('updates'))");
    builder.addLine("A6.updates=[];");
    builder.addLine("A6.updates.push(E5);");
    builder.addLine("}");
    builder.addLine("function j8(k9) {");
    builder.addLine("k9=k9.trim();");
    builder.addLine("k9=k9.toLowerCase();");
    builder.addLine("k9=k9.replace(/\\s+/g,' ');");
    builder.addLine("let C5;");
    builder.addLine("if (k9.indexOf(';') >=0)");
    builder.addLine("C5=';'");
    builder.addLine("else");
    builder.addLine("C5=' ';");
    builder.addLine("let k7=k9.split(C5);");
    builder.addLine("for (let i in k7) {");
    builder.addLine("let C9=k7[i];");
    builder.addLine("if (C5==';')");
    builder.addLine("C9=C9.trim();");
    builder.addLine("if (C9=='unchanged'||");
    builder.addLine("C9=='novalue'||");
    builder.addLine("C9=='none'||");
    builder.addLine("C9.trim().length==0) {");
    builder.addLine("C9='none';");
    builder.addLine("k7[i]=C9;");
    builder.addLine("}");
    builder.addLine("if (Number.isInteger(Number(C9)) ==true) {");
    builder.addLine("C9+='px';");
    builder.addLine("k7[i]=C9;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("return k7;");
    builder.addLine("}");
    builder.addLine("function j9(k8) {");
    builder.addLine("k8=k8.trim();");
    builder.addLine("k8=k8.toLowerCase();");
    builder.addLine("k8=k8.replace(/\\s+/g,' ');");
    builder.addLine("let k7=k8.split(' ');");
    builder.addLine("return k7;");
    builder.addLine("}");
    builder.addLine("function k0() {");
    builder.addLine("var T;");
    builder.addLine("var E0='HDLmSessionClasses';");
    builder.addLine("T=sessionStorage.getItem(E0+'Disabled');");
    builder.addLine("if (T==null)");
    builder.addLine("T='true';");
    builder.addLine("T= (T=='true') ?false:true;");
    builder.addLine("sessionStorage.setItem(E0+'Disabled',T);");
    builder.addLine("i9(E0,T);");
    builder.addLine("}");
    builder.addLine("function k1(l3,l5,F3) {");
    builder.addLine("if (l3==null)");
    builder.addLine("l3='{}';");
    builder.addLine("let l2=JSON.parse(l3);");
    builder.addLine("l2[l5]=F3;");
    builder.addLine("l3=JSON.stringify(l2);");
    builder.addLine("return l3;");
    builder.addLine("}");
    builder.addLine("function d8(z8,h7) {");
    builder.addLine("let y7=document.location.pathname;");
    builder.addLine("const o0=[");
    int         counter;
    int         modsCount=mods.size();
    String      newLine;
    counter=0;
    for (HDLmMod mod:mods) {
      counter++;
      newLine="".repeat(24);
      newLine+=mod.getJsonSpecialSerializeNulls();
      if (counter<modsCount)
        newLine+=",";
      builder.addLine(newLine);
}
    String  m6;
    if (m5==HDLmLogMatchingTypes.LOGMATCHINGYES)
      m6="true";
    else
      m6="false";
    Double   arrayEntry;
    String   d3=HDLmDefines.getString("HDLMFORCEVALUE");
    builder.addLine("];");
    builder.addLine("const C0='"+B9+"';");
    builder.addLine("const x7=g9();");
    builder.addLine("let o1=o0.length;");
    builder.addLine("for (let i=0;i<o1;i++) {");
    builder.addLine("let D=o0[i];");
    builder.addLine("try{");
    builder.addLine("switch (D.type) {");
    builder.addLine("case'extract':{");
    builder.addLine("let u5=f5(D,false);");
    builder.addLine("let u6=u5.length;");
    builder.addLine("for (let j=0;j<u6;j++) {");
    builder.addLine("let K=u5[j];");
    builder.addLine("if (j2.hasOwnProperty(D.name) &&");
    builder.addLine("j2[D.name]!=null)");
    builder.addLine("continue;");
    builder.addLine("let w8=K.textContent;");
    builder.addLine("j2[D.name]=w8;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("case'notify':{");
    builder.addLine("for (let j=0;j<D.valuesCount;j++) {");
    builder.addLine("let B1=D.values[j];");
    builder.addLine("B1=h8(B1);");
    builder.addLine("if (j3.hasOwnProperty(B1) &&");
    builder.addLine("j3[B1]!=null)");
    builder.addLine("continue;");
    builder.addLine("let B2=i4(B1);");
    builder.addLine("j3[B1]=B2;");
    builder.addLine("}");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("default:{");
    builder.addLine("break;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("catch (b1) {");
    builder.addLine("console.log(b1);");
    builder.addLine("let b2=f4(b1);");
    builder.addLine("let o4=D.name;");
    builder.addLine("let C3='"+siteName+"';");
    builder.addLine("let X='"+divisionName+"';");
    builder.addLine("let k2='"+hostName+"';");
    builder.addLine("let r='Modification ('+o4+') Host ('+k2+') Error ('+b2+')';");
    builder.addLine("console.log(r);");
    builder.addLine("b2=k1(b2,'modification',o4);");
    builder.addLine("b2=k1(b2,'siteName',C3);");
    builder.addLine("b2=k1(b2,'divisionName',X);");
    builder.addLine("b2=k1(b2,'hostName',k2);");
    builder.addLine("b2=k1(b2,'sessionId',C0);");
    builder.addLine("j5(b2);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("for (let i=0;i<o1;i++) {");
    builder.addLine("let D=o0[i];");
    builder.addLine("try{");
    builder.addLine("let handlingARealMod=true;");
    builder.addLine("d7(y7,");
    builder.addLine("D,");
    builder.addLine("C0,");
    builder.addLine("h7,");
    builder.addLine("x7,");
    builder.addLine("'"+hostName+"',");
    builder.addLine("'"+hostName+"',");
    builder.addLine("'"+divisionName+"',");
    builder.addLine("'"+siteName+"',");
    if (B7!=null)
      builder.addLine("'"+B7+"',");
    else
      builder.addLine("null,");
    builder.addLine("'"+d3+"',");
    builder.addLine(""+m6+",");
    builder.addLine("z8,");
    builder.addLine("handlingARealMod);");
    builder.addLine("}");
    builder.addLine("catch (b1) {");
    builder.addLine("console.log(b1);");
    builder.addLine("let b2=f4(b1);");
    builder.addLine("let o4=D.name;");
    builder.addLine("let C3='"+siteName+"';");
    builder.addLine("let X='"+divisionName+"';");
    builder.addLine("let k2='"+hostName+"';");
    builder.addLine("let r='Modification ('+o4+') Host ('+k2+') Error ('+b2+')';");
    builder.addLine("console.log(r);");
    builder.addLine("b2=k1(b2,'modification',o4);");
    builder.addLine("b2=k1(b2,'siteName',C3);");
    builder.addLine("b2=k1(b2,'divisionName',X);");
    builder.addLine("b2=k1(b2,'hostName',k2);");
    builder.addLine("b2=k1(b2,'sessionId',C0);");
    builder.addLine("j5(b2);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("function e0(b4,P,b0,b5) {");
    builder.addLine("let b2='';");
    builder.addLine("b2+='"+HDLmDefines.getString("HDLMPREFIX") +"'+' ';");
    builder.addLine("b2+=b4+' ';");
    builder.addLine("b2+=P+' ';");
    builder.addLine("b2+=b0.toString() +' ';");
    builder.addLine("b2+=b5;");
    builder.addLine("console.log(b2);");
    builder.addLine("}");
    builder.addLine("function e5(K,l4) {");
    builder.addLine("let t=JSON.parse(l4);");
    builder.addLine("for (const l6 in t) {");
    builder.addLine("if (!t.hasOwnProperty(l6))");
    builder.addLine("continue;");
    builder.addLine("let v=t[l6];");
    builder.addLine("if (v==null)");
    builder.addLine("K.removeAttribute(l6);");
    builder.addLine("else{");
    builder.addLine("if (l6=='class') {");
    builder.addLine("f1(K,v);");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("K.setAttribute(l6,v);");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("function HDLmFixImageUrl(E9) {");
    builder.addLine("if (E9.startsWith('data')) {");
    builder.addLine("return E9;");
    builder.addLine("}");
    builder.addLine("if (E9.startsWith('//')) {");
    builder.addLine("return E9;");
    builder.addLine("}");
    builder.addLine("if (E9.startsWith('/') ==false) {");
    builder.addLine("E9='/'+E9;");
    builder.addLine("}");
    builder.addLine("if (E9.startsWith('//') ==false) {");
    builder.addLine("E9='//'+window.location.host+E9;");
    builder.addLine("}");
    builder.addLine("return E9;");
    builder.addLine("}");
    for (HDLmMod mod:mods) {
    	if (mod.getType() !=HDLmModTypes.SCRIPT)
        continue;
    	String  p2=HDLmMod.replaceInString(mod.getName());
        int   valueCount=mod.getValues().size();
        for (int i=0;i<valueCount;i++) {
          String  Q=mod.getValues().get(i);
          newLine="function HDLmExecute"+p2+i+"() {";
          builder.addLine(newLine);
          ArrayList<String>curValues=new ArrayList<String>(Arrays.asList(Q.split("/n")));
          for (int j=0;j<curValues.size();j++) {
            String  curLine=curValues.get(j);
            builder.addLine(""+curLine);
}
          newLine="}";
          builder.addLine(newLine);
}
}
    builder.addLine("function g2(K) {");
    builder.addLine("let x3='';");
    builder.addLine("if (!K.hasAttributes())");
    builder.addLine("return x3;");
    builder.addLine("let m=K.attributes;");
    builder.addLine("let n=m.length;");
    builder.addLine("for (let i=n-1;i>=0;i--) {");
    builder.addLine("if (x3!='')");
    builder.addLine("x3+=' ';");
    builder.addLine("x3+=m[i].name+'='+\"'\"+m[i].value+\"'\";");
    builder.addLine("}");
    builder.addLine("return x3;");
    builder.addLine("}");
    builder.addLine("function g6(A5) {");
    builder.addLine("let m7={");
    JsonArray   indexJsonArray=getIndexJsonArray();
		if (!indexJsonArray.isJsonArray()) {
	 	  String  b3="JSON array in getJSBuildJs is invalid";
	 	  HDLmAssert.HDLmAssertAction(false,b3);
}
    int   indexJsonArraySize=indexJsonArray.size();
    boolean   logIsDebugEnabled=LOG.isDebugEnabled();
		if (logIsDebugEnabled) {
		  LOG.debug("In g6");
		  LOG.debug(C2);
}
    double  sessionIndexValue=0.0;
    if (C2!=null&&
!C2.equals("null"))
    	sessionIndexValue=Double.parseDouble(C2);
    for (int i=0;i<indexJsonArraySize;i++) {
    	JsonElement   indexJsonElement=indexJsonArray.get(i);
    	String  jsonHostName=HDLmJson.getJsonString(indexJsonElement,"website");
    	if (hostName.equals(jsonHostName)) {
    		JsonArray   rulesJsonArray=HDLmJson.getJsonArray(indexJsonElement,"rules");
    		JsonArray   choicesJsonArray=HDLmJson.getJsonArray(indexJsonElement,"choices");
    		if (!rulesJsonArray.isJsonArray()) {
    	 	  String  b3="JSON array in getJSBuildJs is invalid";
    	 	  HDLmAssert.HDLmAssertAction(false,b3);
}
    		if (!choicesJsonArray.isJsonArray()) {
    	 	  String  b3="JSON array in getJSBuildJs is invalid";
    	 	  HDLmAssert.HDLmAssertAction(false,b3);
}
    		int         rulesJsonArraySize=rulesJsonArray.size();
    		int         choicesJsonArraySize=choicesJsonArray.size();
    		JsonArray   choiceJsonArray=null;
        if (C2!=null&&
!C2.equals("null")) {
         	double      indexValue=sessionIndexValue*choicesJsonArraySize;
        	int         indexValueInt= (int) Math.floor(indexValue);
        	choiceJsonArray= (JsonArray) choicesJsonArray.get(indexValueInt);
      		if (!choiceJsonArray.isJsonArray()) {
      	 	  String  b3="JSON array in getJSBuildJs is invalid";
      	 	  HDLmAssert.HDLmAssertAction(false,b3);
}
}
    		counter=0;
        for (int j=0;j<rulesJsonArraySize;j++) {
        	counter++;
        	JsonElement   ruleJsonElement=rulesJsonArray.get(j);
      		if (!ruleJsonElement.isJsonPrimitive()) {
      			HDLmAssert.HDLmAssertAction(false,"JSON element is not a JSON primitive value");
}
        	String        A5=ruleJsonElement.getAsString();
          newLine="".repeat(23);
          newLine+="'";
          newLine+=A5;
          newLine+="':";
          if (C2==null||
          		C2.equals("null"))
          	newLine+="null";
          else{
            JsonElement   choiceJsonElement=choiceJsonArray.get(j);
        		if (!choiceJsonElement.isJsonPrimitive()) {
        			HDLmAssert.HDLmAssertAction(false,"JSON element is not a JSON primitive value");
}
            String  choiceJsonString=choiceJsonElement.getAsString();
            newLine+=choiceJsonString;
}
          if (counter<rulesJsonArraySize)
            newLine+=",";
          builder.addLine(newLine);
}
}
}
    builder.addLine("};");
    builder.addLine("let m8=m7[A5];");
    builder.addLine("return m8;");
    builder.addLine("}");
    builder.addLine("function g9() {");
    builder.addLine("let x3='';");
    builder.addLine("const x7=[");
    counter=0;
    int   sessionParametersArrayLength=sessionParametersArray.size();
    for (int i=0;i<sessionParametersArrayLength;i++) {
      counter++;
      newLine="".repeat(30);
      arrayEntry=sessionParametersArray.get(i);
      if (arrayEntry==null)
        newLine+="null";
      else
        newLine+=arrayEntry;
      if (counter<sessionParametersArrayLength)
        newLine+=",";
      builder.addLine(newLine);
}
    builder.addLine("];");
    builder.addLine("return x7;");
    builder.addLine("}");
    builder.addLine("async function h0(E9) {");
    builder.addLine("let outputText='';");
    builder.addLine("E9=HDLmFixImageUrl(E9);");
    builder.addLine("outputText=await HDLmGetPHashLow(E9);");
    builder.addLine("return outputText;");
    builder.addLine("}");
    builder.addLine("async function HDLmGetPHashLow(E9) {");
    String   protocolStringGetPHashLow;
    protocolStringGetPHashLow=protocol.toString().toLowerCase();
    String  y6;
    y6=HDLmDefines.getString("HDLMGETPHVALUE");
    builder.addLine("let outputText='';");
    builder.addLine("try{");
    builder.addLine("let serverNameValue='"+serverName+"';");
    builder.addLine("let F2='"+protocolStringGetPHashLow+"'+'://'+serverNameValue+'/'+'"+y6+"';");
    builder.addLine("F2+='?image='+encodeURIComponent(E9);");
    builder.addLine("const response=await fetch(F2);");
    builder.addLine("if (response.ok!=true) {");
    builder.addLine("let b3=`HTTP(S) error-Status:${response.status}`;");
    builder.addLine("e0('Error','Fetch',91,b3);");
    builder.addLine("outputText=null;");
    builder.addLine("}");
    builder.addLine("else{");
    builder.addLine("for await (const chunk of response.body) {");
    builder.addLine("const text=new TextDecoder().decode(chunk);");
    builder.addLine("outputText+=text;");
    builder.addLine("}");
    builder.addLine("}");
    builder.addLine("}catch (b1) {");
    builder.addLine("console.log(b1);");
    builder.addLine("let b3=`HTTP(S) error-Status:${b1.message}`;");
    builder.addLine("e0('Error','Fetch',91,b3);");
    builder.addLine("outputText=null;");
    builder.addLine("}");
    builder.addLine("return outputText;");
    builder.addLine("}");
    builder.addLine("{");
    builder.addLine("let k2=location.hostname;");
    builder.addLine("let l8=location.href;");
    builder.addLine("let y5=document.location.pathname;");
    builder.addLine("let C1='"+B9+"';");
    builder.addLine("let b6=g5(l8,k2,y5,C1)");
    builder.addLine("Object.keys(window).forEach(key=>{");
    builder.addLine("if (key.startsWith('onmouse'))");
    builder.addLine("return;");
    builder.addLine("if (key.startsWith('onpointer'))");
    builder.addLine("return;");
    builder.addLine("if (/^on/.test(key)) {");
    builder.addLine("window.addEventListener(key.slice(2),event=>{");
    builder.addLine("let b7=g8(event);");
    builder.addLine("let b6=g4(event,b7,k2,y5,C1)");
    builder.addLine("});");
    builder.addLine("}");
    builder.addLine("});");
    builder.addLine("};");
    builder.addLine("let j4=new Object();");
    builder.addLine("let j2=new Object();");
    builder.addLine("let j3=new Object();");
    builder.addLine("var e8=true;");
    counter=0;
    builder.addLine("const i5={");
    Map<String,String>mapObj=HDLmPHashCache.getMap();
    long  mapSize=mapObj.size();
		for (Map.Entry<String,String>entry:mapObj.entrySet()) {
	    String  key=entry.getKey();
	    String  value=entry.getValue();
      counter++;
      newLine="".repeat(28);
        newLine+="\"";
        newLine+=key;
        newLine+="\":\"";
        newLine+=value;
        newLine+="\"";
        if (counter<mapSize)
          newLine+=",";
      builder.addLine(newLine);
}
    builder.addLine("};");
    String   z3;
    z3=protocol.toString().toLowerCase();
    builder.addLine("function j5(R) {");
    builder.addLine("R='"+HDLmDefines.getString("HDLMPOSTDATA") +"="+"'+R;");
    builder.addLine("let k4=new XMLHttpRequest();");
    builder.addLine("let serverNameValue='"+serverName+"';");
    builder.addLine("let E9='"+z3+"://'+serverNameValue+'/"+HDLmDefines.getString("HDLMPOSTDATA") +"';");
    builder.addLine("k4.open('POST',E9);");
    builder.addLine("k4.setRequestHeader('Content-type','application/x-www-form-urlencoded');");
    builder.addLine("R=encodeURIComponent(R);");
    builder.addLine("k4.send(R);");
    builder.addLine("}");
    builder.addLine("function j6(E9) {");
    builder.addLine("let F6=new XMLHttpRequest();");
    String   z4;
    z4=protocol.toString().toLowerCase();
    builder.addLine("let serverNameValue='"+serverName+"';");
    builder.addLine("let F2='"+z4+"://'+serverNameValue+'/"+HDLmConfigInfo.getPHashName() +"';");
    builder.addLine("F6.open('POST',F2);");
    builder.addLine("E9=encodeURIComponent(E9);");
    builder.addLine("F6.send(E9);");
    builder.addLine("}");
    builder.addLine("function j7(A6,z9,F5,b2) {");
    builder.addLine("A6.reason=z9;");
    builder.addLine("A6.weight=F5;");
    builder.addLine("A6.error=b2;");
    builder.addLine("let E6=JSON.stringify(A6);");
    builder.addLine("j5(E6);");
    builder.addLine("}");
    if (C2==null||
        C2.equals("null"))
      builder.addLine("let h7=null;");
    else
    	builder.addLine("let h7="+C2+";");
    builder.addLine("f0('.HDLmClassPrimary',"+
                                      "'background-color:yellow');");
    builder.addLine("f0('.HDLmClassBackground',"+
                                      "'filter:grayscale(100%)');");
    builder.addLine("let i3=document;");
    builder.addLine("let i1={attributes:true,childList:true,subtree:true};");
    builder.addLine("let i0=function (o3,i2) {");
    builder.addLine("let d1=false;");
    builder.addLine("if (document.location.hostname=='www.themarvelouslandofoz.com'&&");
    builder.addLine("document.readyState=='interactive')");
    builder.addLine("d1=true;");
    builder.addLine("d8(document.readyState,h7);");
    builder.addLine("if (document.readyState=='complete'||");
    builder.addLine("d1==true) {");
    builder.addLine("d8(document.readyState,h7);");
    builder.addLine("};");
    builder.addLine("};");
    builder.addLine("let i2=new MutationObserver(i0);");
    builder.addLine("i2.observe(i3,i1);");
    builder.addLine("let y7=document.location.pathname;");
    builder.addLine("let D={};");
    String  n6=HDLmDefines.getString("HDLMLOADPAGEMODNAME");
    builder.addLine("D.name='"+n6+"';");
    builder.addLine("D.parameter=-1;");
    builder.addLine("D.path='//.*/';");
    builder.addLine("D.pathre=true;");
    String  n7=HDLmModTypes.VISIT.toString().toLowerCase();
    builder.addLine("D.type='"+n7+"';");
    builder.addLine("D.values=['Yes'];");
    builder.addLine("D.valuesCount=1;");
    builder.addLine("const C0='"+B9+"';");
    builder.addLine("const x7=g9()");
    builder.addLine("const z8='unknown';");
    builder.addLine("let handlingARealMod=false;");
    builder.addLine("d7(y7,");
    builder.addLine("D,");
    builder.addLine("C0,");
    builder.addLine("h7,");
    builder.addLine("x7,");
    builder.addLine("'"+hostName+"',");
    builder.addLine("'"+hostName+"',");
    builder.addLine("'"+divisionName+"',");
    builder.addLine("'"+siteName+"',");
    if (B7!=null)
      builder.addLine("'"+B7+"',");
    else
      builder.addLine("null,");
    builder.addLine("'"+d3+"',");
    builder.addLine("'"+m6+"',");
    builder.addLine("z8,");
    builder.addLine("handlingARealMod);");
    builder.addLine("</script>");
    actualJS=builder.getLinesWithSuffix("\r\n");
		if (useCreateFixedJS) {
		  HDLmUtility.fileClearContents(fixedJSName);
		  int             i;
		  int             actualJSLen;
		  StringBuilder   actualJSAdjustedBuilder=new StringBuilder();
		  actualJSLen=actualJS.length();
		  String  N;
		  for (i=0;i<actualJSLen;i++) {
		  	char  curChar=actualJS.charAt(i);
		  	if (curChar=='\u1000')
		  	  N="\\u1000";
		  	else if (curChar=='\u1001')
	  	    N="\\u1001";
        else if (curChar=='\u1002')
	  	    N="\\u1002";
        else if (curChar=='\u1003')
	  	    N="\\u1003";
        else if (curChar=='\u1004')
	  	    N="\\u1004";
        else if (curChar=='\u1005')
	  	    N="\\u1005";
        else if (curChar=='\u1006')
	  	    N="\\u1006";
        else if (curChar=='\u1007')
	  	    N="\\u1007";
        else if (curChar=='\u1008')
	  	    N="\\u1008";
        else if (curChar=='\u1009')
	  	    N="\\u1009";
        else if (curChar=='\u100a')
	  	    N="\\u100a";
        else if (curChar=='\u100b')
	  	    N="\\u100b";
        else if (curChar=='\u100c')
	  	    N="\\u100c";
        else if (curChar=='\u100d')
	  	    N="\\u100d";
        else if (curChar=='\u100e')
	  	    N="\\u100e";
        else if (curChar=='\u100f')
	  	    N="\\u100f";
        else if (curChar=='\u1010')
	  	    N="\\u1010";
        else if (curChar=='\u1011')
	  	    N="\\u1011";
        else if (curChar=='\u1012')
	  	    N="\\u1012";
        else if (curChar=='\u1013')
	  	    N="\\u1013";
        else if (curChar=='\u1014')
	  	    N="\\u1014";
        else if (curChar=='\u1015')
	  	    N="\\u1015";
        else if (curChar=='\u1016')
	  	    N="\\u1016";
        else if (curChar=='\u1017')
	  	    N="\\u1017";
        else if (curChar=='\u1018')
	  	    N="\\u1018";
        else if (curChar=='\u1019')
	  	    N="\\u1019";
        else if (curChar=='\u101a')
	  	    N="\\u101a";
        else if (curChar=='\u101b')
	  	    N="\\u101b";
        else if (curChar=='\u101c')
	  	    N="\\u101c";
        else if (curChar=='\u101d')
	  	    N="\\u101d";
        else if (curChar=='\u101e')
	  	    N="\\u101e";
        else if (curChar=='\u101f')
	  	    N="\\u101f";
        else if (curChar=='\u1020')
	  	    N="\\u1020";
        else if (curChar=='\u1021')
	  	    N="\\u1021";
        else if (curChar=='\u1022')
	  	    N="\\u1022";
        else if (curChar=='\u1023')
	  	    N="\\u1023";
        else if (curChar=='\u1024')
	  	    N="\\u1024";
        else if (curChar=='\u1025')
	  	    N="\\u1025";
        else if (curChar=='\u1026')
	  	    N="\\u1026";
        else if (curChar=='\u1027')
	  	    N="\\u1027";
        else if (curChar=='\u1028')
	  	    N="\\u1028";
        else if (curChar=='\u1029')
	  	    N="\\u1029";
        else if (curChar=='\u102a')
	  	    N="\\u102a";
        else if (curChar=='\u102b')
	  	    N="\\u102b";
        else if (curChar=='\u102c')
	  	    N="\\u102c";
        else if (curChar=='\u102d')
	  	    N="\\u102d";
        else if (curChar=='\u102e')
	  	    N="\\u102e";
        else if (curChar=='\u102f')
	  	    N="\\u102f";
        else if (curChar=='\u1030')
	  	    N="\\u1030";
        else if (curChar=='\u1031')
	  	    N="\\u1031";
        else if (curChar=='\u1032')
	  	    N="\\u1032";
        else if (curChar=='\u1033')
	  	    N="\\u1033";
        else if (curChar=='\u1034')
	  	    N="\\u1034";
        else if (curChar=='\u1035')
	  	    N="\\u1035";
        else if (curChar=='\u1036')
	  	    N="\\u1036";
        else if (curChar=='\u1037')
	  	    N="\\u1037";
        else if (curChar=='\u1038')
	  	    N="\\u1038";
        else if (curChar=='\u1039')
	  	    N="\\u1039";
		  	else{
			  	N="";
			  	N+=curChar;
}
		  	actualJSAdjustedBuilder.append(N);
}
		  String  actualJSAdjusted=actualJSAdjustedBuilder.toString();
		  HDLmUtility.filePutAppend(fixedJSName,
		  		                      actualJSAdjusted);
}
    return actualJS;
}
  public static JsonArray  getIndexJsonArray() {
    class getIndexJsonArrayLocal{
      final static String  jsonString=
        "["+
        "{"+
        "    \"website\":"+
        "      \"www.yogadirect.com\","+
        "    \"generated\":"+
        "      \"2024-06-13T01:51:52Z\","+
        "    \"rules\":"+
        "["+
        "        \"Change Banner\","+
        "        \"Change Add To Cart\""+
        "],"+
        "    \"choices\":"+
        "["+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5],"+
        "[4,6],"+
        "[5,0],"+
        "[0,1],"+
        "[1,2],"+
        "[2,3],"+
        "[3,4],"+
        "[4,5],"+
        "[5,6],"+
        "[0,0],"+
        "[1,1],"+
        "[2,2],"+
        "[3,3],"+
        "[4,4],"+
        "[5,5],"+
        "[0,6],"+
        "[1,0],"+
        "[2,1],"+
        "[3,2],"+
        "[4,3],"+
        "[5,4],"+
        "[0,5],"+
        "[1,6],"+
        "[2,0],"+
        "[3,1],"+
        "[4,2],"+
        "[5,3],"+
        "[0,4],"+
        "[1,5],"+
        "[2,6],"+
        "[3,0],"+
        "[4,1],"+
        "[5,2],"+
        "[0,3],"+
        "[1,4],"+
        "[2,5],"+
        "[3,6],"+
        "[4,0],"+
        "[5,1],"+
        "[0,2],"+
        "[1,3],"+
        "[2,4],"+
        "[3,5]"+
        "]"+
        "}"+
        "]"+
        "";
	    static JsonParser  parser=new JsonParser();
	    static JsonArray   rvJsonArray= (JsonArray) parser.parse(jsonString);
}
    return getIndexJsonArrayLocal.rvJsonArray;
}
}