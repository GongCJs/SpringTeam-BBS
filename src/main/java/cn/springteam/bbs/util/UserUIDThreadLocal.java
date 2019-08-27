package cn.springteam.bbs.util;

public class UserUIDThreadLocal {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	
	public static void set(String user) {
		threadLocal.set(user);
	}
	
	public static String get() {
		return threadLocal.get();
	}
	
	public static void remove() {
		threadLocal.remove();
	}
}
