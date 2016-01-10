import java.util.LinkedList;
import java.util.List;

import com.vaolan.parser.JsoupHtmlParser;
import com.vaolan.status.DataFormatStatus;
import com.vaolan.utils.IOUtil;
import com.vaolan.utils.StaticValue;

public class RandomTest {
	public static void testCleanTest() {
		String fileName = "d:/test (2).txt";
		String htmlSource = IOUtil.readFile(fileName,
				StaticValue.default_encoding);

		String cleanTxt = JsoupHtmlParser.getCleanTxt(htmlSource);

		System.out.println(cleanTxt);
	}

	public static void testgetTagCleanTxt() {
		String fileName = "d:/test (2).txt";
		String htmlSource = IOUtil.readFile(fileName,
				StaticValue.default_encoding);

		String cleanTxt = JsoupHtmlParser.getTagContent(htmlSource, "a",
				DataFormatStatus.TagAllContent);

		System.out.println(cleanTxt);
	}

	public static void testGetNestTagContent() {
		String fileName = "d:/Noname5.txt";
		String htmlSource = IOUtil.readFile(fileName,
				StaticValue.default_encoding);

		List<String> tagList = new LinkedList<String>();

		tagList.add("a");
		tagList.add("big");

		List<String> cleanTxt = JsoupHtmlParser.getNestTagContent(htmlSource,
				tagList, DataFormatStatus.TagAllContent, true);

		System.out.println(cleanTxt);
	}

	public static void testGetNodeContentBySelector() {
		String fileName = "d:/Noname5.txt";
		String htmlSource = IOUtil.readFile(fileName,
				StaticValue.default_encoding);

		List<String> tagList = new LinkedList<String>();

		tagList.add("sss");
		tagList.add("kk");

		List<String> selList = new LinkedList<String>();

		selList.add("a");
		selList.add(".subBrand");
		// selList.add("big");
		List<String> cleanTxt = JsoupHtmlParser.getNodeContentBySelector(
				htmlSource, selList, DataFormatStatus.TagAllContent, true);

		if (cleanTxt != null) {
			for (String item : cleanTxt) {
				System.out.println(item);
			}
		} else {
			System.out.println("结果集为null");
		}

	}

	public static void main(String[] args) {
		String fileName = "d:/html.txt";
		String htmlSource = IOUtil.readFile(fileName,
				StaticValue.default_encoding);

		// List<String> list = JsoupHtmlParser.getAllHref(htmlSource);
		// String selector = "div";
		String selector = "h4";
		List<String> selectorList = new LinkedList<String>();
		selectorList.add(selector);
		// removeList.add("span");
		// String result = JsoupHtmlParser.removeInnerContent(htmlSource,
		// selector, removeList);
		// System.out.println("htmlSource="+htmlSource);
		List<String> list = JsoupHtmlParser.getNestTagContent(htmlSource,
				selectorList, false);
		// List<String> list = JsoupHtmlParser
		// .getNodeContentBySelector(htmlSource, selectorList,
		// DataFormatStatus.TagAllContent, false);
		// for (String url : list) {
		// System.out.println(url);
		// }

		System.out.println(list.size());
	}
}
