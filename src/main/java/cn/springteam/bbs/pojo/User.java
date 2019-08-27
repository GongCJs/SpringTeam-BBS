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
@TableName("user")
public class User extends BasePOJO {
    @TableId("u_id")
    private String uId;

    private String uPassword;

    private String uSale;

}

