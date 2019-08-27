package cn.springteam.bbs.pojo;

import lombok.Data;
import lombok.Synchronized;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@ToString
@Data
@Accessors(chain = true)
public class BasePOJO implements Serializable {
	private Date createTime;
	private Date updateTime;
}
