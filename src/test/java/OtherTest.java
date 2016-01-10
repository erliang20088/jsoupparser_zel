
public class OtherTest {
	public static void main(String[] args) {
		String str="abc&nbsp;kadlfa,&nbsp;asdkf&quot;,";
		
		str = str.replaceAll("(&nbsp;)|(&middot;)|(&quot;)|(&gt;)|(&lt;)", " ");
		
		System.out.println(str);
	}
}
