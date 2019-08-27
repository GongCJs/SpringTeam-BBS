package cn.springteam.bbs.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
@ToString
@Data
@Accessors(chain = true)
@TableName("message")
public class Message extends BasePOJO {
    @TableId("m_id")
    private String mId;
    @TableId("u_id_from")
    private String uIdFrom;

    private String uIdTo;

    private String mContent;


}