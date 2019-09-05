package core;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOM_Parser {

	public static void main(String[] args) throws Exception {

		String url = "http://alex.academy/ebay.xml";

		String node = "kadu-response";

		String element_01 = "orig-kw";
		String element_02 = "engine";
		String element_03 = "kadu-version";
		String element_04 = "response-time";
		String element_05 = "deals";
		String element_06 = "price"; // added
		String element_07 = "addon"; //added
		String attribute_01 = "count";
		String attribute_02 = "discount"; //added

		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document doc = b.parse(url);

		// Optional
		doc.getDocumentElement().normalize();

		// Parsing elements
		System.out.println("Key Word: \t " + 	((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_01).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Engine: \t " + 		((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_02).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Version: \t " + 	((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_03).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Response time: \t " + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_04).item(0).getChildNodes().item(0).getNodeValue());
		System.out.println("Price: \t " + 		((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(element_06).item(0).getChildNodes().item(0).getNodeValue());

		
		// Parsing attribute
		System.out.println("Number of deals: " + ((Element) doc.getElementsByTagName(element_05).item(0)).getAttribute(attribute_01).trim());
		System.out.println("Discount: " + ((Element) doc.getElementsByTagName(element_07).item(0)).getAttribute(attribute_02).trim());
	}
}