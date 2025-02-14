package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.MenuDto;
import com.xavier.pms.model.Menu;
import com.xavier.pms.resp.MenuVo;
import com.xavier.pms.resp.RouterVo;
import com.xavier.pms.resp.UserInfoVo;

import java.util.List;

/**
 * 业务逻辑层-菜单接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IMenuService extends IService<Menu> {


    /**
     * 获取当前登录用户的菜单
     *
     * @param userInfoVo 登录用户
     */
    List<RouterVo> getUserMenu(UserInfoVo userInfoVo);

    /**
     * 获取所有菜单树
     *
     * @param userInfoVo 登录用户
     * @return
     */
    List<MenuVo> getTree(UserInfoVo userInfoVo);

    /**
     * 删除菜单
     *
     * @param id
     */
    void deleteMenu(Long id);

    /**
     * 创建菜单
     *
     * @param menuDto 菜单入参
     */
    void createMenu(MenuDto menuDto);

    /**
     * 更新菜单
     *
     * @param menuDto 菜单入参
     */
    void updateMenu(MenuDto menuDto);

    /**
     * 根据ID获取菜单信息
     *
     * @param id
     * @return 菜单信息
     */
    MenuVo getMenu(Long id);

    /**
     * 根据ID获取菜单信息
     *
     * @param id
     * @return 菜单信息
     */
    Menu getBaseMenu(Long id);

}
