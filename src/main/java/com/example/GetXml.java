package com.example;


import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public  class GetXml   {

       /* Document对象(读xml文件)
        * return String字符串
        */
public String xmlToString(Document document) throws Throwable{
    TransformerFactory ft = TransformerFactory.newInstance();
    Transformer ff = ft.newTransformer();
    ff.setOutputProperty("encoding","utf-8");
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ff.transform(new DOMSource(document),new StreamResult(bos));
    return bos.toString();
}

}
