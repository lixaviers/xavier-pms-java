package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.PostDto;
import com.xavier.pms.req.PostQueryDto;
import com.xavier.pms.model.Post;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.resp.PostVo;

import java.util.List;

/**
 * 业务逻辑层-职位接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IPostService extends IService<Post> {

    /**
     * 删除职位
     *
     * @param idList
     */
    void deletePost(List<Long> idList);

    /**
     * 创建职位
     *
     * @param postDto 职位入参
     */
    void createPost(PostDto postDto);

    /**
     * 更新职位
     *
     * @param postDto 职位入参
     */
    void updatePost(PostDto postDto);

    /**
     * 根据ID获取职位信息
     *
     * @param id
     * @return 职位信息
     */
    PostVo getPost(Long id);

    /**
     * 根据ID获取职位信息
     *
     * @param id
     * @return 职位信息
     */
    Post getBasePost(Long id);

    /**
     * 分页查询职位信息
     *
     * @param postQueryDto 职位查询入参
     * @return 职位信息
     */
    QueryResultVo<PostVo> queryPost(PostQueryDto postQueryDto);



}
