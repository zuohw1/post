package cn.chinaunicom.resplist.controller;

import cn.chinaunicom.platform.utils.MessageResponse;
import cn.chinaunicom.resplist.entity.EhrcucPosElementStructure;
import cn.chinaunicom.resplist.entity.RespsInfo;
import cn.chinaunicom.resplist.service.EhrcucPosElementStructureService;
import cn.chinaunicom.utils.FileUtil;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ************************************** 描述: 关键职责职级列表
 * 
 * @ClassName: cn.chinaunicom.func.controller.FuncRegisterController
 * @author wangrunpu
 * @since 2018-11-01
 * @version V1.0 **************************************
 */
@Api(
		value = "关键职责职级列表",
		tags = "关键职责职级列表")
@CrossOrigin(
		origins = "*",
		maxAge = 3600)
@RestController
@RequestMapping("/api/PosElementStructure")
public class EhrcucPosElementStructureController {

	@Autowired
    EhrcucPosElementStructureService service;

	@ApiOperation(
			value = "列表",
			notes = "接口发布说明",
			response = EhrcucPosElementStructure.class,
			httpMethod = "GET")
	@ApiImplicitParams({ @ApiImplicitParam(
			name = "x-token-code",
			value = "用户登录令牌",
			paramType = "header",
			dataType = "String",
			required = true,
			defaultValue = "xjMjL0m2A6d1mOIsb9uFk+wuBIcKxrg4") })
	@ApiResponses({ @ApiResponse(
			code = 200,
			message = "获取数据成功",
			response = Page.class),
			@ApiResponse(
					code = 404,
					message = "未查询到数据") })
	@GetMapping("/list")
	public ResponseEntity<Object> getEhrcucPosElementStructureList() {
		List<EhrcucPosElementStructure> list = service.getEhrcucPosElementStructureList();
		if (list == null)
		{
			list = new ArrayList<EhrcucPosElementStructure>();
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ApiOperation(
			value = "保存",
			notes = "接口发布说明",
			response = MessageResponse.class,
			httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(
			name = "x-token-code",
			value = "用户登录令牌",
			paramType = "header",
			dataType = "String",
			required = true,
			defaultValue = "xjMjL0m2A6d1mOIsb9uFk+wuBIcKxrg4") })
	@ApiResponses({ @ApiResponse(
			code = 200,
			message = "添加成功") })
	@PostMapping("/save")
	public ResponseEntity<Object> saveEhrcucPosElementStructure(EhrcucPosElementStructure entity) {
		MessageResponse vo = new MessageResponse();
		Integer i = service.saveEhrcucPosElementStructure(entity);
		if (i > 0)
		{
			vo.setMsg("添加成功");
		} else
		{
			vo.setMsg("添加失败");
		}
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}

	/**
	 * 查询条件: 职责范围
	 * 
	 * @return ResponseEntity<Object>
	 */
	@ApiOperation(
			value = "查询条件: 职责范围",
			notes = "接口发布说明",
			httpMethod = "POST")
	@PostMapping("/queryRespRange")
	public ResponseEntity<Object> queryRespRange() {
		return new ResponseEntity<>(service.queryRespRange(), HttpStatus.OK);
	}

	/**
	 * 查询: 关键职责查询
	 * 
	 * @return ResponseEntity<Object>
	 */
	@ApiOperation(
			value = "查询: 关键职责查询",
			notes = "接口发布说明",
			httpMethod = "POST")
	@PostMapping("/queryRespsInfo")
	@ResponseBody
	public Map<String, Object> queryRespsInfo(@RequestParam(value="sequence",required=false) String sequence, @RequestParam(value="respName",required=false) String respName, @RequestParam(value="status",required=false) String status,
			@RequestParam(value="levelType",required=false) String[] levelTypes, @RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum) {
		String levelType = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (levelTypes != null && levelTypes.length > 0)
		{
			for (int i = 0; i < levelTypes.length; i++)
			{
				levelType += levelTypes[i] + ".";
			}
		}
		int pNum = Integer.parseInt(pageNum);
		int pSize = Integer.parseInt(pageSize);
		List<RespsInfo> respList = service.queryRespsInfo(sequence, respName, levelType, pSize, pNum);
		int total = service.getTotalResps(sequence, respName, levelType);
		resultMap.put("data", respList);
		resultMap.put("totalnum", total);
		return resultMap;
	}

	/**
	 * 导出: 关键职责导出
	 * 
	 * @return VOID
	 */
	@ApiOperation(
			value = "导出: 关键职责导出",
			notes = "接口发布说明",
			httpMethod = "POST")
	@PostMapping("/exportRespsInfo")
	@ResponseBody
	public void exportRespsInfo(@RequestParam(value="sequence",required=false) String sequence, @RequestParam(value="respName",required=false) String respName, @RequestParam(value="status",required=false) String status,
			@RequestParam(value="levelType",required=false) String[] levelTypes, @RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum, HttpServletResponse resp) {
		String levelType = "";
		if (levelTypes != null && levelTypes.length > 0)
		{
			for (int i = 0; i < levelTypes.length; i++)
			{
				levelType += levelTypes[i] + ".";
			}
		}
		int pNum = Integer.parseInt(pageNum);
		int pSize = Integer.parseInt(pageSize);
		FileUtil.exportExcel(service.queryRespsInfo(sequence, respName, levelType, pSize, pNum), null, null, RespsInfo.class, "关键职责查询.xls", resp);
	}
}
