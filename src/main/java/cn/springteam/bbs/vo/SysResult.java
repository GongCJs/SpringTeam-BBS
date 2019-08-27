package cn.springteam.bbs.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * status:	200 执行正确 201 执行错误
 * msg:	 	提示信息
 * data:	携带的数据
 */

@ToString
@Data
@NoArgsConstructor
public class SysResult {
	Integer status = 200;
	String msg = "Success";
	Object data;

	public static SysResult fail(String msg){
		return new SysResult(201,msg);
	};

	public static SysResult success(Object data){
		return new SysResult(data);
	}
	public static SysResult success(){
		return new SysResult();
	}
	public static SysResult success(Integer status , String msg){
		return new SysResult(status,msg,null);
	}

	public SysResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	/** 错误时调用的构造函数 */
	private SysResult(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	/** 正确是返回携带的参数 */
	private SysResult(Object data) {
		this.data = data;
	}
}
