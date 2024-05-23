package com.example.library;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomToArray {

    public static Document invoke(String path) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(path));
    }

    public static Map<String, Object> getArray(String path) throws Exception {
        Document dom = invoke(path);
        Element root = dom.getDocumentElement();
        Map<String, Object> output = domnode_to_array(root);
        output.put("@root", root.getTagName());
        return output;
    }

    private static Map<String, Object> domnode_to_array(Node node) {
        Map<String, Object> output = new HashMap<>();
        switch (node.getNodeType()) {
            case Node.CDATA_SECTION_NODE:
            case Node.TEXT_NODE:
                output.put(node.getParentNode().getNodeName(), node.getNodeValue().trim());
                break;
            case Node.ELEMENT_NODE:
                NodeList nodeList = node.getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node childNode = nodeList.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        String tagName = childNode.getNodeName();
                        if (!output.containsKey(tagName)) {
                            output.put(tagName, new ArrayList<>());
                        }
                        List<Object> values = (List<Object>) output.get(tagName);
                        values.add(domnode_to_array(childNode));
                    }
                }
                break;
        }
        return output;
    }

}
