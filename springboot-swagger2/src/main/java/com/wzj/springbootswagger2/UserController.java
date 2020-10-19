package com.wzj.springbootswagger2;

import com.wzj.springbootswagger2.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhijian.wang
 * @package com.wzj.springbootswagger2
 * @description:
 * @date 2020/10/19 16:19
 */
@ApiModel
@RestController
@Api(tags = "用户接口")
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "获取用户信息")
    @ApiResponses(@ApiResponse(message = "获取用户信息", code = 200))
    @PostMapping(value = "/get")
    public UserVo get() {
        UserVo userVo = new UserVo();
        userVo.setName("张三");
        userVo.setSex("男");
        userVo.setAge("18");
        return userVo;
    }
}
