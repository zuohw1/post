package cn.chinaunicom.duty.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;

import cn.chinaunicom.duty.entity.PosElement;
import cn.chinaunicom.duty.entity.PosElementEmp;
import cn.chinaunicom.platform.dao.HrBaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lizhenhao
 * @since 2018-11-01
 */
public interface PosElementMapper extends HrBaseMapper<PosElement> {

	List<PosElement> getElementList(Integer versionId);

	List<PosElement> getSubList(@Param("versionId") Integer versionId, @Param("posCateId") Integer posCateId);

	List<PosElement> getPosElementPagList(Page<PosElement> objectPage, Map<String, Object> params);

	List<PosElementEmp> getPosElementPagList(Map<String, Object> params);

}