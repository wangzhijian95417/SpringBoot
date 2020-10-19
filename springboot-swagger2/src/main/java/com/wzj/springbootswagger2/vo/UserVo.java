package com.wzj.springbootswagger2.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhijian.wang
 * @package com.wzj.springbootswagger2.vo
 * @description: 用户
 * @date 2020/10/19 15:45
 */
@Data
@ApiModel
public class UserVo {
    @ApiModelProperty(value = "名称",example = "张三")
    private String name;
    @ApiModelProperty(value = "性别",example = "男/女")
    private String sex;
    @ApiModelProperty(value = "年龄",example = "18")
    private String age;
}
