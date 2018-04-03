package estimate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import controller.*;
import service.*;
import doa.*;
import ifc.*;

public class Test {
	
	public static void main(String[] args) throws IOException {
		//String str=new String();
		//System.out.println(str.isEmpty());
		/*Timestamp ts=new Timestamp(Calendar.getInstance().getTimeInMillis());
		System.out.println(ts);
		Storage s=Storage.getInstance();
		String t="Justin Trying";
		s.setToken(t);
		System.out.println(s.getToken()==t);
		t="a";
		System.out.println(s.getToken());
		Map<IKey,String> m;
		m=getMap();
		ISourceTest src;
		String fs="service.Gather"+m.get(IKey.KEY_SOURCE);
		try {
			if(Class.forName(fs)!=null) {
				src=(ISourceTest)Class.forName(fs).getDeclaredConstructor().newInstance();
				((ISourceTest) src).set(m);
				System.out.println(s.formatSource(src));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		DataStore hr=DataStore.getInstance();
		String url="http://www.zhihu.com/question/37938821";
		String gets=hr.doGet(url);
		String posts;
		File f=new File("D:/37938821_get.html");
		OutputStream ots=new FileOutputStream(f);
		//OutputStreamWriter wr=new OutputStreamWriter(ots,"UTF-8");
		ots.write(gets.getBytes());
		ots.close();
		f=new File("D:/37938821_post.html");
		ots=new FileOutputStream(f);
		posts=hr.doPost(url, "");
		ots.write(posts.getBytes());
		ots.close();
	}
	
	private static Map<IKey, String> getMap() {
		Map<IKey,String> m=new HashMap<IKey,String>();
		m.put(IKey.KEY_LOCATOR, "http://www.zhihu.com/p/30145156/");
		m.put(IKey.KEY_SOURCE, "Zhihu");
		m.put(IKey.KEY_CONTENT, "To be or not to be.");
		m.put(IKey.KEY_AUTHOR, "William Shakespeare");
		m.put(IKey.KEY_CREATED, "latest of 16th centry or earlier of 17th centry");
		return m;
	}
}
