package com.xavier.pms.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xavier.pms.constants.Constant;
import com.xavier.pms.convertor.MenuConvertor;
import com.xavier.pms.dao.MenuMapper;
import com.xavier.pms.req.MenuDto;
import com.xavier.pms.utils.ServiceException;
import com.xavier.pms.model.Menu;
import com.xavier.pms.result.ResultCode;
import com.xavier.pms.service.IMenuService;
import com.xavier.pms.service.IPostService;
import com.xavier.pms.resp.MenuVo;
import com.xavier.pms.resp.PostVo;
import com.xavier.pms.resp.RouterVo;
import com.xavier.pms.resp.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 业务逻辑层-菜单实现类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private IPostService postService;

    @Override
    public List<RouterVo> getUserMenu(UserInfoVo userInfoVo) {
        return MenuConvertor.toRouterVoList(getUserMenuList(userInfoVo));
    }

    private List<Menu> getUserMenuList(UserInfoVo userInfoVo) {
        if (userInfoVo.getIsAdmin()) {
            return list(Menu.gw()
                    .eq(Menu::getIsEnable, 1)
                    .in(Menu::getMenuType, CollUtil.newArrayList(Constant.MENU_DIRECTORY, Constant.MENU_MENU)));
        }
        // 非管理员的菜单
        PostVo postVo = postService.getPost(userInfoVo.getPostId());
        if (CollUtil.isNotEmpty(postVo.getRoleIdList())) {
            return baseMapper.getUserMenuList(postVo.getRoleIdList(), CollUtil.newArrayList(Constant.MENU_DIRECTORY, Constant.MENU_MENU));
        }
        return new ArrayList<>();
    }

    @Override
    public List<MenuVo> getTree(UserInfoVo userInfoVo) {
        List<Menu> list = new ArrayList<>();
        if (userInfoVo.getIsAdmin()) {
            list = list(Menu.gw().eq(Menu::getIsEnable, 1));
        }
        // todo 非管理员的菜单
        return MenuConvertor.toTree(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Long id) {
        getBaseMenu(id);
        super.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMenu(MenuDto menuDto) {
        Menu menu = MenuConvertor.toMenu(menuDto);
        menu.setId(null);
        super.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuDto menuDto) {
        getBaseMenu(menuDto.getId());
        Menu menu = MenuConvertor.toMenu(menuDto);
        super.updateById(menu);
    }

    @Override
    public MenuVo getMenu(Long id) {
        return MenuConvertor.toMenuVo(getBaseMenu(id));
    }


    @Override
    public Menu getBaseMenu(Long id) {
        Menu menu = super.getById(id);
        if (Objects.isNull(menu)) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST, "菜单");
        }
        return menu;
    }


}
