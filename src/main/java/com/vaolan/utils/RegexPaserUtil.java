package com.vaolan.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式处理工具类，字符串的匹配截取中
 * 
 * @author zel
 * 
 */
public class RegexPaserUtil {

	private String beginRegex;

	private String endRegex;

	private Matcher matcher;

	public final static String TEXTTEGEX = ".*?";

	public final static String W = "\\W*?";

	public final static String N = "";

	public final static String TEXTEGEXANDNRT = "[\\s\\S]*?";
	public final static String zel_all_chars = "[\\s\\S]*";

	private List<String> filterRegexList = new ArrayList<String>();

	public RegexPaserUtil(String beginRegex, String endRegex, String content,
			String textRegex) {

		this.beginRegex = beginRegex;

		this.endRegex = endRegex;

		StringBuilder sb = new StringBuilder();

		sb.append(beginRegex);

		sb.append(textRegex);

		sb.append(endRegex);
		matcher = Pattern.compile(sb.toString()).matcher(content);
	}

	// 此处的content变量暂未用
	public RegexPaserUtil(String beginRegex, String textRegex, String endRegex,
			String content, String flag) {
		this.beginRegex = beginRegex;

		this.endRegex = endRegex;

		StringBuilder sb = new StringBuilder();

		sb.append(beginRegex);

		sb.append(textRegex);

		sb.append(endRegex);
		// System.out.println("sb--------------" + sb);
		matcher = Pattern.compile(sb.toString()).matcher(content);
	}

	public RegexPaserUtil(String beginRegex, String endRegex, String textRegex) {

		this.beginRegex = beginRegex;

		this.endRegex = endRegex;

		StringBuilder sb = new StringBuilder();

		sb.append(beginRegex);

		sb.append(textRegex);

		sb.append(endRegex);
		matcher = Pattern.compile(sb.toString()).matcher(N);
	}

	public RegexPaserUtil(String beginRegex, String endRegex) {

		this.beginRegex = beginRegex;

		this.endRegex = endRegex;

		StringBuilder sb = new StringBuilder();

		sb.append(beginRegex);

		sb.append(TEXTTEGEX);

		sb.append(endRegex);

		matcher = Pattern.compile(sb.toString()).matcher(N);
	}

	public String getSimpleText() {
		if (matcher.find()) {
			String str = matcher.group().trim();
			return str;
		}
		return null;
	}

	public String getText() {
		if (matcher.find()) {
			String str = matcher.group().trim().replaceFirst(beginRegex, N)
					.replaceAll(endRegex, N);
			Iterator<String> it = filterRegexList.iterator();
			while (it.hasNext()) {
				str = str.replaceAll(it.next(), N);
			}
			return str;
		}
		return null;
	}

	public String getLastText() {
		String str = null;
		while (matcher.find()) {
			str = matcher.group().trim().replaceFirst(beginRegex, N)
					.replaceAll(endRegex, N);
		}
		return str;
	}

	public String getNext() {
		return matcher.group();
	}

	public String getNextTxt() {
		String str = matcher.group().trim().replaceFirst(beginRegex, N)
				.replaceAll(endRegex, N);
		Iterator<String> it = filterRegexList.iterator();
		while (it.hasNext()) {
			str = str.replaceAll(it.next(), N);
		}
		return str;
	}

	/**
	 * 是指过滤了相关标签
	 * 
	 * @return
	 */
	public String getNextAddFilter() {
		String str = matcher.group();
		Iterator<String> it = filterRegexList.iterator();
		while (it.hasNext()) {
			str = str.replaceAll(it.next(), N);
		}
		return str;
	}

	/**
	 * 循环遍历时，得到真正的txt,而不是匹配全部
	 * 
	 * @return
	 */
	public String getNextText() {
		String str = matcher.group();
		str = str.replaceFirst(beginRegex, N).replaceAll(endRegex, N);
		return str;
	}

	public boolean hasNext() {
		return matcher.find();
	}

	public RegexPaserUtil reset(String content) {
		this.matcher.reset(content);
		return this;
	}

	public RegexPaserUtil addFilterRegex(String filterRegex) {
		filterRegexList.add(filterRegex);
		return this;
	}

	public String getTextList() {
		String str = "";
		int count = 0;
		while (matcher.find()) {
			if (count == 0) {
				str = matcher.group().trim().replaceFirst(beginRegex, N)
						.replaceAll(endRegex, N);
			} else {
				str += ("#" + matcher.group().trim()
						.replaceFirst(beginRegex, N).replaceAll(endRegex, N));
			}
			count++;
		}
		return str;
	}

	public static void main(String[] args) {
		String beginRegex = "<dd" + RegexPaserUtil.TEXTEGEXANDNRT + "</a>";
		String endRegex = "<span>";
		String text = "<dd>    <a a b c>1</a>//@<a b c d>2</a>3 4<span>";
		RegexPaserUtil ansjSayUrl = new RegexPaserUtil(beginRegex, endRegex,
				text, RegexPaserUtil.TEXTEGEXANDNRT);

		System.out.println(ansjSayUrl.getText());

	}

}
